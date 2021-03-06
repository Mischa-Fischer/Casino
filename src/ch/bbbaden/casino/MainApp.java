/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casino;

import ch.bbbaden.casino.login.LoginController;
import ch.bbbaden.casino.login.SignUpController;
import ch.bbbaden.casino.mainmenu.*;
import ch.bbbaden.casino.videopoker.*;
import ch.bbbaden.casino.blackjack.*;
import ch.bbbaden.casino.SlotMachine.*;
import ch.bbbaden.casino.yatzy.*;
import ch.bbbaden.casino.roulette.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author misch
 */
public class MainApp extends Application {

    Stage stage;
    User user;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        showLogin();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void showMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/MainMenu.fxml"));
            Parent root;
            root = loader.load();
            MainMenuController view = loader.getController();

            MainMenuViewModel viewModel = new MainMenuViewModel(user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            view.userAdmin();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLogin() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/Login.fxml"));
            Parent root;
            root = loader.load();
            LoginController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.setTitle("Login");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showSignUp() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login/SignUp.fxml"));
            Parent root;
            root = loader.load();
            SignUpController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.setTitle("Registrierung");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showKasse() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/Kasse.fxml"));
            Parent root;
            root = loader.load();
            KasseController view = loader.getController();
            view.setMainApp(this);
            view.setUser(user);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.setTitle("Kasse");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showStatistik() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainmenu/Admin.fxml"));
            Parent root;
            root = loader.load();
            AdminController view = loader.getController();
            view.setMainApp(this);
            final Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.setTitle("Statistik");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showVideoPokerMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerMenu.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerMenuController view = loader.getController();
            VideoPokerMenuViewModel viewModel = new VideoPokerMenuViewModel(user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
             stage.setTitle("VideoPoker");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showVideoPokerGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerGame.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerGameController view = loader.getController();
            VideoPokerGameModel model = new VideoPokerGameModel(user);
            VideoPokerGameViewModel viewModel = new VideoPokerGameViewModel(model);
            viewModel.setMainApp(this);
            model.AddPropertyChangeListener(viewModel);
            view.setViewModel(viewModel);
            view.bind();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("VideoPoker");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showVideoPokerHilfe() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("videopoker/VideoPokerHilfe.fxml"));
            Parent root;
            root = loader.load();
            VideoPokerHilfeController view = loader.getController();
            view.setMainApp(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("VideoPoker");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showBlackjackMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("blackjack/BlackjackMenu.fxml"));
            Parent root;
            root = loader.load();
            BlackjackMenuController view = loader.getController();
            BlackjackMenuViewModel viewModel = new BlackjackMenuViewModel(user);
            viewModel.setMainApp(this);
            view.setViewModel(viewModel);
            view.bind();
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Blackjack");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showBlackjackGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("blackjack/BlackjackGame.fxml"));
            Parent root;
            root = loader.load();
            BlackjackGameController view = loader.getController();
            BlackjackGameModel model = new BlackjackGameModel();
            BlackjackGameViewModel viewModel = new BlackjackGameViewModel(model);
            viewModel.setMainApp(this);
            model.AddPropertyChangeListener(viewModel);
            view.setViewModel(viewModel);
            view.bind();
            view.setUser(user);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Blackjack");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void showSlots(){
        FXMLLoader loader = new FXMLLoader (this.getClass().getResource("SlotMachine/SlotsView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SlotsViewController view = loader.getController();
        Model model = new Model();
        final ViewModel viewModel = new ViewModel(model);
        view.setVM(viewModel);
        
        //view.bind();
        view.setUser(user);
        viewModel.setMainApp(this);
        Scene scene = new Scene(root);
        
        stage.setTitle("Slot-Machine");
        stage.setScene(scene);
        stage.show();
    }
    
     public void showYatzyGame(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("yatzy/YatzyGame.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        YatzyGameController view = loader.getController();
        view.setMainApp(this);
         view.setUser(user);

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Yatzy");
        stage.show();
    }
      public void showYatzyMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("yatzy/YatzyMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        YatzyMenuController view = loader.getController();
        view.setMainApp(this);
        view.setUser(user);
        

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Yatzy");
        stage.show();
    }
      
      
      public void showRouletteGame(){
        FXMLLoader loader = new FXMLLoader (this.getClass().getResource("roulette/FXMLDocument.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FXMLDocumentController view = loader.getController();
        RouletteModel model = new RouletteModel();
        view.setModel(model);
        view.setMainApp(this);
        view.bind();
        view.setUser(user);
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Roulette");
        stage.show();
        
    }
    public void showRouletteMenu(){
        FXMLLoader loader = new FXMLLoader (this.getClass().getResource("roulette/RouletteMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         RouletteMenuController view = loader.getController();
        view.setMainApp(this);
        view.setUser(user);
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Roulette");
        stage.show();
        
    }

}
