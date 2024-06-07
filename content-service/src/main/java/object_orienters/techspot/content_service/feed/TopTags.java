package object_orienters.techspot.content_service.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import object_orienters.techspot.content_service.tag.Tag;
import object_orienters.techspot.content_service.tag.TagRepository;

@Service
public class TopTags extends Strategy<Tag, String> {

    //private TagRepository tagRepository;

    @Autowired
    public TopTags(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    Page<Tag> operate(String factor, int pageNumber, int pageSize) {
        return tagRepository.findMostPopularTags(PageRequest.of(pageNumber, pageSize));
    }
}
