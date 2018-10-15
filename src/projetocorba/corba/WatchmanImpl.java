/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.corba;

import WatchmanModule.WatchmanPOA;
import projetocorba.util.LogUtil;

/**
 *
 * @author Nonato Dias
 */
public class WatchmanImpl extends WatchmanPOA{
    String turn;

    @Override
    public void setTurn(String turn) {
        this.turn = turn;
    }

    @Override
    public void updateCount(int count) {
        LogUtil.log("count", "" + count);
    }
    
}
