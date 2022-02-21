package com.virgo.backend.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLike;

    @ManyToMany(mappedBy = "likeRilasciati")
    private List<Utente> utente;

    @ManyToMany(mappedBy = "like")
    private List<Post> post;

}
