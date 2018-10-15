/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.util;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Nonato Dias
 */
public class CorbaUtil {
    
    /**
     * 
     * @param _id
     * @param _kind
     * @return
     * @throws InvalidName
     * @throws NotFound
     * @throws CannotProceed
     * @throws org.omg.CosNaming.NamingContextPackage.InvalidName 
     */
    public static org.omg.CORBA.Object getObjRef(String _id, String _kind) 
        throws InvalidName, 
        NotFound, 
        CannotProceed, 
        org.omg.CosNaming.NamingContextPackage.InvalidName 
    {
        String args [] = new String[1];
        args[0] = "-ORBInitialHost Host";
        ORB orb = ORB.init(args,null);
        org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

        NamingContext naming = NamingContextHelper.narrow(obj);
        NameComponent[] name = {new NameComponent(_id, _kind)};
        return naming.resolve(name);
    }
}
