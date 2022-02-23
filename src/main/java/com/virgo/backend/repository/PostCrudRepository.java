package com.virgo.backend.repository;

import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostCrudRepository extends CrudRepository<Post, Integer> {

    //@Query("SELECT p FROM Post p JOIN Utente u ON (u = p.idProprietario)" )
    public List<Post> getPostByIdProprietario(Utente user);
}
