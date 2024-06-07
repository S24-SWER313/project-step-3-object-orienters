package object_orienters.techspot.content_service.tag;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import object_orienters.techspot.content_service.feed.FeedController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TagsAssembler implements RepresentationModelAssembler<Tag, EntityModel<Tag>> {
    @Override
    public EntityModel<Tag> toModel(Tag entity) {
        //String clientUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        return EntityModel.of(entity)
                .add(
                        linkTo(methodOn(FeedController.class)
                                .feed("TOPIC", entity.getTagName().toLowerCase(), 0, 10))
                                .withRel("tagFeed")
                );
    }
}
