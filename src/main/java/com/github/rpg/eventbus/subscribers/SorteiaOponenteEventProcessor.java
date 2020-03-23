/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package com.github.rpg.eventbus.subscribers;

import com.github.rpg.dao.FakeDatabase;
import com.github.rpg.eventbus.events.SorteiaOponenteEvent;
import com.github.rpg.eventbus.publishers.BatalhaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author bq4d
 */
@Component
public class SorteiaOponenteEventProcessor implements ApplicationListener<SorteiaOponenteEvent>{

    @Autowired
    private FakeDatabase fakeDB;
    
    @Autowired
    private BatalhaManager manager;

    @Override
    public void onApplicationEvent(SorteiaOponenteEvent event) {
        this.manager.getBatalha().setOponente(fakeDB.getOponentById(event.getResultado()));
        System.out.println("Batalha entre: ");
        System.out.println(this.manager.getBatalha().getHeroi().getNomePersonagem());
        System.out.println(" X ");
        System.out.println(this.manager.getBatalha().getOponente().getNomePersonagem());
    }    
}
