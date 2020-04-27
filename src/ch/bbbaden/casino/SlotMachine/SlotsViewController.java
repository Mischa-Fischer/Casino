/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.SlotMachine;

import ch.bbbaden.casino.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author zeno
 */
public class SlotsViewController implements Initializable {

   //ViewModel = Verbindung des Models zur View
    ViewModel vm;
    
    //User für Datenbank
    User user;

    //Bilder für die Slots
    Image king = new Image("/pictures/king.jpg");
    Image queen = new Image("/pictures/queen.png");
    Image junge = new Image("/pictures/junge.jpg");
    Image ten = new Image("/pictures/10.png");
    Image ass = new Image("/pictures/ass.png");
    Image liberte = new Image("/pictures/liberte.jpg");
    Image joker = new Image("/pictures/joker.jpg");

    @FXML
    private Button btnStart;

    @FXML
    private Label lblGesammterEinsatz;
    @FXML
    private Label lblKontostand;
    @FXML
    private Label lblGewinn;

    //Flexible Labels für das GUI
    @FXML
    private Label lblGesammterEinsatzV;
    @FXML
    private Label lblKontostandV;
    @FXML
    private Label lblGewinnV;

    //Bilderslots für die Walzen
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img14;
    @FXML
    private ImageView img15;
    @FXML
    private ImageView img16;
    @FXML
    private ImageView img17;
    @FXML
    private ImageView img18;
    @FXML
    private ImageView img19;
    @FXML
    private ImageView img20;
    @FXML
    private ImageView img21;
    @FXML
    private ImageView img22;
    @FXML
    private ImageView img23;
    @FXML
    private ImageView img24;
    @FXML
    private ImageView img25;

    //Datentypen
    ArrayList arr = new ArrayList();

    int lines = 0;

    int intGesammterEinsatz = 0;

    double Kontostand = 300;

    int intGewinn = 0;

    ArrayList<ImageView> slots = new ArrayList();
    @FXML
    private Button btnTwoLines;
    @FXML
    private Button btnThreeLines;
    @FXML
    private Button btnFourLines;
    @FXML
    private Button btnFiveLine;
    @FXML
    private Button backBtn;

    //Methoden
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    //Setzung des ViewModels
    public void setVM(ViewModel vm) {
        this.vm = vm;
        setRoll();
    }

    //Bindung der Label
    public void bind() {
        //zu
        Kontostand += intGewinn;
        user.setBalance(Kontostand);
        lblKontostandV.setText(Kontostand + "");
        if(intGewinn == 0){
            user.updateStatistics(1, intGesammterEinsatz, "Loose", -intGesammterEinsatz);
        }else{
            user.updateStatistics(1, intGesammterEinsatz, "Win", intGewinn);
        }
        
        lblGesammterEinsatzV.setText(intGesammterEinsatz + "");
        lblGewinnV.setText(intGewinn + "");
    }

    public void setUser(User user) {
        this.user = user;
        Kontostand = user.getBalance();
        lblKontostandV.setText(Kontostand + "");
    }
    

    public void setRoll() {
        if (arr.isEmpty() == true) {
            img1.setImage(king);
            img2.setImage(king);
            img3.setImage(king);
            img4.setImage(king);
            img5.setImage(king);
            img6.setImage(king);
            img7.setImage(king);
            img8.setImage(king);
            img9.setImage(king);
            img10.setImage(king);
            img11.setImage(king);
            img12.setImage(king);
            img13.setImage(king);
            img14.setImage(king);
            img15.setImage(king);
            img16.setImage(king);
            img17.setImage(king);
            img18.setImage(king);
            img19.setImage(king);
            img20.setImage(king);
            img21.setImage(king);
            img22.setImage(king);
            img23.setImage(king);
            img24.setImage(king);
            img25.setImage(king);
            slots.add(img1);
            slots.add(img2);
            slots.add(img3);
            slots.add(img4);
            slots.add(img5);
            slots.add(img6);
            slots.add(img7);
            slots.add(img8);
            slots.add(img9);
            slots.add(img10);
            slots.add(img11);
            slots.add(img12);
            slots.add(img13);
            slots.add(img14);
            slots.add(img15);
            slots.add(img16);
            slots.add(img17);
            slots.add(img18);
            slots.add(img19);
            slots.add(img20);
            slots.add(img21);
            slots.add(img22);
            slots.add(img23);
            slots.add(img24);
            slots.add(img25);
        } else {
            for (int i = 0; i < 25; i++) {
                 if((SlotSign) arr.get(i) == SlotSign.ASS){
                    slots.get(i).setImage(ass);
                }else if((SlotSign) arr.get(i) == SlotSign.JOKER){
                    slots.get(i).setImage(joker);
                }else if((SlotSign) arr.get(i) == SlotSign.KING){
                    slots.get(i).setImage(king);
                }else if((SlotSign) arr.get(i) == SlotSign.QUEEN){
                    slots.get(i).setImage(queen);
                }else if((SlotSign) arr.get(i) == SlotSign.JUNGE){
                    slots.get(i).setImage(junge);
                }else if((SlotSign) arr.get(i) == SlotSign.TEN){
                    slots.get(i).setImage(ten);
                }else if((SlotSign) arr.get(i) == SlotSign.LIBERTE){
                    slots.get(i).setImage(liberte);
                }
            }
        }

    }

    

    @FXML
    private void btnStartClick(ActionEvent event) {
        
        if (intGesammterEinsatz <= Kontostand) {
            arr.clear();
            arr = vm.getSol(lines);
            setRoll();
            Kontostand -= intGesammterEinsatz;
            user.setBalance(Kontostand);
            lblKontostandV.setText(Kontostand + "");
            intGewinn = ((int) arr.get(25))*lines ;
            bind();
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @FXML
    private void btnTwoLinesClick(ActionEvent event) {
        lines = 2;//*1
        intGesammterEinsatz = 2;
        bind();
    }

    @FXML
    private void btnThreeLinesClick(ActionEvent event) {
        lines = 3;//*2
        intGesammterEinsatz = 6;
        bind();
    }

    @FXML
    private void btnFourLinesClick(ActionEvent event) {
        lines = 4;//*3
        intGesammterEinsatz = 12;
        bind();
    }

    @FXML
    private void btnFiveLinesClick(ActionEvent event) {
        lines = 5;//*5
        intGesammterEinsatz = 25;
        bind();
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        vm.backToMenu();
    }
    
}
