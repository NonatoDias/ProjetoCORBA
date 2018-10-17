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

public class WatchmanREMOTE extends WatchmanPOA{
    String turn; //DAY, NIGHT
    private Runnable callback;

    public WatchmanREMOTE() {
        this.turn = "DAY";
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
    
    public void getOnTurnChange(Runnable callback){
        this.callback = callback;
    }
}
