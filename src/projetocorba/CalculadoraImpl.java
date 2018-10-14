/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba;

import Matematica.*;

/**
 *
 * @author Nonato Dias
 */
public class CalculadoraImpl extends CalculadoraPOA{
    @Override
    public float soma(float arg1, float arg2){
        System.out.println("Soma = "+arg1+" + "+arg2);
        return arg1 + arg2;
    }
    
    @Override
    public float divisao(float arg1, float arg2) throws DivisaoPorZero{
        System.out.println("Divisao="+arg1+"/"+arg2);
        if (arg2 == 0)  throw new DivisaoPorZero(arg1,arg2);
        return arg1 / arg2;   
    }
}