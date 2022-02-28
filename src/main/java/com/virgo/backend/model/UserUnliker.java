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

    private Boolean isAttivo;

    public UserUnliker() {
        super();
    }

    public UserUnliker(UserUnlikerComposedKey id, Utente utente, Unlike unlike) {
        this.id = id;
        this.utenteUnlike = utente;
        this.unlike = unlike;
        this.isAttivo = true;
    }

    public UserUnliker(Utente utente, Unlike unlike) {
        this.utenteUnlike = utente;
        this.unlike = unlike;
        this.isAttivo = true;
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

    public Utente getUtenteUnlike() {
        return utenteUnlike;
    }

    public void setUtenteUnlike(Utente utenteUnlike) {
        this.utenteUnlike = utenteUnlike;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }
}
