/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.Gate;
import GateModule.GateHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import projetocorba.util.CorbaUtil;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class WatchControl extends Server{
    private Runnable ready;
    private Gate gate;
    private WatchmanImpl watchman;

    public WatchControl() {
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
            watchman.getOnTurnChange(()->{
                try {
                    gate = GateHelper.narrow(
                        CorbaUtil.getObjRef("Gate","implementacao")
                    );
                    gate.setTurn(watchman.getTurn());
                    
                } catch (Exception ex) {
                    System.out.println("Erro");
                    ex.printStackTrace();
                }
            });
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
    
    public void setTurn(String turn) {
        watchman.setTurn(turn);
    }
    
}
