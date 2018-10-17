/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.*;
import WatchmanModule.*;
import BellModule.*;
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
    private Watchman watchman;
    private Bell bell;
    private Gate gate;
    private WatchmanREMOTE watchmanREMOTE;
    private GateLOCAL gateLOCAL;

    public WatchControl() {
        watchmanREMOTE = new WatchmanREMOTE();
        gateLOCAL = new GateLOCAL();
    }
    
    @Override
    public void run() {
        try {
            super.init();
            super.bindRef(watchmanREMOTE, "WatchmanREMOTE","implementacao");
            super.bindRef(gateLOCAL, "GateLOCAL","implementacao");
            super.activate();
            log("Servidor Vigilancia pronto");
            ready.run();
            watchmanREMOTE.getOnTurnChange(()->{
                try {
                    watchman = WatchmanHelper.narrow(
                        CorbaUtil.getObjRef("WatchmanLOCAL","implementacao")
                    );
                    String turn = watchmanREMOTE.getTurn();
                    watchman.setTurn(turn);
                    
                    bell = BellHelper.narrow(
                        CorbaUtil.getObjRef("BellLOCAL","implementacao")
                    );
                    
                    gate = GateHelper.narrow(
                        CorbaUtil.getObjRef("GateREMOTE","implementacao")
                    );
                    
                    int count = gate.getCount();
                    if(turn.equals("DAY")){
                        bell.stop();
                    }else if(count > 0){
                        bell.ring();
                    }
                    
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
        gateLOCAL.setDisplayCount(displayCount);
    }
    
    public void setTurn(String turn) {
        watchmanREMOTE.setTurn(turn);
    }
    
}
