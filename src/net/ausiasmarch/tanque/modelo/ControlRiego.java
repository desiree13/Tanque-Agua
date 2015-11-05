/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.tanque.modelo;

import net.ausiasmarch.common.Convert;

/**
 *
 * @author al038557
 */
public class ControlRiego {

    //Creamos los m�todos
    String mensaje;
    int sequia;
    int humedad;
    EstadoTanque estado;

    public ControlRiego(EstadoTanque estado) {

    }

    public ControlRiego() {

    }

    int permitidoLlenar() {

        if (sequia > 10 || sequia < 0) {
            mensaje = "El valor de la sequ�a no puede ser mayor que 10 o"
                    + " menor que 0";
            return 1;
        }
        if (estado == EstadoTanque.LLENO) {
            mensaje = " No se puede llenar el tanque si est� lleno";
            return 2;
        }
        if (sequia == 10) {
            mensaje = "No se puede llenar si la sequ�a es 10";
            return 3;
        }
        if (sequia >= 7 && estado == EstadoTanque.MEDIO) {
            mensaje = " No se puede llenar m�s de la mitad si la sequ�a es"
                    + " mayor o igual a 7";
            return 4;
        }

        return 0;
    }
    
    int permitidoVaciar(){
        if(humedad > 10 || humedad < 0){
            mensaje = "El valor de la humedad del suelo no puede ser mayor que 10 o\n" +
"menor que 0 ";
        }
        if(estado == EstadoTanque.VACIO){
            mensaje = "No se puede vaciar NADA para regar si el tanque ya est� vac�o. ";
        }
        
        
        return 0;
    }

}
