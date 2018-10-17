/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import BellModule.BellPOA;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Nonato Dias
 */
public class BellLOCAL extends BellPOA{
    private ImageView imgBell;
    private FadeTransition ft;
    
    @Override
    public void ring(){
        imgBell.setOpacity(1.0);
        if(ft == null){
            ft = new FadeTransition(Duration.millis(600), imgBell);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
    }
    
    @Override
    public void stop() {
        imgBell.setOpacity(0.05);
        
        if(ft != null){
            ft.setAutoReverse(false);
            ft.stop();
            ft = null;
        }
    }

    public void setImgBell(ImageView imgBell) {
        this.imgBell = imgBell;
    }
    
}
