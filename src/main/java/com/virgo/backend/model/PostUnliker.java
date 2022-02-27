package com.virgo.backend.model;

import com.virgo.backend.model.compoundkeys.PostUnlikerComposedKey;

import javax.persistence.*;

@Entity
public class PostUnliker {

    @EmbeddedId
    private PostUnlikerComposedKey id;

    @ManyToOne
    @MapsId("idPost")
    @JoinColumn(name = "id_post")
    private Post post;

    @ManyToOne
    @MapsId("idUnlike")
    @JoinColumn(name = "id_unlike")
    private Unlike unlike;

    public PostUnliker() {
        super();
    }

    public PostUnliker(PostUnlikerComposedKey id, Post post, Unlike unlike) {
        this.id = id;
        this.post = post;
        this.unlike = unlike;
    }

    public PostUnlikerComposedKey getId() {
        return id;
    }

    public void setId(PostUnlikerComposedKey id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Unlike getUnlike() {
        return unlike;
    }

    public void setUnlike(Unlike unlike) {
        this.unlike = unlike;
    }
}
