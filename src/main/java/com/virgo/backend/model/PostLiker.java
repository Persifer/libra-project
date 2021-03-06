package com.virgo.backend.model;

import com.virgo.backend.model.Liker;
import com.virgo.backend.model.Post;
import com.virgo.backend.model.compoundkeys.PostLikerCompounKey;

import javax.persistence.*;

@Entity
public class PostLiker {

    @EmbeddedId
    private PostLikerCompounKey idPostLiker;

    @ManyToOne
    @MapsId("idPost")
    @JoinColumn(name="id_post")
    private Post post;

    @ManyToOne
    @MapsId("idLiker")
    @JoinColumn(name="id_liker")
    private Liker liker;

    public PostLiker() {
        super();
    }

    public PostLiker(Post post, Liker liker) {
        this.post = post;
        this.liker = liker;
    }

    public PostLiker(PostLikerCompounKey idPostLiker, Post post, Liker liker) {
        this.idPostLiker = idPostLiker;
        this.post = post;
        this.liker = liker;
    }

    public PostLikerCompounKey getIdPostLiker() {
        return idPostLiker;
    }

    public void setIdPostLiker(PostLikerCompounKey idPostLiker) {
        this.idPostLiker = idPostLiker;
    }
}
