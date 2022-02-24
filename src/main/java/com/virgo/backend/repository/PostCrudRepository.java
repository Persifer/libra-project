package com.virgo.backend.repository;

import com.virgo.backend.model.Post;
import com.virgo.backend.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCrudRepository extends CrudRepository<Post, Integer> {

    //@Query("SELECT p FROM Post p JOIN Utente u ON (u = p.idProprietario)" )
    public List<Post> getPostByIdProprietario(Utente user);

    @Query(
            value= "SELECT  * FROM Post p WHERE p.data_publicazione BETWEEN :start AND :end",
            nativeQuery = true)
    public List<Post> getAllPostBetweeen(@Param("id") Integer idUtente, @Param("start")String start, @Param("end") String end);

//    @Query(
//            value= "SELECT  * FROM Post p JOIN Utente u ON (u.id_utente = p.id_utente)" +
//                    "WHERE u.id_utente = :id AND p.data_publicazione BETWEEN :start AND :end",
//            nativeQuery = true)
//    public List<Post> getPostBetweeen(@Param("id") Integer idUtente, @Param("start")String start, @Param("end") String end);

    @Query(
            value= "SELECT * FROM Post p JOIN Utente u ON (u.id_utente = p.id_utente)" +
                    "WHERE u.id_utente = :id AND p.data_aggiornamento BETWEEN :start AND :end",
            nativeQuery = true)
    public List<Post> getAllLastUpdateBetweenByUser(@Param("id") Integer idUtente, @Param("start")String start, @Param("end") String end);

    @Query(
            value = "SELECT * FROM Post p WHERE p.descrizione LIKE '%?1%' OR p.titolo LIKE '%?1%' ",
            nativeQuery = true
    )
    public List<Post> getPostWithWords(String parola);

    // Prende tutti i post che 
    @Query(
            value = "SELECT * FROM Post p JOIN Utente u ON (u.id_utente = p.id_utente)" +
                    "WHERE u.id_utente = ?1 p.descrizione LIKE '%?2%' OR p.titolo LIKE '%?2%' ",
            nativeQuery = true
    )
    public List<Post> getPostWithWordsForUser(Integer userId, String parola);
}
