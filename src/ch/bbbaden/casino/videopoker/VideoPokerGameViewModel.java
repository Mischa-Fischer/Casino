/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.MainApp;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 *
 * @author misch
 */
public class VideoPokerGameViewModel implements PropertyChangeListener {

    private VideoPokerGameModel model;
    private MainApp mainApp;
    private ArrayList<Card> deck = new ArrayList();
    private StringProperty winTxt = new SimpleStringProperty();
    private StringProperty coinVal = new SimpleStringProperty();
    private StringProperty coinAnz = new SimpleStringProperty();
    private StringProperty winQuote = new SimpleStringProperty();
    private StringProperty balance = new SimpleStringProperty();
    private boolean ersteRunde = true;

    public VideoPokerGameViewModel(VideoPokerGameModel model) {
        this.model = model;
        coinVal.setValue("0.25 $");
        coinAnz.setValue("1");
        balance.setValue(Double.toString(model.getBalance()));
    }

    public StringProperty getCoinVal() {
        return coinVal;
    }

    public StringProperty getWinQuote() {
        return winQuote;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //verbindung mit dem Model
        if (evt.getPropertyName().equals("Bet")) {
            coinAnz.set(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("updateCoin")) {
            coinVal.set(evt.getNewValue().toString() + " $");
        } else if (evt.getPropertyName().equals("win")) {
            winQuote.set(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("winTxt")) {
            winTxt.set(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("balanceUpdate")) {
            balance.set(evt.getNewValue().toString());
        }

    }

    public StringProperty getBalance() {
        return balance;
    }

    public StringProperty getCoinAnz() {
        return coinAnz;
    }

    public void bet1() {
        model.coinAnzBet1();
    }

    public void bet5() {
        model.coinAnzBet5();
    }

    public void setCoinVal() {
        model.setCoinVal();
    }

    public void spiele() {
        winTxt.set("");
        model.deal();
        deck = model.getCardsOnTable();
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    public void card(int i) {
        model.card1Hold(i);
    }

    public StringProperty getWinTxt() {
        return winTxt;
    }

    public void gamble() {
        model.gamble();
        deck = model.getCardsOnTable();
    }

    public void vergleicheCardsGamble(int i) {
        model.vergleicheCardsGamble(i);
    }

    public void hilfe() {
        mainApp.showVideoPokerHilfe();
    }

    public void goToMenu() {
        
        int eingabe = JOptionPane.showConfirmDialog(null, "Wollen Sie das Spiel wirklich abbrechen? "
                + "Ihr Einsatz geht verloren.", "Abbruch", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            mainApp.showMainMenu();
        }
    }

    public double getPlayerBalance() {
        return model.getBalance();
    }

    public double getCoins() {
        return model.getCoinVal();
    }
}
