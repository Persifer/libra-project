package com.virgo.backend.model;

import com.virgo.backend.model.compoundkeys.UserUnlikerComposedKey;

import javax.persistence.*;

@Entity
public class UserUnliker {

    @EmbeddedId
    private UserUnlikerComposedKey id;

    @ManyToOne
    @MapsId("idUtente")
    @JoinColumn(name = "id_utente")
    private Utente utenteUnlike;

    @ManyToOne
    @MapsId("idUnlike")
    @JoinColumn(name = "id_unlike")
    private Unlike unlike;

    public UserUnliker() {
        super();
    }

    public UserUnliker(UserUnlikerComposedKey id, Utente utente, Unlike unlike) {
        this.id = id;
        this.utenteUnlike = utente;
        this.unlike = unlike;
    }

    public UserUnliker(Utente utente, Unlike unlike) {
        this.utenteUnlike = utente;
        this.unlike = unlike;
    }

    public UserUnlikerComposedKey getId() {
        return id;
    }

    public void setId(UserUnlikerComposedKey id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utenteUnlike;
    }

    public void setUtente(Utente utente) {
        this.utenteUnlike = utente;
    }

    public Unlike getUnlike() {
        return unlike;
    }

    public void setUnlike(Unlike unlike) {
        this.unlike = unlike;
    }
}
