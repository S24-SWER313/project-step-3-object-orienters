// package object_orienters.techspot.contentservice.feed;

// import object_orienters.techspot.contentservice.model.Privacy;
// import object_orienters.techspot.contentservice.post.Post;
// import object_orienters.techspot.contentservice.post.PostRepository;
// import object_orienters.techspot.contentservice.profile.Profile;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class FeedByAuthor extends Strategy<Post, Profile> {
//     @Autowired
//     public FeedByAuthor(PostRepository postRepository) {
//         this.postRepository = postRepository;
//     }

//     public Page<Post> operate(Profile profile, int pageNumber, int pageSize) {
//         String currentUserPrincipal = SecurityContextHolder.getContext().getAuthentication().getName();
//         List<Privacy> privacies = List.of(Privacy.PUBLIC);
//         if (profile.getUsername().equals(currentUserPrincipal))
//             privacies = List.of(Privacy.PUBLIC, Privacy.FRIENDS, Privacy.PRIVATE);
//         else if (profile.getFollowers().contains(currentUserPrincipal))
//             privacies.add(Privacy.FRIENDS);
//         return postRepository.findPostsByContentAuthorsAndPrivacy(List.of(profile), privacies, PageRequest.of(pageNumber, pageSize, Sort.by("timestamp").descending()));
//     }

// }