/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

/**
 *
 * @author Nonato Dias
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.omg.CosNaming.*; 
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class Server{

    public static void run(){
        try{
            String args [] = new String[1];
            args[0] = "-ORBInitialHost Host";
            ORB orb = ORB.init(args,null); 	
            org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");

            POA rootPOA = POAHelper.narrow(objPoa);		
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContext naming = NamingContextHelper.narrow(obj);
            
            
            //implementações
            GateImpl gate = new GateImpl();
            org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(gate);

            //Nomes
            NameComponent[] name = {new NameComponent("Gate","Exemplo")};
            naming.rebind(name,objRef);

            rootPOA.the_POAManager().activate();


            System.out.println("Servidor Pronto ...");
            orb.run();

        }catch (Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }
    }
}

