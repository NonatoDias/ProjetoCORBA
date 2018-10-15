/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.*;
import org.omg.CosNaming.*; 
import org.omg.CORBA.*;
import org.omg.PortableServer.*; 

/**
 *
 * @author Nonato Dias
 */
public class ClientMuseum {

    private Gate gate;
    
    public ClientMuseum() {
        System.out.println("New ClientMuseu");
    }
    
    public void init(){
        try {
            String args [] = new String[1];
            args[0] = "-ORBInitialHost Host";
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContext naming = NamingContextHelper.narrow(obj);
            NameComponent[] name = {new NameComponent("Gate","implementacao")};
            org.omg.CORBA.Object objRef =  naming.resolve(name);

            this.gate = GateHelper.narrow(objRef);		

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
