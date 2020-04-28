/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.roulette;

import java.util.Random;

/**
 *
 * @author zeno
 */
public class Generator {
    Random r = new Random();
    public int getNumber(){
        System.out.println(r+"");
        return r.nextInt(37);
    }
}
