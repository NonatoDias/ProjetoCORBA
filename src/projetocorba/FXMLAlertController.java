/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import projetocorba.corba.AlertControl;

/**
 * FXML Controller class
 *
 * @author Nonato Dias
 */
public class FXMLAlertController implements Initializable {

    private AlertControl alertControl;
    
    @FXML
    private ImageView imgBell;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initServer();
    }    
    
    private void initServer() {
        alertControl = new AlertControl();
        Platform.runLater(()->{
            alertControl.setImgBell(imgBell);
        });
        Thread t = new Thread(() -> {
            alertControl.getOnReady(()->{
                //initClient();
            });
            alertControl.run();
        });
        t.setDaemon(true);
        t.start();
    }
}
