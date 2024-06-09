package object_orienters.techspot.messages_service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FirestoreChatterRepository {

    private final Firestore firestore;
    private final ContentServiceProxy contentServiceProxy;

    @Autowired
    public FirestoreChatterRepository(Firestore firestore, ContentServiceProxy contentServiceProxy) {
        this.firestore = firestore;
        this.contentServiceProxy = contentServiceProxy;
    }

    public String saveChatter(Chatter chatter) {
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("Chatters").document(chatter.getUsername())
                .set(chatter);
        return "Chatter saved";
    }

    public Optional<Chatter> getChatter(String username) throws ExecutionException, InterruptedException {
        return Optional
                .ofNullable(firestore.collection("Chatters").document(username).get().get().toObject(Chatter.class));
    }

    public List<Chatter> getChattersByStatus(Status status) throws ExecutionException, InterruptedException {
        return firestore.collection("Chatters").whereEqualTo("status", status).get().get().toObjects(Chatter.class);
    }

    public List<Chatter> getChattersByFollowship(String username) throws Exception {
        ResponseEntity<?> followersResponse = contentServiceProxy.Followers(username, 0, 10);
        ResponseEntity<?> followingResponse = contentServiceProxy.Following(username, 0, 10);

        if (!followersResponse.getStatusCode().is2xxSuccessful()
                || !followingResponse.getStatusCode().is2xxSuccessful()) {
            throw new IllegalStateException("Failed to fetch profiles");
        }

        ObjectMapper followersMapper = new ObjectMapper();
        String followersData = followersMapper.writeValueAsString(followersResponse.getBody());

        Map<String, Object> followersBody = followersMapper.readValue(followersData, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> followersEmbedded = (Map<String, Object>) followersBody.get("_embedded");
        List<Map<String, Object>> followersProfiles = (List<Map<String, Object>>) followersEmbedded.get("profileList");




        ObjectMapper followingMapper = new ObjectMapper();
        String followingData = followingMapper.writeValueAsString(followingResponse.getBody());

        Map<String, Object> followingBody = followingMapper.readValue(followingData, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> followingEmbedded = (Map<String, Object>) followingBody.get("_embedded");
        List<Map<String, Object>> followingProfiles = (List<Map<String, Object>>) followingEmbedded.get("profileList");



        return Stream.concat(followersProfiles.stream(), followingProfiles.stream()).distinct().map(profile -> {
            String usernamee = (String) profile.get("username");
            String name = (String) profile.get("name");
            Chatter chatter = new Chatter();
            chatter.setUsername(usernamee);
            chatter.setFullName(name);
            chatter.setStatus(Status.ONLINE);
            return chatter;
        }).collect(Collectors.toList());


    }
}


