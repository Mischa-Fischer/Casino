/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.roulette;

import java.util.ArrayList;

/**
 *
 * @author zeno
 */
public class CompareList {
    public ArrayList getSortedArray(ArrayList arr){
        int compare = 0;
        ArrayList ars = new ArrayList<>();
        for(int i = 0; i < 49; i++){
            for(int y = 0; y < arr.size(); y++){
                if( (int) arr.get(y) == i){
                    ars.add(i);
                }
            }
        }
        return ars;
    }
}
