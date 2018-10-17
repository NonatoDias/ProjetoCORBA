/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import BellModule.BellPOA;

/**
 *
 * @author Nonato Dias
 */
public class BellREMOTE extends BellPOA{
    private Runnable callback;
    private Runnable callbackOnStop;

    @Override
    public void ring() {
        System.out.println("tocando o sino ...");
        if(callback != null){
            callback.run();
        }
    }
    
    @Override
    public void stop() {
        System.out.println("parando o sino ...");
        if(callback != null){
            callbackOnStop.run();
        }
    }
    
    public void getOnRing(Runnable callback){
        this.callback = callback;
    }
    
    public void getOnStop(Runnable callback){
        this.callbackOnStop = callback;
    }
}
