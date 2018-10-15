/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.GatePOA;
import javafx.application.Platform;
import javafx.scene.control.Label;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class GateLOCAL extends GatePOA{

    private int count;
    private Runnable callback = null;
    Label displayCount;
    

    public GateLOCAL() {
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
    
    public void updateCount(int count) {
        LogUtil.log("WatchmanImpl", " count " + count);
        Platform.runLater(()->{
            displayCount.setText(""+ count);
        });
    }
    
    void setDisplayCount(Label displayCount) {
        this.displayCount = displayCount;
    }
    
}
