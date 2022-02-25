package com.virgo.backend.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Liker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLike;

    @Column(nullable = false)
    private OffsetDateTime dataPublicazione;

   @OneToMany(mappedBy = "liker")
    private Set<UserLiker> utente;

    @ManyToMany(mappedBy = "liker")
    private List<Post> post;

    public Liker() {
        super();
    }

    public Liker(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public Liker(OffsetDateTime dataPublicazione, Set<UserLiker> utente, List<Post> post) {
        this.dataPublicazione = dataPublicazione;
        this.utente = utente;
        this.post = post;
    }

    public Liker(Integer idLike, OffsetDateTime dataPublicazione, Set<UserLiker> utente, List<Post> post) {
        this.idLike = idLike;
        this.dataPublicazione = dataPublicazione;
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

    public Set<UserLiker> getUtente() {
        return utente;
    }

    public void setUtente(Set<UserLiker> utente) {
        this.utente = utente;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
