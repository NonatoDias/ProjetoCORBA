/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import projetocorba.corba.ClientMuseum;

/**
 * FXML Controller class
 *
 * @author Nonato Dias
 */
public class FXMLMuseumController implements Initializable {

    private ClientMuseum clientMuseum;
    
    int count_ = 0;
    
    @FXML
    private Group grpSprite;
    
    @FXML
    private ImageView imgSprite;
    
    @FXML
    private ImageView imgMuseum;
    
    @FXML
    private JFXButton btnPlus;

    @FXML
    private JFXButton btnMinus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDayPeriod(1);
        
        btnPlus.setOnAction((event) -> {
            moveSpriteUP();
        });
        
        btnMinus.setOnAction((event) -> {
            moveSpriteDOWN();
        });
        
        
        //System.out.println("position "+imgSprite.localToScene(imgSprite.getBoundsInLocal()).getMinX());
        // TODO
        /*clientMuseum = new ClientMuseum();
        clientMuseum.init();*/
    }    
    
    public void disableBtns(){
        btnPlus.setDisable(true);
        btnMinus.setDisable(true);
    }
    
    public void enableBtns(){
        btnPlus.setDisable(false);
        btnMinus.setDisable(false);
    }
    
    /**
     * 
     * @param p 
     * 0 - manha
     * 1 - noite
     */
    public void setDayPeriod (int p){
        switch(p){
            case 0:
                imgMuseum.setImage(new Image("img/museum-0.png"));
                break;
            case 1:
                imgMuseum.setImage(new Image("img/museum-1.png"));
                break;
            default:
                break;
        }
    }
    
    public void moveSpriteDOWN(){
        disableBtns();
        count_ = 0;
        int [] order = {1, 3, 1, 2};
        int step = 19;
        grpSprite.setLayoutY(227);
        imgSprite.setImage(new Image("img/down-"+order[count_]+".png"));
        
        TranslateTransition translateTransition = new TranslateTransition();  
        translateTransition.setDuration(Duration.millis(400)); 
        translateTransition.setNode(grpSprite);
        
        translateTransition.setFromY(0);
        translateTransition.setByY(step);
        translateTransition.setAutoReverse(false); 
        translateTransition.setOnFinished((e)->{
            count_ +=1;
            if(count_ < 4){
                imgSprite.setImage(new Image("img/down-"+order[count_]+".png"));
                translateTransition.setFromY(count_* step);
                translateTransition.setByY(step);
                translateTransition.play();
            }else{
                imgSprite.setImage(null);
                translateTransition.stop();
                enableBtns();
            }
        });
        translateTransition.play();
    }
    
    public void moveSpriteUP(){ 
        disableBtns();
        count_ = 0;
        int [] order = {1, 3, 1, 2};
        int step = -19;
        grpSprite.setLayoutY(300);
        imgSprite.setImage(new Image("img/up-"+order[count_]+".png"));
        
        TranslateTransition translateTransition = new TranslateTransition();  
        translateTransition.setDuration(Duration.millis(400)); 
        translateTransition.setNode(grpSprite);
        
        translateTransition.setFromY(0);
        translateTransition.setByY(step);
        translateTransition.setAutoReverse(false); 
        translateTransition.setOnFinished((e)->{
            count_ +=1;
            if(count_ < 4){
                imgSprite.setImage(new Image("img/up-"+order[count_]+".png"));
                translateTransition.setFromY(count_* step);
                translateTransition.setByY(step);
                translateTransition.play();
            }else{
                imgSprite.setImage(null);
                translateTransition.stop();
                enableBtns();
            }
        });
        translateTransition.play();
    }
}
