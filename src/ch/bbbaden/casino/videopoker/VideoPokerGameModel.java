/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino.videopoker;

import ch.bbbaden.casino.User;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author misch
 */
public class VideoPokerGameModel {

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    //initialisierung von Variablen
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> cardsOnTable = new ArrayList<>();
    private int cards;
    private int winQuote = 0;
    private String winTxt = "";
    private int coinAnz = 1;
    private double coinVal = 0.25;
    private boolean ersteRunde = true;
    private User user;
    private double balance;
    private boolean canGamble = false;
    private double gesetzt;
    private double multiplicator = 0;
    private double gewonnen = 0;

    public VideoPokerGameModel(User user) {
        this.user = user;
        balance = user.getBalance();
    }

    public void AddPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void generateCards() {
        //Kartendeck generieren
        deck.removeAll(deck);
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, color));
            }
        }
        Collections.shuffle(deck);
    }

    public double getBalance() {
        return balance;
    }
    public double getCoinVal(){
        return coinAnz*coinVal;
    }

    public void coinAnzBet1() {
        //1 coin wetten
        if (ersteRunde == true && canGamble == false) {
            int oldCoin = coinAnz;
            if (coinAnz == 5) {
                coinAnz = 1;
            } else {
                //Überprüfung ob genug Geld
                if ((coinAnz + 1) * coinVal > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um die Coin Anzahl hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinAnz = 1;
                } else {
                    coinAnz += 1;
                }

            }
            changes.firePropertyChange("Bet", oldCoin, coinAnz);
        }else{
             JOptionPane.showMessageDialog(null,
                            "Sie können erst nach der Runde die Coin Anzahl verändern!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
            
        }
    }

    public void coinAnzBet5() {
        //5 coins wetten
        if (ersteRunde == true && canGamble == false) {
            int oldCoin = coinAnz;
            //Überprüfung ob genug Geld
            if (coinVal * 5 > balance) {
                JOptionPane.showMessageDialog(null,
                        "Sie haben zu wenig Geld um die Coin Anzahl hochzusetzen!",
                        "Fehler Meldung",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                coinAnz = 5;
            }

            changes.firePropertyChange("Bet", oldCoin, coinAnz);
        }else{
            JOptionPane.showMessageDialog(null,
                            "Sie können erst nach der Runde die Coin Anzahl verändern!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setCoinVal() {
        //Einsetzen wie viel ein Coin Wert ist
        if (ersteRunde == true && canGamble == false) {
            double oldValue = coinVal;
            if (coinVal == 0.25) {
                //Überprüfung ob genug Geld
                if (0.5 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 0.5;
                }

            } else if (coinVal == 0.5) {
                //Überprüfung ob genug Geld
                if (1 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 1;
                }

            } else if (coinVal == 1) {
                //Überprüfung ob genug Geld
                if (2 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 2;
                }

            } else if (coinVal == 2) {
                //Überprüfung ob genug Geld
                if (5 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 5;
                }

            } else if (coinVal == 5) {
                //Überprüfung ob genug Geld
                if (10 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 10;
                }

            } else if (coinVal == 10) {
                //Überprüfung ob genug Geld
                if (50 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 50;
                }

            } else if (coinVal == 50) {
                //Überprüfung ob genug Geld
                if (100 * coinAnz > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben zu wenig Geld um den Coin Wert hochzusetzen!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
                    coinVal = 0.25;
                } else {
                    coinVal = 100;
                }

            } else {
                coinVal = 0.25;
            }
            changes.firePropertyChange("updateCoin", oldValue, coinVal);
        }else{
            JOptionPane.showMessageDialog(null,
                            "Sie können erst nach der Runde den Coin Wert verändern!",
                            "Fehler Meldung",
                            JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deal() {
        if (ersteRunde == true) {
            //erste Runde
            gesetzt = coinAnz * coinVal;
            double oldBalance = balance;
            balance = balance - coinAnz * coinVal;
            changes.firePropertyChange("balanceUpdate", oldBalance, balance);
            user.setBalance(balance);
            generateCards();
            cardsOnTable.removeAll(cardsOnTable);
            for (int i = 0; i < 5; i++) {
                cardsOnTable.add(deck.get(i));
            }
            cards = 4;
            winQuote = -1;
            gewinnUeberpruefung();

            ersteRunde = false;
        } else {
            //zweite Runde
            ersteRunde = true;
            ArrayList<Integer> intRemove = new ArrayList<>();
            int anz = 0;
            int y = 0;
            for (Card card : cardsOnTable) {
                if (card.getHold() == false) {
                    intRemove.add(y - anz);
                    anz++;
                }
                y++;
            }
            for (int i : intRemove) {
                cardsOnTable.remove(i);
            }
            int m = 1;
            for (int i = 4 - anz; i < 4; i++) {
                cardsOnTable.add(deck.get(cards + m));
                m++;
            }
            gewinnUeberpruefung();
            String oldWinTxt = winTxt;
            //Text updates und Geld update des Spielers
            if (winQuote > 0) {
                winTxt = "Win";
                gewonnen = gesetzt + gesetzt * multiplicator;
                double oldBalance = balance;
                balance += gesetzt + gesetzt * multiplicator;
                user.setBalance(balance);
                user.updateStatistics(4, gesetzt, winTxt, gesetzt * multiplicator);
                changes.firePropertyChange("balanceUpdate", oldBalance, balance);
                changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
            } else {
                winTxt = "GameOver";
                user.updateStatistics(4, gesetzt, "Loose", gesetzt * (-1));
                changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
            }
        }
    }

    public void gamble() {
        //Gamble starten eine karten offen 4 gedeckt
        String oldWinTxt = winTxt;
        if (winTxt.equals("Gamble verloren") || winTxt.equals("Du hast verloren")) {
            winTxt = "Du hast verloren";
            changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
        } else {
            canGamble = true;
            generateCards();
            cardsOnTable.removeAll(cardsOnTable);
            for (int i = 0; i < 5; i++) {
                cardsOnTable.add(deck.get(i));
            }
            for (Card card : cardsOnTable) {
                card.setVerdeckt(true);
            }
            Random r = new Random();
            int i = r.nextInt(5);
            cardsOnTable.get(i).setVerdeckt(false);
        }
    }

    public void vergleicheCardsGamble(int i) {
        //Gemacht wenn man Karte umdreht
        if (winTxt.equals("Gamble verloren") || winTxt.equals("Du hast verloren") || cardsOnTable.get(i).isVerdeckt() == false) {

        } else {
            String oldWinTxt = winTxt;

            Card karte1 = null;
            Card karte2 = cardsOnTable.get(i);

            for (Card card : cardsOnTable) {
                if (card.isVerdeckt() == false) {
                    karte1 = card;
                }
            }
            cardsOnTable.get(i).setVerdeckt(false);
            if (karte2.getRank().getValue() > karte1.getRank().getValue()) {
                winTxt = "Gamble gewonnen";
                int winOld = winQuote;
                winQuote = winQuote * 2;
                canGamble = false;
                double oldBalance = balance;
                balance += gewonnen;
                user.setBalance(balance);

                user.updateStatistics(4, gewonnen, "Win gamble", gewonnen);
                gewonnen *= 2;
                changes.firePropertyChange("balanceUpdate", oldBalance, balance);
                changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
                changes.firePropertyChange("win", winOld, winQuote);
            } else if (karte2.getRank().getValue() < karte1.getRank().getValue()) {
                winTxt = "Gamble verloren";
                canGamble = false;
                double oldBalance = balance;
                balance -= gewonnen;
                user.setBalance(balance);
                user.updateStatistics(4, gewonnen, "Loose gamble", gewonnen * (-1));
                changes.firePropertyChange("balanceUpdate", oldBalance, balance);
                changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
            } else {
                winTxt = "Gamble unentschieden";
                canGamble = false;
                user.updateStatistics(4, gewonnen, "Draw gamble", 0);
                changes.firePropertyChange("winTxt", oldWinTxt, winTxt);
            }
        }

    }

    public void gewinnUeberpruefung() {
        //Start der Überprüfung des gewinnes, Zeigt an wie viel man gewonnen hat(Quote)
        int winOld = winQuote;
        if (natural_royal_flush() == true) {
            winQuote = coinAnz * 800;
            multiplicator = 800;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (vier_deuces() == true) {
            winQuote = coinAnz * 200;
            multiplicator = 200;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (wild_royal_flush() == true) {
            winQuote = coinAnz * 25;
            multiplicator = 25;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (funfGleiche() == true) {
            winQuote = coinAnz * 15;
            multiplicator = 15;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (straightFlush() == true) {
            winQuote = coinAnz * 9;
            multiplicator = 9;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (vierling() == true) {
            winQuote = coinAnz * 5;
            multiplicator = 5;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (fullHouse() == true) {
            winQuote = coinAnz * 3;
            multiplicator = 3;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (flush() == true) {
            winQuote = coinAnz * 2;
            multiplicator = 2;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (straight() == true) {
            winQuote = coinAnz * 2;
            multiplicator = 2;
            changes.firePropertyChange("win", winOld, winQuote);
        } else if (drilling() == true) {
            winQuote = coinAnz * 1;
            multiplicator = 1;
            changes.firePropertyChange("win", winOld, winQuote);
        } else {
            multiplicator = 0;
            winQuote = coinAnz * 0;
            changes.firePropertyChange("win", winOld, winQuote);
        }
    }

    public void card1Hold(int i) {
        //Karten von Hold zu nicht hold wecheseln oder umgekehrt wen Karte geklickt wurde
        if (cardsOnTable.get(i).getHold() == true) {
            cardsOnTable.get(i).setHold(false);
        } else {
            cardsOnTable.get(i).setHold(true);
        }
    }

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    //Alle Gewinn Sachen werden überprüft ab hier
    private boolean natural_royal_flush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i)) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        if (alleFarben == true) {
            if (rankA.contains(Rank.ACE) && rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean vier_deuces() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        int anzZwei = 0;
        for (int i = 0; i < rankA.size(); i++) {
            if (rankA.get(i) == Rank.TWO) {
                anzZwei += 1;
            }
        }
        if (anzZwei >= 4) {
            return true;
        }
        return false;
    }

    private boolean wild_royal_flush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i) || rankA.get(i)== Rank.TWO) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        if (alleFarben == true) {
            int anzZwei = 0;
            for (int i = 0; i < rankA.size(); i++) {
                if (rankA.get(i) == Rank.TWO) {
                    anzZwei += 1;
                }
            }
            switch (anzZwei) {
                case 1:
                    if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {

                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    }
                case 3:
                    if (rankA.contains(Rank.TEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.JACK)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.KING) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.TEN)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.KING)) {
                        return true;
                    } else if (rankA.contains(Rank.ACE) && rankA.contains(Rank.KING)) {
                        return true;
                    } else if (rankA.contains(Rank.QUEEN) && rankA.contains(Rank.ACE)) {
                        return true;
                    }
                case 4:
                    if (rankA.contains(Rank.TEN) || rankA.contains(Rank.JACK) || rankA.contains(Rank.QUEEN) || rankA.contains(Rank.KING) || rankA.contains(Rank.ACE)) {
                        return true;
                    }
                default:
                    return false;
            }
        } else {
            return false;
        }

    }

    private boolean funfGleiche() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }

        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        boolean ausgabe = false;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                ausgabe = true;
            } else {
                ausgabe = false;
                break;
            }
        }
        return ausgabe;
    }

    private boolean straightFlush() {
        ArrayList<Rank> rankA = new ArrayList<>();
        ArrayList<Color> color = new ArrayList<>();

        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i) || rankA.get(i) == Rank.TWO) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        if (alleFarben == true) {
            Collections.sort(rankA);
            if (rankA.get(4) == Rank.ACE) {
            return false;
            }
            Rank rank1 = null;
            if (rankA.get(0) != Rank.TWO) {
                rank1 = rankA.get(0);
            } else if (rankA.get(1) != Rank.TWO) {
                rank1 = rankA.get(1);
            } else if (rankA.get(2) != Rank.TWO) {
                rank1 = rankA.get(2);
            } else if (rankA.get(3) != Rank.TWO) {
                rank1 = rankA.get(3);
            } else if (rankA.get(4) != Rank.TWO) {
                rank1 = rankA.get(4);
            }
            int val = rank1.getValue();
            if (val == rankA.get(0).getValue() || rankA.get(0) == Rank.TWO) {
                if (rankA.get(0) != Rank.TWO) {
                    val++;
                }
                if (val == rankA.get(1).getValue() || rankA.get(1) == Rank.TWO) {
                    if (rankA.get(1) != Rank.TWO) {
                        val++;
                    }
                    if (val == rankA.get(2).getValue() || rankA.get(1) == Rank.TWO) {
                        if (rankA.get(2) != Rank.TWO) {
                            val++;
                        }
                        if (val == rankA.get(3).getValue() || rankA.get(3) == Rank.TWO) {
                            if (rankA.get(3) != Rank.TWO) {
                                val++;
                            }
                            if (val == rankA.get(4).getValue() || rankA.get(4) == Rank.TWO) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean vierling() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Rank rank1 = null;
        Collections.sort(rankA);
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        int anz = 0;
        Rank rank2 = null;
        int anz1 = 1;
        int anz2 = 0;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == Rank.TWO) {
                anz2 += 1;
            }
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                anz += 1;

            } else {
                if (rankA.get(i) == rank2) {
                    anz1 += 1;
                } else {
                    rank2 = rankA.get(i);
                    anz1 = 1;
                }
            }
        }
        anz1 += anz2;
        if (anz == 4 || anz1 == 4) {
            return true;
        }
        return false;
    }

    private boolean fullHouse() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        Rank rank2 = null;
        if (rankA.get(0) != Rank.TWO && rankA.get(0) != rank1) {
            rank2 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO && rankA.get(1) != rank1) {
            rank2 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO && rankA.get(2) != rank1) {
            rank2 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO && rankA.get(3) != rank1) {
            rank2 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO && rankA.get(4) != rank1) {
            rank2 = rankA.get(4);
        }
        int anz1 = 0;
        int anz2 = 0;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1) {
                anz1 += 1;
            } else if (rankA.get(i) == rank2) {
                anz2 += 1;
            }
            if (rankA.get(i) == Rank.TWO) {
                if (anz1 < 3) {
                    anz1++;
                } else {
                    anz2++;
                }
            }
        }
        if (anz1 == 3 && anz2 == 2 || anz1 == 2 && anz2 == 3) {
            return true;
        }
        return false;
    }

    private boolean flush() {
        ArrayList<Color> color = new ArrayList<>();
        for (Card card : cardsOnTable) {
            color.add(card.getColor());
        }
        boolean alleFarben = false;
        Color first = color.get(0);
        for (int i = 1; i < color.size(); i++) {
            if (first == color.get(i)) {
                alleFarben = true;
            } else {
                alleFarben = false;
                break;
            }
        }
        return alleFarben;
    }

    private boolean straight() {
        ArrayList<Rank> rankA = new ArrayList<>();

        boolean ausgabe = false;
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());

        }

        Collections.sort(rankA);

        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        int val = rank1.getValue();
        if (val == rankA.get(0).getValue() || rankA.get(0) == Rank.TWO) {
            if (rankA.get(0) != Rank.TWO) {
                val++;
            }
            if (val == rankA.get(1).getValue() || rankA.get(1) == Rank.TWO) {
                if (rankA.get(1) != Rank.TWO) {
                    val++;
                }
                if (val == rankA.get(2).getValue() || rankA.get(1) == Rank.TWO) {
                    if (rankA.get(2) != Rank.TWO) {
                        val++;
                    }
                    if (val == rankA.get(3).getValue() || rankA.get(3) == Rank.TWO) {
                        if (rankA.get(3) != Rank.TWO) {
                            val++;
                        }
                        if (val == rankA.get(4).getValue() || rankA.get(4) == Rank.TWO || val == 4 && rankA.get(4) == Rank.ACE || val == 5 && rankA.get(4) == Rank.ACE || val == 3 && rankA.get(4) == Rank.ACE) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean drilling() {
        ArrayList<Rank> rankA = new ArrayList<>();
        for (Card card : cardsOnTable) {
            rankA.add(card.getRank());
        }
        Collections.sort(rankA);
        Rank rank1 = null;
        if (rankA.get(0) != Rank.TWO) {
            rank1 = rankA.get(0);
        } else if (rankA.get(1) != Rank.TWO) {
            rank1 = rankA.get(1);
        } else if (rankA.get(2) != Rank.TWO) {
            rank1 = rankA.get(2);
        } else if (rankA.get(3) != Rank.TWO) {
            rank1 = rankA.get(3);
        } else if (rankA.get(4) != Rank.TWO) {
            rank1 = rankA.get(4);
        }
        int anzZwei = 0;
        for (int i = 0; i < rankA.size(); i++) {
            if (rankA.get(i) == Rank.TWO) {
                anzZwei += 1;
            }
        }
        if (anzZwei > 2) {
            return false;
        }
        int anz = 0;
        int anz2 = 1;
        Rank rank2 = null;
        for (int i = 0; i < 5; i++) {
            if (rankA.get(i) == rank1 || rankA.get(i) == Rank.TWO) {
                anz += 1;
            } else {
                if (rankA.get(i) == rank2) {
                    anz2 += 1;
                } else {
                    if (anz2 + anzZwei != 3) {
                        rank2 = rankA.get(i);
                        anz2 = 1;
                    }
                }
            }
        }
        anz2 += anzZwei;
        if (anz == 3 || anz2 == 3) {
            return true;
        }
        return false;
    }
}
