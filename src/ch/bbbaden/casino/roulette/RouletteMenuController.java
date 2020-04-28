/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.roulette;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class RouletteMenuController implements Initializable {
    
    MainApp mainApp;
    User user;

    @FXML
    private Button playBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Label kontostandLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playAction(ActionEvent event) {
        mainApp.showRouletteGame();
        
    }
    

    @FXML
    private void menuAction(ActionEvent event) {
        mainApp.showMainMenu();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(User user) {
        this.user = user;
        kontostandLbl.setText(user.getBalance() + "");
    }
    
    
}
