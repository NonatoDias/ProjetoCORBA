/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import GateModule.GatePOA;

/**
 *
 * @author Nonato Dias
 */
public class GateImpl extends GatePOA{

    private int count;
    private Runnable callback = null;

    public GateImpl() {
        this.count = 0;
    }
    
    public void getOnCountChange(Runnable callback){
        this.callback = callback;
    }
    
    @Override
    public int addVisitor() {
        this.count ++;
        if(callback != null){
            callback.run();
        }
        return this.count;
    }

    @Override
    public int decreaseVisitor() {
        this.count--;
        if(callback != null){
            callback.run();
        }
        return this.count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setTurn(String turn) {
        System.out.println("projetocorba.corba.GateImpl.setTurn() ---- "+turn);
    }
}
