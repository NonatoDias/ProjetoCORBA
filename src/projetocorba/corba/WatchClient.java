/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.Gate;
import GateModule.GateHelper;
import projetocorba.util.CorbaUtil;

/**
 *
 * @author Nonato Dias
 */
public class WatchClient {
    private Gate gate;
    
    public WatchClient() {
        System.out.println("New WatchClient");
    }
    
    public void init(){
        try {
            this.gate = GateHelper.narrow(CorbaUtil.getObjRef("Gate","implementacao"));		

            System.out.println("Referencia para GATE ok");
        }catch (Exception e) {
            System.out.println("Outro Erro : " + e) ;
            e.printStackTrace(System.out); 
        }
    }
    
    
}
