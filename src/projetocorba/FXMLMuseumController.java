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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import projetocorba.corba.MuseumControl;
import projetocorba.util.LogUtil;

/**
 * FXML Controller class
 *
 * @author Nonato Dias
 */
public class FXMLMuseumController implements Initializable {
    private MuseumControl museumControl;
    
    int index_ = 0;
    
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
    
    @FXML
    private Label labelCount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initServer();
        
        btnPlus.setOnAction((e) -> {
            increaseVisitor();
        });
        
        btnMinus.setOnAction((e) -> {
            decreaseVisitor();
        });
    }    
    
    public void increaseVisitor(){
        moveSprite("UP", ()->{
            int c = museumControl.increaseVisitor();
            updateCountVisitorInTheView(c);
        });
    }
    
    public void decreaseVisitor(){
        moveSprite("DOWN", ()->{
            int c = museumControl.decreaseVisitor();
            updateCountVisitorInTheView(c);
        });
    }
    
    public void disableBtns(){
        btnPlus.setDisable(true);
        btnMinus.setDisable(true);
    }
    
    public void enableBtns(){
        btnPlus.setDisable(false);
        btnMinus.setDisable(false);
    }
    
    public void updateCountVisitorInTheView(int c){
        //int c = clientMuseum.getCount();
        labelCount.setText(""+c);
    }
    
    /**
     * Animação de movimento
     * @param d, sentido do movimento
     *    "UP" - para cima
     *    "DOWN" - para baixo
     * @param done, callback
     */
    public void moveSprite(String d, Runnable done){
        final int step;
        final String prefix;
        double y0;
        switch(d){
            case "UP":
                step = -19;
                prefix = "up";
                y0 = 300;
                break;
            case "DOWN":
                step = +19;
                prefix = "down";
                y0 = 227;
                break;
            default:
                return;
        }
        
        disableBtns();
        index_ = 0;
        int [] order = {1, 3, 1, 2};
        grpSprite.setLayoutY(y0);
        imgSprite.setImage(new Image("img/"+prefix+"-"+order[index_]+".png"));
        
        TranslateTransition translateTransition = new TranslateTransition();  
        translateTransition.setDuration(Duration.millis(400)); 
        translateTransition.setNode(grpSprite);
        
        translateTransition.setFromY(0);
        translateTransition.setByY(step);
        translateTransition.setAutoReverse(false); 
        translateTransition.setOnFinished((e)->{
            index_ +=1;
            if(index_ < 4){
                imgSprite.setImage(new Image("img/"+prefix+"-"+order[index_]+".png"));
                translateTransition.setFromY(index_* step);
                translateTransition.setByY(step);
                translateTransition.play();
            }else{
                imgSprite.setImage(null);
                translateTransition.stop();
                done.run();
                enableBtns();
            }
        });
        translateTransition.play();
    }
    
    private void log(String msg){
        LogUtil.log("MUSEUM CONTROLLER", msg);
    }

    private void initServer() {
        museumControl = new MuseumControl();
        museumControl.setImgMuseum(imgMuseum);
        
        Thread t = new Thread(() -> {
            
            museumControl.getOnReady(()->{
                int c = museumControl.getCount();
                updateCountVisitorInTheView(c);
            });
            
            museumControl.run();
        });
        t.setDaemon(true);
        t.start();
    }
}
