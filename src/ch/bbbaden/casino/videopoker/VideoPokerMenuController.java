/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

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
public class VideoPokerMenuController implements Initializable {
    private VideoPokerMenuViewModel vm;
    @FXML
    private Button startBtn;
    @FXML
    private Button menuBtn;
    @FXML
    private Label kontoLbl;
    @FXML
    private Label kontoUserlbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startAction(ActionEvent event) {
        vm.startAction();
    }

    @FXML
    private void menuAction(ActionEvent event) {
        vm.goToMenu();
       
    }
    
    public void setViewModel(VideoPokerMenuViewModel vm){
        this.vm = vm;
    }
    public void bind() {
         kontoUserlbl.textProperty().bind(vm.getBalance());
    }

    
}
