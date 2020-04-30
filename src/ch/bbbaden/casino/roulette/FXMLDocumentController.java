/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.roulette;

import ch.bbbaden.casino.MainApp;
import ch.bbbaden.casino.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zeno
 */
public class FXMLDocumentController implements Initializable {

    MainApp mainApp;
    RouletteModel m;
    ArrayList<Button> btns = new ArrayList();
    int faktor = 0;
    int wert = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    User user;

    @FXML
    private Label lblErgebnis;
    @FXML
    private ComboBox<Integer> comChipwert;
    @FXML
    private Label lblGewinn;

    public void bind() {
        lblKontostandV.setText(300 + "");

    }

    @FXML
    private Button btnPlay;
    @FXML
    private Text lblKontostand;
    @FXML
    private Text lblGesammteinsatz;
    @FXML
    private Text lblChipwert;
    @FXML
    private Button btnHilfe;
    @FXML
    private ImageView btnHome;
    @FXML
    private Label lblKontostandV;
    @FXML
    private Label lblGesammteinsatzV;
    @FXML
    private Button btnZero;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnSix;
    @FXML
    private Button btnFive;
    @FXML
    private Button btnTwelve;
    @FXML
    private Button btnNine;
    @FXML
    private Button btnSeven;
    @FXML
    private Button btnEigthteen;
    @FXML
    private Button btnSixteen;
    @FXML
    private Button btnFourteen;
    @FXML
    private Button btnTwentyone;
    @FXML
    private Button btnNineteen;
    @FXML
    private Button btnTwentythree;
    @FXML
    private Button btnTwentyfive;
    @FXML
    private Button btnTwentyseven;
    @FXML
    private Button btnThirtysix;
    @FXML
    private Button btnThirtyfour;
    @FXML
    private Button btnThirtytwo;
    @FXML
    private Button btnThirty;
    @FXML
    private Button btnFour;
    @FXML
    private Button btnEight;
    @FXML
    private Button btnEleven;
    @FXML
    private Button btnTen;
    @FXML
    private Button btnFifteen;
    @FXML
    private Button btnThirteen;
    @FXML
    private Button btnSeventeen;
    @FXML
    private Button btnTwenty;
    @FXML
    private Button btnTwentyfour;
    @FXML
    private Button btnTwentytwo;
    @FXML
    private Button btnTwentysix;
    @FXML
    private Button btnTwentynine;
    @FXML
    private Button btnTwentyeigth;
    @FXML
    private Button btnThirtythree;
    @FXML
    private Button btnThirtyone;
    @FXML
    private Button btnThirtyfive;
    @FXML
    private Button btnLineThree;
    @FXML
    private Button btnLineOne;
    @FXML
    private Button btnLineTwo;
    @FXML
    private Button btnOneToTwelfe;
    @FXML
    private Button btnThirteenToTwentyfour;
    @FXML
    private Button btnTwentyfiveToThirtysix;
    @FXML
    private Button btnOneToEightteen;
    @FXML
    private Button btnGerade;
    @FXML
    private Button btnRed;
    @FXML
    private Button btnBlack;
    @FXML
    private Button btnNineteenToThirtysix;
    @FXML
    private Button btnUngerade;
    @FXML
    private Button btnClear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comChipwert.getItems().add(1);
        comChipwert.getItems().add(2);
        comChipwert.getItems().add(3);
        comChipwert.getItems().add(4);
        comChipwert.getItems().add(5);
        comChipwert.setValue(1);
        btns.add(btnZero);
        btns.add(btnOne);
        btns.add(btnTwo);
        btns.add(btnThree);
        btns.add(btnFive);
        btns.add(btnSix);
        btns.add(btnSeven);
        btns.add(btnEight);
        btns.add(btnNine);
        btns.add(btnTen);
        btns.add(btnEleven);
        btns.add(btnTwelve);
        btns.add(btnThirteen);
        btns.add(btnFourteen);
        btns.add(btnFifteen);
        btns.add(btnSixteen);
        btns.add(btnSeventeen);
        btns.add(btnEigthteen);
        btns.add(btnNineteen);
        btns.add(btnTwenty);
        btns.add(btnTwentyone);
        btns.add(btnTwentytwo);
        btns.add(btnTwentythree);
        btns.add(btnTwentyfour);
        btns.add(btnTwentyfive);
        btns.add(btnTwentysix);
        btns.add(btnTwentyseven);
        btns.add(btnTwentyeigth);
        btns.add(btnTwentynine);
        btns.add(btnThirty);
        btns.add(btnThirtyone);
        btns.add(btnThirtytwo);
        btns.add(btnThirtythree);
        btns.add(btnThirtyfour);
        btns.add(btnThirtyfive);
        btns.add(btnThirtysix);
        btns.add(btnLineOne);
        btns.add(btnLineTwo);
        btns.add(btnLineThree);
        btns.add(btnOneToTwelfe);
        btns.add(btnThirteenToTwentyfour);
        btns.add(btnTwentyfiveToThirtysix);
        btns.add(btnOneToEightteen);
        btns.add(btnGerade);
        btns.add(btnRed);
        btns.add(btnBlack);
        btns.add(btnNineteenToThirtysix);
        btns.add(btnUngerade);
    }

    @FXML
    private void btnPlayClick(ActionEvent event) {

        if (arr.size() >= 1) {
            lblGesammteinsatzV.setText((arr.size() * comChipwert.getValue()) + "");
            if (arr.size() * comChipwert.getValue() > user.getBalance()) {
                JOptionPane.showMessageDialog(null,
                    "Sie haben zu wenig Geld!",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
            } else {
                boolean[] bol = m.getWin(arr);
                if (bol[0] == false) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
                lblErgebnis.setText(m.getRandNum() + "");
                arr = m.getSortArrayList();
                Zaehler z = new Zaehler();
                faktor = z.doIt(arr, bol);
                System.out.println(faktor);
                wert = comChipwert.getValue();
                double gesetzt = wert;
                wert = wert * faktor;
                if(wert == 0){
                    user.setBalance(user.getBalance()-gesetzt);
                     user.updateStatistics(3, gesetzt, "Loose", -gesetzt);
                }else{
                    user.setBalance(user.getBalance()-gesetzt+wert);
                    user.updateStatistics(3, gesetzt, "win", wert-gesetzt);
                }
                lblGewinn.setText(wert + "");
                lblKontostandV.setText(user.getBalance() + "");
                arr.clear();
                for (int i = 0; i < 48; i++) {
                    if (btns.get(i).isDisable()) {
                        btns.get(i).setDisable(false);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sie müssen Felder auf dem Brett auswählen!",
                    "Fehler Meldung",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setModel(RouletteModel m) {
        this.m = m;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUser(User user) {
        this.user = user;
        lblKontostandV.setText(user.getBalance() + "");
    }

    @FXML
    private void btnHilfeClick(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Bei Roulette muss man zuerst, "
                + "oben links in der DropDown List den Wert eines Coins auszuwählen "
                + "un dann kann man auf dem Spielbrett den Ort ankilcken, "
                + "auf den man setzten will."
                + " \nDanach muss man auf Spielen klicken. "
                + "\n"
                + "Danach steht links neben dem Roulette, welche Zahl es geworden ist "
                + "und rechts neben dran wie viel man gewonnen hat. "
                + "\n"
                + "Der gewonnene Betrag wird direkt dem Konto gut geschrieben. ", 
               "Hilfe", JOptionPane.INFORMATION_MESSAGE);

    }

    @FXML
    private void btnHomeClick(MouseEvent event) {
        mainApp.showMainMenu();

    }

    @FXML
    private void btnZeroClick(ActionEvent event) {
        arr.add(0);
        btnZero.setDisable(true);
    }

    @FXML
    private void btnThreeClick(ActionEvent event) {
        arr.add(3);
        btnThree.setDisable(true);
    }

    @FXML
    private void btnTwoClick(ActionEvent event) {
        arr.add(2);
        btnTwo.setDisable(true);
    }

    @FXML
    private void btnOneClick(ActionEvent event) {
        arr.add(1);
        btnOne.setDisable(true);
    }

    @FXML
    private void btnSixClick(ActionEvent event) {
        arr.add(6);
        btnSix.setDisable(true);
    }

    @FXML
    private void btnFiveClick(ActionEvent event) {
        arr.add(5);
        btnFive.setDisable(true);
    }

    @FXML
    private void btnTwelveClick(ActionEvent event) {
        arr.add(12);
        btnTwelve.setDisable(true);
    }

    @FXML
    private void btnNineClick(ActionEvent event) {
        arr.add(9);
        btnNine.setDisable(true);
    }

    @FXML
    private void btnSevenClick(ActionEvent event) {
        arr.add(7);
        btnSeven.setDisable(true);
    }

    @FXML
    private void btnEigthteenClick(ActionEvent event) {
        arr.add(18);
        btnEigthteen.setDisable(true);
    }

    @FXML
    private void btnSixteenClick(ActionEvent event) {
        arr.add(16);
        btnSixteen.setDisable(true);
    }

    @FXML
    private void btnFourteenClick(ActionEvent event) {
        arr.add(14);
        btnFourteen.setDisable(true);
    }

    @FXML
    private void btnTwentyoneClick(ActionEvent event) {
        arr.add(21);
        btnTwentyone.setDisable(true);
    }

    @FXML
    private void btnNineteenClick(ActionEvent event) {
        arr.add(19);
        btnNineteen.setDisable(true);
    }

    @FXML
    private void btnTwentythreeClick(ActionEvent event) {
        arr.add(23);
        btnTwentythree.setDisable(true);
    }

    @FXML
    private void btnTwentyfiveClick(ActionEvent event) {
        arr.add(25);
        btnTwentyfive.setDisable(true);
    }

    @FXML
    private void btnTwentysevenClick(ActionEvent event) {
        arr.add(27);
        btnTwentyseven.setDisable(true);
    }

    @FXML
    private void btnThirtysixClick(ActionEvent event) {
        arr.add(36);
        btnThirtysix.setDisable(true);
    }

    @FXML
    private void btnThirtyfourClick(ActionEvent event) {
        arr.add(34);
        btnThirtyfour.setDisable(true);
    }

    @FXML
    private void btnThirtytwoClick(ActionEvent event) {
        arr.add(32);
        btnThirtytwo.setDisable(true);
    }

    @FXML
    private void btnThirtyClick(ActionEvent event) {
        arr.add(30);
        btnThirty.setDisable(true);
    }

    @FXML
    private void btnFourClick(ActionEvent event) {
        arr.add(4);
        btnFour.setDisable(true);
    }

    @FXML
    private void btnEightClick(ActionEvent event) {
        arr.add(8);
        btnEight.setDisable(true);
    }

    @FXML
    private void btnElevenClick(ActionEvent event) {
        arr.add(11);
        btnEleven.setDisable(true);
    }

    @FXML
    private void btnTenClick(ActionEvent event) {
        arr.add(10);
        btnTen.setDisable(true);
    }

    @FXML
    private void btnFifteenClick(ActionEvent event) {
        arr.add(15);
        btnFifteen.setDisable(true);
    }

    @FXML
    private void btnThirteenClick(ActionEvent event) {
        arr.add(13);
        btnThirteen.setDisable(true);
    }

    @FXML
    private void btnSeventeenClick(ActionEvent event) {
        arr.add(17);
        btnSeventeen.setDisable(true);
    }

    @FXML
    private void btnTwentyClick(ActionEvent event) {
        arr.add(20);
        btnTwenty.setDisable(true);
    }

    @FXML
    private void btnTwentyfourClick(ActionEvent event) {
        arr.add(24);
        btnTwentyfour.setDisable(true);
    }

    @FXML
    private void btnTwentytwoClick(ActionEvent event) {
        arr.add(22);
        btnTwentytwo.setDisable(true);
    }

    @FXML
    private void btnTwentysixClick(ActionEvent event) {
        arr.add(26);
        btnTwentysix.setDisable(true);
    }

    @FXML
    private void btnTwentynineClick(ActionEvent event) {
        arr.add(29);
        btnTwentynine.setDisable(true);
    }

    @FXML
    private void btnTwentyeigthClick(ActionEvent event) {
        arr.add(28);
        btnTwentyeigth.setDisable(true);
    }

    @FXML
    private void btnThirtythreeClick(ActionEvent event) {
        arr.add(33);
        btnThirtythree.setDisable(true);
    }

    @FXML
    private void btnThirtyoneClick(ActionEvent event) {
        arr.add(31);
        btnThirtyone.setDisable(true);
    }

    @FXML
    private void btnThirtyfiveClick(ActionEvent event) {
        arr.add(35);
        btnThirtyfive.setDisable(true);
    }

    @FXML
    private void btnLineThreeClick(ActionEvent event) {
        arr.add(39);
        btnLineThree.setDisable(true);
    }

    @FXML
    private void btnLineOneClick(ActionEvent event) {
        arr.add(37);
        btnLineOne.setDisable(true);
    }

    @FXML
    private void btnLineTwoClick(ActionEvent event) {
        arr.add(38);
        btnLineTwo.setDisable(true);
    }

    @FXML
    private void btnOneToTwelfeClick(ActionEvent event) {
        arr.add(40);
        btnOneToTwelfe.setDisable(true);
    }

    @FXML
    private void btnThirteenToTwentyfourClick(ActionEvent event) {
        arr.add(41);
        btnThirteenToTwentyfour.setDisable(true);
    }

    @FXML
    private void btnTwentyfiveToThirtysixClick(ActionEvent event) {
        arr.add(42);
        btnTwentyfiveToThirtysix.setDisable(true);
    }

    @FXML
    private void btnOneToEightteen(ActionEvent event) {
        arr.add(43);
        btnOneToEightteen.setDisable(true);
    }

    @FXML
    private void btnGeradeClick(ActionEvent event) {
        arr.add(45);
        btnGerade.setDisable(true);
    }

    @FXML
    private void btnRedClick(ActionEvent event) {
        arr.add(47);
        btnRed.setDisable(true);
    }

    @FXML
    private void btnBlackClick(ActionEvent event) {
        arr.add(48);
        btnBlack.setDisable(true);
    }

    @FXML
    private void btnNineteenToThirtysixClick(ActionEvent event) {
        arr.add(44);
        btnNineteenToThirtysix.setDisable(true);
    }

    @FXML
    private void btnUngeradeClick(ActionEvent event) {
        arr.add(46);
        btnUngerade.setDisable(true);
    }

    @FXML
    private void btnClearClick(ActionEvent event) {
        arr.clear();
        for (int i = 0; i < 48; i++) {
            if (btns.get(i).isDisable()) {
                btns.get(i).setDisable(false);
            }
        }
    }

}
