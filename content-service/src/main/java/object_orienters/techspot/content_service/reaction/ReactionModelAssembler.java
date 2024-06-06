package object_orienters.techspot.content_service.reaction;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import object_orienters.techspot.content_service.profile.ProfileController;

@Component
public class ReactionModelAssembler implements RepresentationModelAssembler<Reaction, EntityModel<Reaction>> {
        @Override
        @NonNull
        public EntityModel<Reaction> toModel(@NonNull Reaction entity) {
                // return EntityModel.of(entity,
                //                 linkTo(methodOn(ProfileController.class).one(entity.getReactor().getUsername()))
                //                                 .withRel("reactor"),
                //                 // linkTo(methodOn(PostController.class).getPost(entity.getContent().getContentID(),
                //                 //                 entity.getContent().getContentAuthor().getUsername())).withRel("post")
                //                                //,
                //                 linkTo(methodOn(ReactionController.class)

                //                                 .getReactions(entity.getContent().getContentID(), 0, 10))
                //                                 .withRel("reactions"));
                return null;
        }

}

