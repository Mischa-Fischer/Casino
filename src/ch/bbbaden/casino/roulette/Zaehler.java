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
public class Zaehler {
    
    int index = 0;
    boolean bols = false;
    int winNum = 0;
    
    
    public int doIt(ArrayList<Integer> arr, boolean[] bol){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) < 37){
                index++;
            }else{
                if(bol[i] == true){
                    System.out.println(arr.get(i));
                    switch(arr.get(i)){
                        case 37: winNum += 2; break;
                        case 38: winNum += 2;break;
                        case 39: winNum += 2;break;
                        case 40: winNum += 2;break;
                        case 41: winNum += 2;break;
                        case 42: winNum += 2;break;
                        case 43: winNum += 1;break;
                        case 44: winNum += 1;break;
                        case 45: winNum += 1;break;
                        case 46: winNum += 1;break;
                        case 47: winNum += 1;break;
                        case 48: winNum += 1;break;
                    }
                }
            }
        }
        for(int i = 0; i < index; i++){
            if(bol[i] == true){
                bols = true;
                switch(index){
                    case 1: winNum += 35;break;
                    case 2: winNum += 17;break;
                    case 3: winNum += 11;break;
                    case 4: winNum += 8;break;
                    case 5: winNum += 6;break;
                    default: winNum += 1;break;
                }
                
                
            }
            
            
            
            
        }
        
        
        return winNum;
    }
    
}
