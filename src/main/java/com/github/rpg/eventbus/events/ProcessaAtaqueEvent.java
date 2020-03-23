/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package com.github.rpg.eventbus.events;

import com.github.rpg.model.Personagem;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author bq4d
 */
public class ProcessaAtaqueEvent extends ApplicationEvent {
    
    private Personagem atacante;
    
    private Personagem defensor;

    public ProcessaAtaqueEvent(Object source, Personagem atacante, Personagem defensor) {
        super(source);
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public Personagem getAtacante() {
        return atacante;
    }

    public Personagem getDefensor() {
        return defensor;
    }
}
