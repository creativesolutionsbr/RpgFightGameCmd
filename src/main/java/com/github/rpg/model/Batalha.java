/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package com.github.rpg.model;

/**
 *
 * @author bq4d
 */
public class Batalha {

    /**
     * Nickname escolhido pelo jogador
     */
    private String nickname;
    
    /**
     * Heroi escolhido pelo jogador
     */
    private Personagem heroi;
        
    /**
     * Oponente escolhido pelo sorteio automatico.
     */
    private Personagem oponente;

    /**
     * Cosntrutor padrao.
     */
    public Batalha() {
    }

    /**
     * Construtor com parametros.
     * @param nickname - apelido escolhido pelo jogador.
     * @param heroi - heroi escolhido pelo jogador.
     * @param oponente - oponente sorteado.
     */
    public Batalha(String nickname, Personagem heroi, Personagem oponente) {
        this.nickname = nickname;
        this.heroi = heroi;
        this.oponente = oponente;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Personagem getHeroi() {
        return heroi;
    }

    public void setHeroi(Personagem heroi) {
        this.heroi = heroi;
    }

    public Personagem getOponente() {
        return oponente;
    }

    public void setOponente(Personagem oponente) {
        this.oponente = oponente;
    }

    @Override
    public String toString() {
        return "Batalha{" + "nickname=" + nickname + ", heroi=" + heroi + ", oponente=" + oponente + '}';
    }
        
}
