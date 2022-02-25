package com.virgo.backend.model;

import com.virgo.backend.model.compoundkeys.UserLikeComposedKey;

import javax.persistence.*;

@Entity
public class UserLiker {

    @EmbeddedId
    private UserLikeComposedKey idElement;

    @ManyToOne
    @MapsId("idUtente")
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @ManyToOne
    @MapsId("idLiker")
    @JoinColumn(name = "id_like")
    private Liker liker;

    public UserLiker() {
        super();
    }

    public UserLiker(UserLikeComposedKey idElement, Utente utente, Liker liker) {
        this.idElement = idElement;
        this.utente = utente;
        this.liker = liker;
    }

    public UserLikeComposedKey getIdElement() {
        return idElement;
    }

    public void setIdElement(UserLikeComposedKey idElement) {
        this.idElement = idElement;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Liker getLiker() {
        return liker;
    }

    public void setLiker(Liker liker) {
        this.liker = liker;
    }
}
