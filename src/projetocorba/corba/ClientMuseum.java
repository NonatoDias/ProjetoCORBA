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
    
    public static void run(){
        try {
            String args [] = new String[1];
            args[0] = "-ORBInitialHost Host";
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContext naming = NamingContextHelper.narrow(obj);

            NameComponent[] name = {new NameComponent("Gate","Exemplo")};

            org.omg.CORBA.Object objRef =  naming.resolve(name);

            Gate gate = GateHelper.narrow(objRef);		

            
            int count = gate.addVisitor();
            System.out.println("qtde "+count);


        }catch (Exception e) {
            System.out.println("Outro Erro : " + e) ;
            e.printStackTrace(System.out); 
        }
    }
}
