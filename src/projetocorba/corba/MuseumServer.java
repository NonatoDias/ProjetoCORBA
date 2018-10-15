/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
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
           
            WatchmanImpl watchman = new WatchmanImpl();
            GateImpl gate = new GateImpl();
           
            gate.getOnCountChange(()->{
               watchman.updateCount(gate.getCount());
            });
   
            super.bindRef(watchman, "Watchman","implementacao");
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
