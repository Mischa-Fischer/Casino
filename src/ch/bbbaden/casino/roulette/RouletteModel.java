/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.roulette;

import java.util.ArrayList;

/**
 *
 * @author misch
 */
public class RouletteModel {
    /*
    Line 1   = 37
    line 2   = 38
    Line 3   = 39
    1 - 12   = 40
    13 - 24  = 41
    25 - 36  = 42
    1 - 18   = 43
    19 - 36  = 44
    gerade   = 45
    ungerade = 46
    rot      = 47
    schwarz  = 48
    */
    int randNum = 0;
    ArrayList<Integer> arrs = new ArrayList();
    
    public boolean[] getWin(ArrayList<Integer> arr){
        System.out.println(arr.get(0)+"");
        Generator gen = new Generator();
        randNum = gen.getNumber();
        //ändern zu collection.sort(arr);
        CompareList com = new CompareList();
        arrs = com.getSortedArray(arr);
        Calculator clac = new Calculator();
        System.out.println(randNum + "");
        return clac.getWin(arr, randNum);
    }
    
    public int getRandNum(){
        return randNum;
    }
    
    public ArrayList getSortArrayList(){
        return arrs;
    }
}
