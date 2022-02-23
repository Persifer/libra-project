package com.virgo.backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtente;

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Boolean isAttivo = true;

    @OneToMany(mappedBy = "idProprietario")
    private List<Post> postList;

    @ManyToOne
    @JoinColumn(name = "ruoloUtente")
    private Ruolo ruolo = null;

    @ManyToMany
    @JoinTable(name = "Like_Utente",joinColumns =
    @JoinColumn(name="idUtente"),inverseJoinColumns =
    @JoinColumn(name="idLike"))
    private List<Like> likeRilasciati = null;

    @ManyToMany
    @JoinTable(name = "Unlike_Utente",joinColumns =
    @JoinColumn(name="idUtente"),inverseJoinColumns =
    @JoinColumn(name="idLike"))
    private List<Unlike> unlikeRilasciati = null;


    public Utente(){
        super();
    }

    public Utente(String username, String nome, String cognome, String email, String password,
                  List<Post> postList, Ruolo ruolo, List<Like> likeRilasciati, List<Unlike> unlikeRilasciati) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.postList = postList;
        this.ruolo = ruolo;
        this.likeRilasciati = likeRilasciati;
        this.unlikeRilasciati = unlikeRilasciati;
    }

    public Utente(Integer idUtente, String username, String nome, String cognome, String email, String password,
                  List<Post> postList, Ruolo ruolo, List<Like> likeRilasciati, List<Unlike> unlikeRilasciati) {
        this.idUtente = idUtente;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.postList = postList;
        this.ruolo = ruolo;
        this.likeRilasciati = likeRilasciati;
        this.unlikeRilasciati = unlikeRilasciati;
    }

    public Utente(String username, String nome, String cognome, String email, String password) {

        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
    }
    public Utente( String username, String password) {

        this.username = username;
        this.nome = null;
        this.cognome = null;
        this.email = null;
        this.password = password;
    }



    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAttivo=" + isAttivo +
                ", postList=" + postList +
                ", likeRilasciati=" + likeRilasciati +
                ", unlikeRilasciati=" + unlikeRilasciati +
                '}';
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAttivo() {
        return isAttivo;
    }

    public void setAttivo(Boolean attivo) {
        isAttivo = attivo;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Like> getLikeRilasciati() {
        return likeRilasciati;
    }

    public void setLikeRilasciati(List<Like> likeRilasciati) {
        this.likeRilasciati = likeRilasciati;
    }

    public List<Unlike> getUnlikeRilasciati() {
        return unlikeRilasciati;
    }

    public void setUnlikeRilasciati(List<Unlike> unlikeRilasciati) {
        this.unlikeRilasciati = unlikeRilasciati;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
