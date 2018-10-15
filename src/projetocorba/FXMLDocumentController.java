/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import projetocorba.corba.ClientMuseum;
import projetocorba.corba.Server;

/**
 *
 * @author Nonato Dias
 */
public class FXMLDocumentController implements Initializable {
    
    private Server server;
    
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private Button button1;
    
    @FXML
    private JFXButton btnWatchman;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("click ok");
        Thread t = new Thread(() -> {
            System.out.println("SERVIDOR");
            server.run();
        });
        t.setDaemon(true);
        t.start();
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("click ok");

        openWindow("FXMLMuseum.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        server = new Server();
        
        btnWatchman.setOnAction((e)->{
            openWindow("FXMLWatchman.fxml");
        });
    }    
    
    
    public void openWindow(String fxml){
        Parent game = null;
        try {
            game = FXMLLoader.load(getClass().getResource(fxml));
        } catch (IOException ex) {
            //log("ERROR: "+ex.toString());
        }
        Stage stage = new Stage();
        Scene scene = new Scene(game);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
}
