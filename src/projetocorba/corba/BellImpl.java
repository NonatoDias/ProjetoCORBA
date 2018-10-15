/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import BellModule.BellPOA;

/**
 *
 * @author Nonato Dias
 */
public class BellImpl extends BellPOA{

    @Override
    public void ring() {
        System.out.println("tocando o sino ...");
    }
    
}
