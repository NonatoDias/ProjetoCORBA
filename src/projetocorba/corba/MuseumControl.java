/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.*;
import WatchmanModule.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import projetocorba.util.CorbaUtil;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class MuseumControl extends Server{
    private Runnable ready;
    private Gate gate;
    private GateREMOTE gateREMOTE;
    private WatchmanLOCAL watchmanLOCAL;

    public MuseumControl() {
        gateREMOTE = new GateREMOTE();
        watchmanLOCAL = new WatchmanLOCAL();
    }
    
    @Override
    public void run() {
        try {
            super.init();
            super.bindRef(gateREMOTE, "GateREMOTE","implementacao");
            super.bindRef(watchmanLOCAL, "WatchmanLOCAL","implementacao");
            super.activate();
            log("Servidor Museu pronto");
            ready.run();
            gateREMOTE.getOnCountChange(()->{
                try {
                    gate = GateHelper.narrow(
                        CorbaUtil.getObjRef("GateLOCAL","implementacao")
                    );
                    gate.updateCount(gateREMOTE.getCount());
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
        LogUtil.log("MuseumServer", msg);
    }
    
    public int increaseVisitor () {
        return gateREMOTE.addVisitor();
    }
    
    public int decreaseVisitor () {
        return gateREMOTE.decreaseVisitor();
    }

    public int getCount() {
        return gateREMOTE.getCount();
    }
    
    public void setImgMuseum(ImageView imgMuseum) {
        watchmanLOCAL.setImgMuseum(imgMuseum);
    }
}
