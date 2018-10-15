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
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import projetocorba.util.LogUtil;

public abstract class Server{
    private POA rootPOA;
    private NamingContext naming;
    private ORB orb;
    
    public void init() throws org.omg.CORBA.ORBPackage.InvalidName {
        String args [] = new String[1];
        args[0] = "-ORBInitialHost Host";
        this.orb = ORB.init(args,null); 	
        org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");

        this.rootPOA = POAHelper.narrow(objPoa);		
        org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

        this.naming = NamingContextHelper.narrow(obj);
    }

    
    public void bindRef(Servant p_servant, String _id, String _kind) 
        throws ServantNotActive, 
        NotFound, 
        WrongPolicy, 
        CannotProceed, 
        InvalidName
    {
        org.omg.CORBA.Object objRef = this.rootPOA.servant_to_reference(p_servant);

        //Nomes
        NameComponent[] name = {new NameComponent(_id, _kind)};
        naming.rebind(name,objRef);
    }

    /**
     * Método de execução definido 
     */
    public abstract void run();
    
    public void activate() throws AdapterInactive{
        rootPOA.the_POAManager().activate();
    }
    
    public void orbRun(){
        this.orb.run();
    }
    
    public abstract void getOnReady(Runnable r);
    
    private void log(String msg){
        LogUtil.log("SERVER", msg);
    }
}

