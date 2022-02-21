package com.virgo.backend.model;

import java.util.UUID;

public class Ruolo {
    private UUID idRuolo;
    private String nome;
    private String descrizione;
    private Boolean isAttivo;

    public Ruolo() {
        super();
    }

    public Ruolo(String nome, String descrizione) {
        this.idRuolo = null;
        this.nome = nome;
        this.descrizione = descrizione;
        this.isAttivo = true;
    }

    public Ruolo(UUID idRuolo, String nome, String descrizione) {
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

    public UUID getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(UUID idRuolo) {
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
