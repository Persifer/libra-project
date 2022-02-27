package com.virgo.backend.model.compoundkeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostUnlikerComposedKey implements Serializable {

    @Column(name = "id_post")
    private Integer idPost;

    @Column(name = "id_post")
    private Integer idUnlike;

    public PostUnlikerComposedKey() {
        super();
    }

    public PostUnlikerComposedKey(Integer idPost, Integer idUnlike) {
        this.idPost = idPost;
        this.idUnlike = idUnlike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUnlikerComposedKey that = (PostUnlikerComposedKey) o;
        return Objects.equals(idPost, that.idPost) && Objects.equals(idUnlike, that.idUnlike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost, idUnlike);
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Integer getIdUnlike() {
        return idUnlike;
    }

    public void setIdUnlike(Integer idUnlike) {
        this.idUnlike = idUnlike;
    }
}
