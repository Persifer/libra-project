package com.virgo.backend.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuolo;

    private String nome;
    private String descrizione;
    private Boolean isAttivo;

    @OneToMany(mappedBy = "ruolo")
    private List<Utente> utentiConRuolo = null;

    public Ruolo() {
        super();
    }

    public Ruolo(String nome, String descrizione) {
        this.idRuolo = null;
        this.nome = nome;
        this.descrizione = descrizione;
        this.isAttivo = true;
    }

    public Ruolo(Integer idRuolo, String nome, String descrizione) {
        this.idRuolo = idRuolo;
        this.nome = nome;
        this.descrizione = descrizione;
        this.isAttivo = true;
    }

    @Override
    public String toString() {
        return "Ruolo{" +
                "idRuolo=" + idRuolo +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }

    public Integer getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(Integer idRuolo) {
        this.idRuolo = idRuolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }
}
