package object_orienters.techspot.content_service.feed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import object_orienters.techspot.content_service.content.Content;
import object_orienters.techspot.content_service.content.ContentRepository;
import object_orienters.techspot.content_service.content.ContentType;
import object_orienters.techspot.content_service.content.Privacy;
import object_orienters.techspot.content_service.profile.Profile;

import java.util.List;

@Service
public class FeedByFollowingStrategy extends Strategy<Content, Profile> {
    @Autowired
    public FeedByFollowingStrategy(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Page<Content> operate(Profile profile, int pageNumber, int pageSize) {
        return contentRepository.findAllByMainAuthorsAndContentTypeAndPrivacy(profile.getFollowing(),
                List.of(Privacy.PUBLIC, Privacy.FRIENDS), List.of(ContentType.Post, ContentType.SharedPost), PageRequest.of(pageNumber, pageSize, Sort.by("timestamp").descending()));
    }
}