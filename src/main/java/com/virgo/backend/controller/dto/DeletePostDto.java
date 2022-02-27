package com.virgo.backend.controller.dto;

public class DeletePostDto {

    private String username;
    private String password;

    private Integer idPost;

    public DeletePostDto(String username, String password, Integer idPost) {
        this.username = username;
        this.password = password;
        this.idPost = idPost;
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
}
