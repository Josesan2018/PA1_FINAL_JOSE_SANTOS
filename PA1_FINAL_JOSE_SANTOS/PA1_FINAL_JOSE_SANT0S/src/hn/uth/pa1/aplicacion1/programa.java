/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.aplicacion1;
/**
 ** @author uth
 */
public class programa {
    public static void main(String [] args){
        System.out.println("Hola mundo");
        gestorDB.guardarHumano(1, "1217199200324", "Jose", "Garcia", 125, 1992, 50);
        gestorDB.actualizarHumano(0, "", "", "", 0, 0, 0);
        gestorDB.eliminarHumano(1);
        gestorDB.getHumanos();
        System.out.println("Consultando 1");
        gestorDB.getHumanos(1);
    }
}
