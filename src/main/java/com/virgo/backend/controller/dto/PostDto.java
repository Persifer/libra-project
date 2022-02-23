package com.virgo.backend.controller.dto;

import java.time.OffsetDateTime;

public class PostDto {

    private String titolo;
    private String descrizione;
    private OffsetDateTime dataPublicazione;

    private String usernameProprietario;

    public PostDto(String titolo, String descrizione, OffsetDateTime dataPublicazione, String usernameProprietario) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPublicazione = dataPublicazione;
        this.usernameProprietario = usernameProprietario;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataPublicazione=" + dataPublicazione +
                ", usernameProprietario='" + usernameProprietario + '\'' +
                '}';
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public OffsetDateTime getDataPublicazione() {
        return dataPublicazione;
    }

    public void setDataPublicazione(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public String getUsernameProprietario() {
        return usernameProprietario;
    }

    public void setUsernameProprietario(String usernameProprietario) {
        this.usernameProprietario = usernameProprietario;
    }
}
