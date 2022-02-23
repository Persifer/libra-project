package com.virgo.backend.service;

import com.virgo.backend.model.Ruolo;
import com.virgo.backend.repository.RuoloCrudRepository;
import com.virgo.backend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service("ruoloService")
@Transactional
public class RuoloService {

    @Autowired
    private RuoloCrudRepository ruoloRepo;

    public Ruolo getAdminRole(){
        return ruoloRepo.findByNome(Constants.ADMINROLE);
    }

    public Ruolo getUserRole(){
        return ruoloRepo.findByNome(Constants.USEROLE);
    }
}
