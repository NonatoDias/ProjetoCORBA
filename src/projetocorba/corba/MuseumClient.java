/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.*;
import org.omg.CosNaming.*; 
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.*; 
import projetocorba.util.CorbaUtil;

/**
 *
 * @author Nonato Dias
 */
public class MuseumClient {

    private Gate gate;
    
    public MuseumClient() {
        System.out.println("New ClientMuseu");
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
    
    public int increaseVisitor () {
        return this.gate.addVisitor();
    }
    
    public int decreaseVisitor () {
        return this.gate.decreaseVisitor();
    }

    public int getCount() {
        return gate.getCount();
    }
}
