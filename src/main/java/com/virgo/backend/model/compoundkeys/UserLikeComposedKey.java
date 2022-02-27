package com.virgo.backend.model.compoundkeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserLikeComposedKey implements Serializable {

    @Column(name="id_utente")
    private Integer idUtente;

    @Column(name="id_like")
    private Integer idLiker;

    public UserLikeComposedKey() {
        super();
    }

    public UserLikeComposedKey(Integer idUtente, Integer idLiker) {
        this.idUtente = idUtente;
        this.idLiker = idLiker;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeComposedKey that = (UserLikeComposedKey) o;
        return Objects.equals(idUtente, that.idUtente) && Objects.equals(idLiker, that.idLiker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente, idLiker);
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Integer getIdLiker() {
        return idLiker;
    }

    public void setIdLiker(Integer idLiker) {
        this.idLiker = idLiker;
    }
}
