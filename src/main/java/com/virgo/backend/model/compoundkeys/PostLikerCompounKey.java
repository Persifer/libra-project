package com.virgo.backend.model.compoundkeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostLikerCompounKey implements Serializable {

    @Column(name = "id_post")
    private Integer idPost;

    @Column(name = "id_liker")
    private Integer idLiker;

    public PostLikerCompounKey() {
        super();
    }

    public PostLikerCompounKey(Integer idPost, Integer idLiker) {
        this.idPost = idPost;
        this.idLiker = idLiker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostLikerCompounKey that = (PostLikerCompounKey) o;
        return Objects.equals(idPost, that.idPost) && Objects.equals(idLiker, that.idLiker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost, idLiker);
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Integer getIdLiker() {
        return idLiker;
    }

    public void setIdLiker(Integer idLiker) {
        this.idLiker = idLiker;
    }
}
