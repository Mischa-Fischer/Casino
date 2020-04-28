/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.yatzy;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class YatzyGameController implements Initializable {
    MainApp mainApp;
    User user;

    @FXML
    private Button buttonwuerfeln;
    @FXML
    private Button dice1;
    @FXML
    private Button dice2;
    @FXML
    private Button dice3;
    @FXML
    private Button dice4;
    @FXML
    private Button dice5;
    @FXML
    private Button betragsetzenbutton;
    @FXML
    private Label labelversuche;
    @FXML
    private Button abbruchbutton;
    @FXML
    private TextField einergrid;
    @FXML
    private TextField zweiergrid;
    @FXML
    private TextField dreiergrid;
    @FXML
    private TextField vierergrid;
    @FXML
    private TextField fünfergrid;
    @FXML
    private TextField sechsergrid;
    @FXML
    private TextField zwischentotalgrid;
    @FXML
    private TextField bonusgrid;
    @FXML
    private TextField einpaargrid;
    @FXML
    private TextField zweipaargrid;
    @FXML
    private TextField dreigleichegrid;
    @FXML
    private TextField viergleichegrid;
    @FXML
    private TextField kleinestrassegrid;
    @FXML
    private TextField grossestrassegrid;
    @FXML
    private TextField fullhousegrid;
    @FXML
    private TextField chancegrid;
    @FXML
    private TextField yatzygrid;
    @FXML
    private TextField totalgrid;
    @FXML
    private Label kontostandLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(User user) {
        this.user = user;
        kontostandLbl.setText(user.getBalance() + "");
    }
    

    @FXML
    private void buttonwuerfelnklick(ActionEvent event) {
         for (int i = 3; i > 0; i--) {
  
        int eins = generator(1, 6);
        int zwei = generator(1, 6);
        int drei = generator(1,6);
        int vier = generator(1,6);
        int fünf = generator(1, 6);
        dice1.setText(Integer.toString(eins));
        dice2.setText(Integer.toString(zwei));
        dice3.setText(Integer.toString(drei));
        dice4.setText(Integer.toString(vier));
        dice5.setText(Integer.toString(fünf));
        
        }
    }

    @FXML
    private void handleAbbruch(ActionEvent event) {
        mainApp.showMainMenu();
    }
    
    
    private int generator(int min, int max) {
        Random generated = new Random();
        int zufallszahl = generated.nextInt(max + 1 - min) + min;
        return zufallszahl;
    }
    
}
