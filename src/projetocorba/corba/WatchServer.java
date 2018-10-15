/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import javafx.scene.control.Label;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class WatchServer extends Server{
    private Runnable ready;
    WatchmanImpl watchman;

    public WatchServer() {
        watchman = new WatchmanImpl();
    }
    
    @Override
    public void run() {
        try {
            super.init();
            super.bindRef(watchman, "Watchman","implementacao");
            super.activate();
            log("Servidor Vigilancia pronto");
            ready.run();
            super.orbRun();
            
        } catch (Exception ex) {
            System.out.println("Erro");
            ex.printStackTrace();
        }
    }

    @Override
    public void getOnReady(Runnable r) {
        ready = r;
    }
    
    public void log(String msg){
        LogUtil.log("WatchServer", msg);
    }

    public void setDisplayCount(Label displayCount) {
        watchman.setDisplayCount(displayCount);
    }
    
}
