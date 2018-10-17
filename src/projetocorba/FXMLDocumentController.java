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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Nonato Dias
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private JFXButton btnCMD;

    @FXML
    private JFXButton btnStart;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCMD.setOnAction((e)->{
            /*openWindow("FXMLMuseum.fxml");
            openWindow("FXMLWatch.fxml");
            openWindow("FXMLAlert.fxml");*/
            String command = "cmd.exe /c START";

            try {
                Process child = Runtime.getRuntime().exec(command);
                System.out.println("CMD");
        
            } catch (IOException ex) {
                
                System.out.println("ERROR: tnameserv já iniciado");
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnStart.setOnAction((e)->{
            openWindow("FXMLMuseum.fxml");
            openWindow("FXMLWatch.fxml");
            openWindow("FXMLAlert.fxml");
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
