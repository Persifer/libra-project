package com.virgo.backend.controller.dto;

public class LikeDto {

    private String username;
    private String password;
    private Integer idPost;

    public LikeDto(String username, String password, Integer idPost) {
        this.username = username;
        this.password = password;
        this.idPost = idPost;
    }

    @Override
    public String toString() {
        return "LikeDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idPost='" + idPost + '\'' +
                '}';
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
