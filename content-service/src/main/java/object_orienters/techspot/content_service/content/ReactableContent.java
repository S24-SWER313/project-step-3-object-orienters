package object_orienters.techspot.content_service.content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import object_orienters.techspot.content_service.comment.Comment;
import object_orienters.techspot.content_service.dataTypes.DataType;
<<<<<<< HEAD
=======
import object_orienters.techspot.content_service.post.Post;
>>>>>>> 0a48d510b9c823a20f2d8cea86e6fccd8f9aaeff
import object_orienters.techspot.content_service.reaction.Reaction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "ReactableContent")
@Data
public abstract class ReactableContent extends Content {

    @OneToMany(mappedBy = "content", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DataType> mediaData;

    @Column(length = 2000)
    private String textData;

    @JsonIgnore
<<<<<<< HEAD
    @OneToMany(mappedBy = "content", fetch = FetchType.EAGER, cascade =
    CascadeType.ALL, orphanRemoval = true)
    private List<Reaction> reactions;

    @JsonIgnore
    @OneToMany(mappedBy = "commentedOn", fetch = FetchType.EAGER, cascade =
    CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    private int numOfComments;
    private int numOfReactions;

    public ReactableContent() {
    this.reactions = new ArrayList<>();
    this.comments = new ArrayList<>();
=======
    @OneToMany(mappedBy = "content", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reaction> reactions;

    // @JsonIgnore
    // @OneToMany(mappedBy = "commentedOn", fetch = FetchType.EAGER, cascade =
    // CascadeType.ALL, orphanRemoval = true)
    // //private List<Comment> comments;
    // private int numOfComments;
    private int numOfReactions;

    public ReactableContent() {
        this.reactions = new ArrayList<>();
        // this.comments = new ArrayList<>();
>>>>>>> 0a48d510b9c823a20f2d8cea86e6fccd8f9aaeff
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Post))
            return false;
        return this.getContentID() != null && this.getContentID().equals(((Post) o).getContentID());
    }

}
