/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.SlotMachine;

import ch.bbbaden.casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author zeno
 */
public class ViewModel implements PropertyChangeListener {

    Model m;
    MainApp mainApp;
    
    public ViewModel(Model m){
        this.m = m;
    }
    
    public ArrayList getSol(int lines){
        return m.getSoll(lines);
    }
    
    
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public void backToMenu(){
        mainApp.showMainMenu();
    }
    
}
