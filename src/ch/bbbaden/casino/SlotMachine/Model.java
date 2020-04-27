/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.SlotMachine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 *
 * @author zeno
 */
public class Model {
    
    
    //ArrayList für die Slots
    ArrayList arr = new ArrayList<>();
    
    //Konstruktor für das Model
    public Model(){
        
    }
    
    //Methode zum Spinnen der Slots
    public ArrayList getSoll(int num){
        SpinSlot spinner = new SpinSlot();
        arr = spinner.gettArrayListToEnum();
        Calculator calc = new Calculator(num);
        return calc.getSum(arr);
        //return arr;
    } 
    
}
