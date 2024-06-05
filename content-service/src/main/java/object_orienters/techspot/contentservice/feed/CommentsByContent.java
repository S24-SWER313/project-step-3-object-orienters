// package object_orienters.techspot.contentservice.feed;


// import object_orienters.techspot.contentservice.comment.Comment;
// import object_orienters.techspot.contentservice.comment.CommentRepository;
// import object_orienters.techspot.contentservice.content.ReactableContentRepository;
// import object_orienters.techspot.contentservice.exceptions.ContentNotFoundException;
// import object_orienters.techspot.contentservice.exceptions.PostNotFoundException;
// import object_orienters.techspot.contentservice.utilities.PermissionService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Service;

// @Service
// public class CommentsByContent extends Strategy<Comment, Long> {

//     private final PermissionService permissionService;
//     @Autowired
//     public CommentsByContent(ReactableContentRepository reactableContentRepository, CommentRepository commentRepository, PermissionService permissionService) {
//         this.reactableContentRepository = reactableContentRepository;
//         this.commentRepository = commentRepository;
//         this.permissionService = permissionService;
//     }

//     public Page<Comment> operate(Long  contentID, int pageNumber, int pageSize) {
//         String currentUserPrincipal = SecurityContextHolder.getContext().getAuthentication().getName();
//         try {
//             if (!permissionService.canAccessPost(contentID, currentUserPrincipal))
//                 return Page.empty();
//         } catch (PostNotFoundException e) {
//             throw new ContentNotFoundException(contentID);
//         }
//         return commentRepository.findByCommentedOn(reactableContentRepository.findByContentID(contentID).orElseThrow(() -> new ContentNotFoundException(contentID )), PageRequest.of(pageNumber, pageSize, Sort.by("timestamp").descending()));
//     }

// }