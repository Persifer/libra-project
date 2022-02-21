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
    private Boolean isAttivo;

    @OneToMany(mappedBy = "idProprietario")
    private List<Post> postList;

    public Utente(){
        super();
    }

    public Utente(String username, String nome, String cognome, String email, String password) {
        this.idUtente = null;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.isAttivo = true;
    }

    public Utente(Integer idUtente, String username, String nome, String cognome, String email, String password) {
        this.idUtente = idUtente;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.isAttivo = true;
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
}
