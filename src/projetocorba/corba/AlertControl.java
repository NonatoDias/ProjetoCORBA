/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import BellModule.*;
import javafx.scene.image.ImageView;
import projetocorba.util.CorbaUtil;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class AlertControl extends Server{
    private Runnable ready;
    private Bell bell;
    private BellLOCAL bellLOCAL;

    public AlertControl() {
        bellLOCAL = new BellLOCAL();
    }
    
    @Override
    public void run(String [] args) {
        try {
            super.init(args);
            super.bindRef(bellLOCAL, "BellLOCAL","implementacao");
            super.activate();
            log("Servidor alertas pronto");
            ready.run();
            super.orbRun();
            
        } catch (Exception ex) {
            System.out.println("Erro");
            ex.printStackTrace();
        }
    }
    
    public void log(String msg){
        LogUtil.log("AlertServer", msg);
    }

    @Override
    public void getOnReady(Runnable r) {
        ready = r;
    }
    
    public void setImgBell(ImageView imgBell) {
        bellLOCAL.setImgBell(imgBell);
    }
}
