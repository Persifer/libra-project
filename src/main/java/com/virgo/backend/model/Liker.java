package com.virgo.backend.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @OneToMany(mappedBy = "liker")
    private Set<PostLiker> post;

    private Boolean isAttivo = true;

    public Liker() {
        super();
    }


    public Liker(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public Liker(OffsetDateTime dataPublicazione, Set<UserLiker> utente, Set<PostLiker> post) {
        this.dataPublicazione = dataPublicazione;
        this.utente = utente;
        this.post = post;
        this.isAttivo = true;
    }

    public Liker(Integer idLike, OffsetDateTime dataPublicazione, Set<UserLiker> utente, Set<PostLiker> post) {
        this.idLike = idLike;
        this.dataPublicazione = dataPublicazione;
        this.utente = utente;
        this.post = post;
        this.isAttivo = true;
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

    public Set<PostLiker> getPost() {
        return post;
    }

    public void setPost(Set<PostLiker> post) {
        this.post = post;
    }

    public OffsetDateTime getDataPublicazione() {
        return dataPublicazione;
    }

    public void setDataPublicazione(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }
}
