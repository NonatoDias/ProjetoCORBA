/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import WatchmanModule.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import projetocorba.util.CorbaUtil;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class MuseumServer extends Server{
    private Runnable ready;
    
    @Override
    public void run() {
        try {
            super.init();
           
            GateImpl gate = new GateImpl();
           
            gate.getOnCountChange(()->{
                try {
                    //watchman.updateCount(gate.getCount());
                    Watchman watchman = WatchmanHelper.narrow(CorbaUtil.getObjRef("Watchman","implementacao"));
                    watchman.updateCount(gate.getCount());
                } catch (Exception ex) {
                    System.out.println("Erro");
                    ex.printStackTrace();
                }
            });
   
            super.bindRef(gate, "Gate","implementacao");
            super.activate();
            log("Servidor Museu pronto");
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
        LogUtil.log("MuseumServer", msg);
    }
}
