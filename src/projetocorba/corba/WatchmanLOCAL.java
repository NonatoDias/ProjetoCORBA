/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import WatchmanModule.WatchmanPOA;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
class WatchmanLOCAL extends WatchmanPOA{
    String turn;
    private Runnable callback;
    private ImageView imgMuseum;

    public WatchmanLOCAL() {
        this.turn = "DAY";
    }

    @Override
    public void setTurn(String turn) {
        setDayPeriod(turn);
    }
    
    @Override
    public String getTurn() {
        return this.turn;
    }

    /**
     * 
     * @param p 
     * 0 - manha
     * 1 - noite
     */
    public void setDayPeriod (String p){
        switch(p){
            case "DAY":
                imgMuseum.setImage(new Image("img/museum-0.png"));
                break;
            case "NIGHT":
                imgMuseum.setImage(new Image("img/museum-1.png"));
                break;
            default:
                break;
        }
    }

    public void setImgMuseum(ImageView imgMuseum) {
        this.imgMuseum = imgMuseum;
    }
}
