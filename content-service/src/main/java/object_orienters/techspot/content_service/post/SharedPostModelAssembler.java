package object_orienters.techspot.content_service.post;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import object_orienters.techspot.content_service.profile.ProfileController;

@Component
public class SharedPostModelAssembler implements RepresentationModelAssembler<SharedPost, EntityModel<SharedPost>> {
    @Override
    @Nonnull
    public EntityModel<SharedPost> toModel(@Nonnull SharedPost entity) {
        // return EntityModel.of(entity,
        // linkTo(methodOn(PostController.class).getPost(entity.getContentID(),
        // entity.getSharer().getUsername())).withSelfRel(),
        // linkTo(methodOn(PostController.class).getPost(entity.getPost().getContentID(),
        // entity.getPost().getContentAuthor().getUsername())).withRel("originalPost"),
        // linkTo(methodOn(ProfileController.class).one(entity.getSharer().getUsername())).withRel("sharer"),
        // linkTo(methodOn(ProfileController.class).one(entity.getPost().getContentAuthor().getUsername()))
        // .withRel("author"));

        return null;
    }
}
