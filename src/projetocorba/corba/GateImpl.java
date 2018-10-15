/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.GatePOA;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nonato Dias
 */
public class GateImpl extends GatePOA{

    private int count;
    private Runnable callback = null;
    private ImageView imgMuseum;

    public GateImpl() {
        this.count = 0;
    }
    
    public void getOnCountChange(Runnable callback){
        this.callback = callback;
    }
    
    @Override
    public int addVisitor() {
        this.count ++;
        if(callback != null){
            callback.run();
        }
        return this.count;
    }

    @Override
    public int decreaseVisitor() {
        this.count--;
        if(callback != null){
            callback.run();
        }
        return this.count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setTurn(String turn) {
        setDayPeriod(turn);
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
