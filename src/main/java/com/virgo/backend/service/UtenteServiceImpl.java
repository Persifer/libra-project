package com.virgo.backend.service;

import com.virgo.backend.model.Utente;
import com.virgo.backend.repository.UtenteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteCrudRepository repoUtente;

    @Override
    public Utente login(String user, String passw) {
        return null;
    }

    @Override
    public boolean isAdmin(String utente, String password) {
        return false;
    }

    @Override
    public Utente create(Utente utente) {
        return null;
    }

    @Override
    public Utente retrieve(String user) {
        return null;
    }
}
