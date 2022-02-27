package com.virgo.backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Unlike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnlike;

    @OneToMany(mappedBy = "unlike")
    private Set<UserUnliker> joinTable;

    @ManyToMany(mappedBy = "unlike")
    private List<Post> post;

    public Unlike(){
        super();
    }

    public Unlike(Integer idUnlike, Set<UserUnliker> joinTable, List<Post> post) {
        this.idUnlike = idUnlike;
        this.joinTable = joinTable;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Unlike{" +
                "idUnlike=" + idUnlike +
                ", joinTable=" + joinTable +
                ", post=" + post +
                '}';
    }

    public Integer getIdUnlike() {
        return idUnlike;
    }

    public void setIdUnlike(Integer idUnlike) {
        this.idUnlike = idUnlike;
    }

    public Set<UserUnliker> getJoinTable() {
        return joinTable;
    }

    public void setJoinTable(Set<UserUnliker> joinTable) {
        this.joinTable = joinTable;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
