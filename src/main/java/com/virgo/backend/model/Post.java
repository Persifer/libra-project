package com.virgo.backend.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    private String titolo;
    private String descrizione;
    private String photoPath;
    @Column(nullable = false)
    private OffsetDateTime dataPublicazione;
    @Column(nullable = false)
    private OffsetDateTime dataAggiornamento;

    private Boolean isAttivo = true;

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

    // Costruttore con solo dati e photoPath di default
    public Post(String titolo, String descrizione,OffsetDateTime dataPublicazione, OffsetDateTime dataAggiornamento) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.photoPath = "D:\\locazione_a_caso\\foto.jpg";
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
    }

    // Costruttore con solo i dati del post
    public Post(String titolo, String descrizione, String photoPath, OffsetDateTime dataPublicazione,
                OffsetDateTime dataAggiornamento) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.photoPath = photoPath;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
    }

    //Post con tutto tranne id, like e unlike
    public Post(String titolo, String descrizione, String photoPath, OffsetDateTime dataPublicazione,
                OffsetDateTime dataAggiornamento, Utente idProprietario) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.photoPath = photoPath;
        this.dataPublicazione = dataPublicazione;
        this.dataAggiornamento = dataAggiornamento;
        this.idProprietario = idProprietario;
    }

    // Costruttore con tutti i parametri
    public Post(Integer idPost, String titolo, String descrizione, String photoPath, OffsetDateTime dataPublicazione,
                OffsetDateTime dataAggiornamento, Boolean isAttivo, Utente idProprietario,
                List<Like> like, List<Unlike> unlike) {
        this.idPost = idPost;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.photoPath = photoPath;
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
                ", photoPath='" + photoPath + '\'' +
                ", dataPublicazione=" + dataPublicazione +
                ", dataAggiornamento=" + dataAggiornamento +
                ", isAttivo=" + isAttivo +
                ", idProprietario=" + idProprietario +
                ", like=" + like +
                ", unlike=" + unlike +
                '}';
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public OffsetDateTime getDataPublicazione() {
        return dataPublicazione;
    }

    public void setDataPublicazione(OffsetDateTime dataPublicazione) {
        this.dataPublicazione = dataPublicazione;
    }

    public OffsetDateTime getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(OffsetDateTime dataAggiornamento) {
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
