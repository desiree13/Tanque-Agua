/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.tanque.modelo;


/**
 *
 * @author al038557
 */
public class ControlRiego {

    //Creamos los m�todos
    
    private String mensaje;
    private int sequia, humedad;
    private EstadoTanque estado;

    
    public int getSequia() {
        return sequia;
    }

    public void setSequia(int sequia) {
        this.sequia = sequia;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public EstadoTanque getEstado() {
        return estado;
    }

    public void setEstado(EstadoTanque estado) {
        this.estado = estado;
    }
    

    public ControlRiego(EstadoTanque estado) {
        this.estado = estado;

    }

    public ControlRiego() {

    }

   public int permitidoLlenar() {

       
        if (estado == EstadoTanque.LLENO) {
            mensaje = " No se puede llenar el tanque si est� lleno";
            return 1;
        }
        
        if (sequia > 10 || sequia < 0) {
            mensaje = "El valor de la sequ�a no puede ser mayor que 10 o"
                    + " menor que 0";
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

  public  int permitidoVaciar() {
        if (humedad > 10 || humedad < 0) {
            mensaje = "El valor de la humedad del suelo no puede ser mayor que 10 o\n"
                    + "menor que 0 ";
            return 1;
        }
        if (estado == EstadoTanque.VACIO) {
            mensaje = "No se puede vaciar NADA para regar si el tanque ya est� vac�o. ";
            return 2;
        }

        if (humedad >= 7) {
            mensaje = "No se puede vaciar nada para regar si la humedad del suelo es\n"
                    + "mayor o igual a 7";
            return 3;
        }

        if (humedad >= 3 && humedad < 7 && estado == EstadoTanque.MEDIO) {
            mensaje = "No se puede vaciar m�s all� de la mitad para regar si la\n"
                    + "humedad del suelo es mayor o igual a 3 y menor que 7";
            return 4;
        }

        return 0;
    }

    public String getMensaje() {
        return mensaje;

    }
    
}