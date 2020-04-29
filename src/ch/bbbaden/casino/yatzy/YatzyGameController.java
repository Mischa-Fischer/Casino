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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author misch
 */
public class YatzyGameController implements Initializable {

    MainApp mainApp;
    User user;

    int versuche = 3;
    double einzahlung = 0;

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
    @FXML
    private TextField textFieldBetrag;
    @FXML
    private Button hilfeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonwuerfeln.setDisable(true);
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
        updateVersuche();

        int eins = generator(1, 6);
        int zwei = generator(1, 6);
        int drei = generator(1, 6);
        int vier = generator(1, 6);
        int fünf = generator(1, 6);
        dice1.setText(Integer.toString(eins));
        dice2.setText(Integer.toString(zwei));
        dice3.setText(Integer.toString(drei));
        dice4.setText(Integer.toString(vier));
        dice5.setText(Integer.toString(fünf));
        labelversuche.setText(Integer.toString(versuche));

        if (versuche == 0) {
            buttonwuerfeln.setDisable(true);
        }
    }

    private void updateVersuche() {
        versuche--;
    }

    @FXML
    private void handleAbbruch(ActionEvent event) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Wollen Sie das Spiel wirklich abbrechen? "
                + "Ihr Einsatz geht verloren.", "Abbruch", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            mainApp.showMainMenu();
        }
    }

    private int generator(int min, int max) {
        Random generated = new Random();
        int zufallszahl = generated.nextInt(max + 1 - min) + min;
        return zufallszahl;
    }

    @FXML
    private void handleBetrag(ActionEvent event) {
        try {
            einzahlung = Double.parseDouble(textFieldBetrag.getText());
            if (einzahlung <= user.getBalance()) {
                buttonwuerfeln.setDisable(false);
                betragsetzenbutton.setDisable(true);
                textFieldBetrag.setDisable(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sie haben zu wenig Geld",
                        "Fehler", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Keinen richtigen Betrag gesetzt!!",
                        "Fehler", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void handleHilfe(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Bei Yatzy geht es darum, "
                + "mit den 5 Würfeln die Kombinationen zu erwürfeln, die "
                + "in der Spieltabelle vorgegeben sind. Gespielt werden "
                + "13 Runden, da es 13 verschiedene Kombinationen gibt."
                + " \nJeder Spieler darf pro Runde dreimal hintereinander "
                + "würfeln.\n"
                + "Nach jedem Wurf muss er entscheiden, welche Würfel er "
                + "\"stehen\" lässt. Ein Würfel wird durch Klick auf die "
                + "Würfel fixiert."
                + "\n"
                + "Ist bereits der erste Wurf perfekt, muss natürlich nicht "
                + "erneut gewürfelt werden. Spätestens nach dem 3. Wurf muss "
                + "jedoch die entstandene Würfelkombination in eines der 13 "
                + "Felder eingetragen werden. \nWird keine Kombination erreicht,"
                + " muss bei einem Feld 0 als Punktzahl eingetragen werden.",
                "Hilfe", JOptionPane.INFORMATION_MESSAGE);
    }

}
