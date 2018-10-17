/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.GatePOA;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nonato Dias
 */
public class GateREMOTE extends GatePOA{

    private int count;
    private Runnable callback = null;

    public GateREMOTE() {
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
    public void updateCount(int count) {
        this.count = count;
        if(callback != null){
            callback.run();
        }
    }
    
}
