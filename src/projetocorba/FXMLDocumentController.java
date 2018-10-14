/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Nonato Dias
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private Button button1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("click ok");
        Thread t = new Thread(() -> {
            System.out.println("SERVIDOR");
            Servidor.run();
        });
        t.setDaemon(true);
        t.start();
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("click ok");

        Thread t2 = new Thread(() -> {
            System.out.println("CLIENT");
            Cliente.run();
        });
        t2.setDaemon(true);
        t2.start();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    
    
}
