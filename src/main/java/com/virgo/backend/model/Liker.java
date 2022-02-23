package com.virgo.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Liker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLike;

    @ManyToMany(mappedBy = "likeRilasciati")
    private List<Utente> utente;

    @ManyToMany(mappedBy = "liker")
    private List<Post> post;

    public Liker() {
        super();
    }

    public Liker(Integer idLike, List<Utente> utente, List<Post> post) {
        this.idLike = idLike;
        this.utente = utente;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Like{" +
                "idLike=" + idLike +
                ", utente=" + utente +
                ", post=" + post +
                '}';
    }

    public Integer getIdLike() {
        return idLike;
    }

    public void setIdLike(Integer idLike) {
        this.idLike = idLike;
    }

    public List<Utente> getUtente() {
        return utente;
    }

    public void setUtente(List<Utente> utente) {
        this.utente = utente;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
