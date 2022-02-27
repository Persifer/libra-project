package com.virgo.backend.model.compoundkeys;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserUnlikerComposedKey implements Serializable {

    @Column(name = "id_utente")
    private Integer idUtente;

    @Column(name = "id_unliker")
    private Integer idUnlike;

    public UserUnlikerComposedKey() {
        super();
    }

    public UserUnlikerComposedKey(Integer idUtente, Integer idUnlike) {
        this.idUtente = idUtente;
        this.idUnlike = idUnlike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUnlikerComposedKey that = (UserUnlikerComposedKey) o;
        return Objects.equals(idUtente, that.idUtente) && Objects.equals(idUnlike, that.idUnlike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente, idUnlike);
    }
}
