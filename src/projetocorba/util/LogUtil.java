/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocorba.util;

/**
 *
 * @author Nonato Dias
 */
public class LogUtil {
    
    public static void log(String who, String msg){
        System.out.println(who.toUpperCase() + " -- " + msg);
    }
}
