package com.virgo.backend.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Unlike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnlike;

    @OneToMany(mappedBy = "unlike")
    private Set<UserUnliker> joinTable;

    @OneToMany(mappedBy = "unlike")
    private Set<PostUnliker> joinColumn;

    @Column(nullable = false)
    private OffsetDateTime dataPublicazione;

    private Boolean isAttivo = true;

    public Unlike(){
        super();
    }

    public Unlike(Integer idUnlike, Set<UserUnliker> joinTable, Set<PostUnliker> joinColumn, OffsetDateTime dataPublicazione) {
        this.idUnlike = idUnlike;
        this.joinTable = joinTable;
        this.joinColumn = joinColumn;
        this.dataPublicazione = dataPublicazione;
        this.isAttivo = true;
    }

    public Unlike(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
        this.isAttivo = true;
    }

    @Override
    public String toString() {
        return "Unlike{" +
                "idUnlike=" + idUnlike +
                ", joinTable=" + joinTable +
                ", joinColumn=" + joinColumn +
                ", dataPublicazione=" + dataPublicazione +
                ", isAttivo=" + isAttivo +
                '}';
    }

    public Integer getIdUnlike() {
        return idUnlike;
    }

    public void setIdUnlike(Integer idUnlike) {
        this.idUnlike = idUnlike;
    }

    public Set<UserUnliker> getJoinTable() {
        return joinTable;
    }

    public void setJoinTable(Set<UserUnliker> joinTable) {
        this.joinTable = joinTable;
    }

    public Set<PostUnliker> getJoinColumn() {
        return joinColumn;
    }

    public void setJoinColumn(Set<PostUnliker> joinColumn) {
        this.joinColumn = joinColumn;
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
