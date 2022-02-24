package com.virgo.backend.controller.dto;

public class ModifyPostDto {

    private String username;
    private String password;
    private Integer idPost;
    private String descrizione;
    private String titolo;

    public ModifyPostDto(String username, String password, Integer idPost, String descrizione, String titolo) {
        this.username = username;
        this.password = password;
        this.idPost = idPost;
        this.descrizione = descrizione;
        this.titolo = titolo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
