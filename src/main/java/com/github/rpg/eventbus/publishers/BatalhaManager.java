/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package com.github.rpg.eventbus.publishers;

import com.github.rpg.eventbus.events.ProcessaAtaqueEvent;
import com.github.rpg.eventbus.events.RolarDadoEvent;
import com.github.rpg.eventbus.events.SorteiaOponenteEvent;
import com.github.rpg.model.Batalha;
import com.github.rpg.model.Personagem;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author bq4d
 */
@Service
public class BatalhaManager implements ApplicationEventPublisherAware {

    private int valorDado;
    
    private Batalha batalha;
    
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * Rola um dado
     * @param tipoDado - tipo de dado. Ex.: 1d10, etc...
     */
    public void rolarDado(String tipoDado) {
        publisher.publishEvent(new RolarDadoEvent(this, tipoDado));
    }

    /**
     * Dispara o evento para sortear um oponente.
     */
    public void sortearOponente() {
        publisher.publishEvent(new SorteiaOponenteEvent(this));
    }
    
    public void iniciarBatalha() {
        this.rolarDado("1d10");
        int agPlayer = this.batalha.getHeroi().getAgilidade() + this.valorDado;
        int agOponent = this.batalha.getOponente().getAgilidade() + this.valorDado;
        if(agPlayer == agOponent) {
            iniciarBatalha();
        } else if (agPlayer > agOponent) {
            this.processaAtaque(this.batalha.getHeroi(), this.batalha.getOponente());
        } else if (agOponent > agPlayer) {
            this.processaAtaque(this.batalha.getOponente(), this.batalha.getHeroi());
        }
    }

    public void processaAtaque(Personagem atacante, Personagem defensor) {
        System.out.println(atacante.getNomePersonagem() + "( " + atacante.getPontosVida() + ") ATACOU " + defensor.getNomePersonagem() + "( " + defensor.getPontosVida() + " )");
        publisher.publishEvent(new ProcessaAtaqueEvent(this, atacante, defensor));
    }
    
    public Batalha getBatalha() {
        return batalha;
    }

    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }

    public int getValorDado() {
        return valorDado;
    }

    public void setValorDado(int valorDado) {
        this.valorDado = valorDado;
    }
    
}
