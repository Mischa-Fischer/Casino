/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.SlotMachine;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author zeno
 */
public class SpinSlot {
    //0 - 2 == JOKER 
    //3 - 27 == ASS
    //28 - 52 == KING
    //53 - 77 == QUEEN
    //78 - 102 == JUNGE
    //103 - 127 == 10
    //128 == LIBERTE
    Random r = new Random();
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<SlotSign> arrs = new ArrayList<>();
   public SpinSlot(){
        
       
       
    }
   
   public void SpinThisSlot(){
       for(int i = 0; i < 25; i++){
           arr.add(r.nextInt(129));
           System.out.println(arr.get(i));
       }
   }
   
   
   public ArrayList gettArrayListToEnum(){
       SpinThisSlot();
       System.out.println(arr.size()+"");
       for(int i = 0; i < 25; i++){
           if((int) arr.get(i) <= 2){
               arrs.add(SlotSign.JOKER);
           }else if((int) arr.get(i) <= 27){
               arrs.add(SlotSign.ASS);
           }else if((int) arr.get(i) <= 52){
               arrs.add(SlotSign.KING);
           }else if((int) arr.get(i) <= 77){
               arrs.add(SlotSign.QUEEN);
           }else if((int) arr.get(i) < 102){
               arrs.add(SlotSign.JUNGE);
           }else if((int) arr.get(i) < 127){
               arrs.add(SlotSign.TEN);
           }else{
               arrs.add(SlotSign.LIBERTE);
           }
       }
       return arrs;
   }
}
