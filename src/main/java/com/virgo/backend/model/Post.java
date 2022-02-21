package com.virgo.backend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    private Boolean isAttivo;

    @ManyToOne
    @JoinColumn(name="idUtente")
    private Utente idProprietario;

    @ManyToMany
    @JoinTable(name = "post_like",joinColumns =
    @JoinColumn(name="idPost"),inverseJoinColumns =
    @JoinColumn(name="idLike"))
    private List<Like> like = null;

    @ManyToMany
    @JoinTable(name = "post_unlike",joinColumns =
    @JoinColumn(name="idPost"),inverseJoinColumns =
    @JoinColumn(name="idLike"))
    private List<Unlike> unlike = null;

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

    public Post(Integer idPost, String titolo, String descrizione, Date dataPublicazione, Date dataAggiornamento,
                Boolean isAttivo, Utente idProprietario, List<Like> like, List<Unlike> unlike) {
        this.idPost = idPost;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
        this.isAttivo = isAttivo;
        this.idProprietario = idProprietario;
        this.like = like;
        this.unlike = unlike;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataPublicazione=" + dataPublicazione +
                ", dataAggiornamento=" + dataAggiornamento +
                ", isAttivo=" + isAttivo +
                ", idProprietario=" + idProprietario +
                ", like=" + like +
                ", unlike=" + unlike +
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

    public Utente getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Utente idProprietario) {
        this.idProprietario = idProprietario;
    }

    public List<Like> getLike() {
        return like;
    }

    public void setLike(List<Like> like) {
        this.like = like;
    }

    public List<Unlike> getUnlike() {
        return unlike;
    }

    public void setUnlike(List<Unlike> unlike) {
        this.unlike = unlike;
    }
}
