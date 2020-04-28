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
public class Calculator {
    public boolean[] getWin(ArrayList arr, int win){
        
        boolean numExact = false;
        boolean[] bol = new boolean[arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            if((int) arr.get(i) == win){
                bol[i] = true;
            }else{
                switch((int) arr.get(i)){
                    case 37:
                        bol[i] = line(1, win);
                        break;
                    case 38:
                        bol[i] = line(2, win);
                        break;
                    case 39:
                        bol[i] = line(3, win);
                        break;
                    case 40:
                        bol[i] = inBetween(1, 12, win);
                        break;
                    case 41:
                        bol[i] = inBetween(13, 24, win);
                        break;
                    case 42:
                        bol[i] = inBetween(25, 36, win);
                        break;
                    case 43:
                        bol[i] = inBetween(1, 18, win);
                        break;
                    case 44:
                        bol[i] = inBetween(19, 36, win);
                        break;
                    case 45:
                        bol[i] = isWage(win);
                        break;
                    case 46:
                        bol[i] = isntWage(win);
                        break;
                    case 47:
                        bol[i] = isRed(true, win);
                        break;
                    case 48:
                        bol[i] = isRed(false, win);
                        break;
                }
            }
        }
        
        return bol;
    }
    
    public boolean line(int line, int num){
        boolean bol = false;
        switch(line){
            case 1: 
                for(int i = 1; i < 35; i+= 3){
                    if(num == i){
                        bol = true;
                    }
                }
                break;
            case 2: 
                for(int i = 2; i < 36; i+= 3){
                    if(num == i){
                        bol = true;
                    }
                }
                break;
            case 3: 
                for(int i = 3; i < 37; i+= 3){
                    if(num == i){
                        bol = true;
                    }
                }
                break;
        }
        return bol;
    }
    
    public boolean inBetween(int one, int two, int win){
        boolean bol = false;
        if(one <= win && win <= two){
            bol = true;
        }
        return bol;
    }
    
    public boolean isWage(int win){
        boolean bol = false;
            if(win % 2 == 0){
                bol = true;
            }
        return bol;
    }
    
    public boolean isntWage(int win){
        boolean bol = false;
            if(win % 2 != 0){
                bol = true;
            }
        return bol;
    }
    
    public boolean isRed(boolean red, int win){
        boolean bol = false;
            if(win == 0){
                
            }else if(win == 1 || win == 3 || win == 5 || win == 7 || win == 9 || win == 12 || 
                     win == 14 || win == 16 || win == 18 || win == 19 || win == 21 || win == 23 || 
                     win == 25 || win == 27 || win == 30 || win == 32 || win == 34 || win == 36 ){
                if(red == true){
                    bol = true;
                }
            }else if(red == false){
                bol = true;
                
            }
        return bol;
    }
}
