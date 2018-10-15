/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import projetocorba.corba.WatchClient;
import projetocorba.corba.WatchControl;

/**
 * FXML Controller class
 *
 * @author Nonato Dias
 */
public class FXMLWatchmanController implements Initializable {

    private WatchControl watchControl;
    
    @FXML
    private ImageView imgBell;
    
    @FXML
    private Label displayCount;
    
    @FXML
    private JFXRadioButton radioDay;

    @FXML
    private JFXRadioButton radioNight;
    
    private ToggleGroup toggleGrp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGrp = new ToggleGroup();
        radioDay.setToggleGroup(toggleGrp);
        radioNight.setToggleGroup(toggleGrp);
        radioDay.setSelected(true);
        
        toggleGrp.selectedToggleProperty().addListener((obs)->{
            if (toggleGrp.getSelectedToggle() != null) {

                JFXRadioButton selectedRadioButton = (JFXRadioButton) toggleGrp.getSelectedToggle();
                String sel = selectedRadioButton.getText().equals("DIA") ? "DAY" : "NIGHT";
                watchControl.setTurn(sel);
            }
        });
        
        initServer();
        ring(false);
    }    
    
    private void initServer() {
        watchControl = new WatchControl();
        Platform.runLater(()->{
            watchControl.setDisplayCount(displayCount);
        });
        Thread t = new Thread(() -> {
            watchControl.getOnReady(()->{
                //initClient();
            });
            watchControl.run();
        });
        t.setDaemon(true);
        t.start();
    }
    
    public void ring(Boolean show){
        if(!show){
            imgBell.setVisible(false);
            return;
        }else{
            imgBell.setVisible(true);
        }
        FadeTransition ft = new FadeTransition(Duration.millis(800), imgBell);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
}
