/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import WatchmanModule.WatchmanPOA;
import javafx.application.Platform;
import javafx.scene.control.Label;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class WatchmanImpl extends WatchmanPOA{
    String turn;
    Label displayCount;
    private Runnable callback;

    public WatchmanImpl() {
        this.turn = "NIGHT";
    }

    @Override
    public void setTurn(String turn) {
        this.turn = turn;
        callback.run();
    }
    
    @Override
    public String getTurn() {
        return this.turn;
    }

    @Override
    public void updateCount(int count) {
        LogUtil.log("WatchmanImpl", this.turn+ " count " + count);
        Platform.runLater(()->{
            displayCount.setText(""+ count);
        });
    }

    void setDisplayCount(Label displayCount) {
        this.displayCount = displayCount;
    }
    
    public void getOnTurnChange(Runnable callback){
        this.callback = callback;
    }
    
}
