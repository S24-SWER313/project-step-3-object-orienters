package object_orienters.techspot.content_service.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Data;
import object_orienters.techspot.content_service.content.ContentType;
import object_orienters.techspot.content_service.content.ReactableContent;


@Entity
@Table(name = "post")
@Valid
@Data
public class Post extends ReactableContent {


    private int numOfShares;

    private String tags;


    public Post() {
        this.setContentType(ContentType.Post);
    }

    public String toString() {
        return "Post{" +
                "contentId=" + getContentID() +
                ", author=" + this.getContentAuthor().getUsername() +
                ", content='" + this.getMediaData() + '\'' +
                ", privacy=" + this.getPrivacy() +
                // ", numOfComments=" + this.getNumOfComments() +
                // ", numOfReactions=" + this.getNumOfReactions() +
                ", numOfShares=" + numOfShares +
                '}';

    }


    @Override
    public ContentType getContentType() {
        return ContentType.Post;
    }

}
