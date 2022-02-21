package com.virgo.backend.model;

import java.util.Date;
import java.util.UUID;

public class Post {

    private UUID idPost;
    private String titolo;
    private String descrizione;
    private Date dataPublicazione;
    private Date dataAggiornamento;

    private Utente idUtente;
    private Boolean isAttivo;

    public Post(){
        super();
    }

    public Post( String titolo, String descrizione, Date dataPublicazione,
                Date dataAggiornamento, Utente idUtente) {
        this.idPost = null;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
        this.idUtente = idUtente;
        this.isAttivo = true;
    }

    public Post(UUID idPost, String titolo, String descrizione, Date dataPublicazione,
                Date dataAggiornamento, Utente idUtente) {
        this.idPost = idPost;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
        this.idUtente = idUtente;
        this.isAttivo = true;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataPublicazione=" + dataPublicazione +
                ", dataAggiornamento=" + dataAggiornamento +
                ", idUtente=" + idUtente +
                ", isAttivo=" + isAttivo +
                '}';
    }

    public UUID getIdPost() {
        return idPost;
    }

    public void setIdPost(UUID idPost) {
        this.idPost = idPost;
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

    public Date getDataPublicazione() {
        return dataPublicazione;
    }

    public void setDataPublicazione(Date dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public Date getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }
}
