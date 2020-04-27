/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.SlotMachine;

import java.util.ArrayList;

/**
 *
 * @author zeno
 */
public class Calculator {
    int num = 0;
    public Calculator(int num){
        this.num = num;
    }
    
    
    
    public ArrayList getSum(ArrayList<SlotSign> arr){
        int sum = 0;
        SlotSign[][] raster = signs(arr);
        int joker = 0;
        for(int i = 0; i < 5; i++){
            int line = 1;
            for(int y = 0; y < 4; y++){
                if(raster[i][y] == raster[i][y+1]){
                    line++;
                }
                if(line >= num){
                    sum+= line;
                }
                if(raster[i][y] == SlotSign.JOKER){
                    joker++;
                }
            }
        }
        if(joker >= 3){
            sum += 2;
        }
        
        ArrayList arrl = arr;
        arrl.add(25, sum);
        
        //arrl.add(25, sum);
        return arrl;
    }
    
    public SlotSign[][] signs(ArrayList<SlotSign> arr){
        
        SlotSign[][] raster = new SlotSign[5][5];
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        
        for(int i = 0; i < 25; i++){
                  if(i%5==0){
                raster[0][zero] = arr.get(i);
                zero++;
            }else if(i%5==1){
                raster[1][one] = arr.get(i);
                one++;
            }else if(i%5==2){
                raster[2][two] = arr.get(i);
                two++;
            }else if(i%5==3){
                raster[3][three] = arr.get(i);
                three++;
            }else if(i%5==4){
                raster[4][four] = arr.get(i);
                four++;
            }
        }
        
        
        return raster;
    }
}
