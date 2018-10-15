/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

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
    private GateImpl gate;
    private Watchman watchman;

    public MuseumControl() {
        gate = new GateImpl();
    }
    
    @Override
    public void run() {
        try {
            super.init();
            super.bindRef(gate, "Gate","implementacao");
            super.activate();
            log("Servidor Museu pronto");
            ready.run();
            gate.getOnCountChange(()->{
                try {
                    watchman = WatchmanHelper.narrow(
                        CorbaUtil.getObjRef("Watchman","implementacao")
                    );
                    watchman.updateCount(gate.getCount());
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
        return gate.addVisitor();
    }
    
    public int decreaseVisitor () {
        return gate.decreaseVisitor();
    }

    public int getCount() {
        return gate.getCount();
    }
    
    public void setImgMuseum(ImageView imgMuseum) {
        gate.setImgMuseum(imgMuseum);
    }
}
