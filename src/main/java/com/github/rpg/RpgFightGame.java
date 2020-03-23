/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package com.github.rpg;

import com.github.rpg.dao.FakeDatabase;
import com.github.rpg.eventbus.publishers.BatalhaManager;
import com.github.rpg.model.Batalha;
import com.github.rpg.model.Ranking;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 *
 * @author bq4d
 */
public class RpgFightGame {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.github.rpg");
        FakeDatabase fakeDB = context.getBean(FakeDatabase.class);
        Scanner leitor = new  Scanner(System.in);
        Random random = new Random();
        int continua = 1;
        while (continua == 1) {
            Batalha batalha = new Batalha("nickname", fakeDB.getHeroById( random.nextInt(2) + 1 ), null);
            BatalhaManager manager = context.getBean(BatalhaManager.class);
            manager.setBatalha(batalha);
            manager.sortearOponente();
            manager.iniciarBatalha();
            System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Nao");
            continua = leitor.nextInt();
        }
        
        Collections.sort(fakeDB.listAllRanking());
        System.out.println("==== RANKING ===");
        for (Ranking rk : fakeDB.listAllRanking()) {
            System.out.println(rk.getNickname() + " ........ " + rk.getPontuacao());
        }
    }    
}
