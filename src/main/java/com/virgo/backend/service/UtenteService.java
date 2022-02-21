package com.virgo.backend.service;

import com.virgo.backend.model.Utente;

public interface UtenteService{

    public Utente login(String user, String passw);

    public boolean isAdmin(String utente,String password);

    public Utente create(Utente utente);

    public Utente retrieve(String user);

}
