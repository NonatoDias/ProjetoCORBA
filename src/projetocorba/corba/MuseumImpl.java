/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import SystemControl.MuseumPOA;

/**
 *
 * @author Nonato Dias
 */
public class MuseumImpl extends MuseumPOA{

    private int count;

    public MuseumImpl() {
        this.count = 0;
    }
    
    @Override
    public int addVisitor() {
        this.count ++;
        return this.count;
    }

    @Override
    public int decreaseVisitor() {
        this.count--;
        return this.count;
    }
}
