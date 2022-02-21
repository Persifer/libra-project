package com.virgo.backend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    private String titolo;
    private String descrizione;
    private Date dataPublicazione;
    private Date dataAggiornamento;

    @ManyToOne
    @JoinColumn(name="idUtente")
    private Utente idProprietario;

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
        this.idProprietario = idUtente;
        this.isAttivo = true;
    }

    public Post(Integer idPost, String titolo, String descrizione, Date dataPublicazione,
                Date dataAggiornamento, Utente idUtente) {
        this.idPost = idPost;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
        this.idProprietario = idUtente;
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
                ", idUtente=" + idProprietario +
                ", isAttivo=" + isAttivo +
                '}';
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
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

    public Utente getIdProrietario() {
        return idProprietario;
    }

    public void setIdProrietario(Utente idUtente) {
        this.idProprietario = idUtente;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }
}
