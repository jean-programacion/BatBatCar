/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.entities.types;

import es.progcipfpbatoi.model.entities.Usuario;

/**
 *
 * @author jeanm
 */
public class Reserva {

    private static int contadorCodigo = 1;
    private int codigoReserva;
    private Usuario usuario;
    private int numPlazasSolicitadas;
    private Viaje viaje;

    public Reserva(Usuario usuario, int numPlazasSolicitadas, Viaje viaje ) {
        this.codigoReserva = contadorCodigo++;
        this.usuario = usuario;
        this.numPlazasSolicitadas = numPlazasSolicitadas;
        this.viaje = viaje;
    }

    // Getters
    public int getCodigoReserva() {
        return codigoReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getNumPlazasSolicitadas() {
        return numPlazasSolicitadas;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public int getCodigo() {
        return codigoReserva;
    }

    
    public int setNumPlazasSolicitadas() {
       return this.numPlazasSolicitadas = numPlazasSolicitadas;
    }
    
     @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva=" + codigoReserva +
                ", usuario=" + usuario +
                ", numPlazasSolicitadas=" + numPlazasSolicitadas +
                ", viaje=" + viaje +
                '}';
    }

    public void setPlazas(int nuevasPlazas) {
        this.numPlazasSolicitadas = nuevasPlazas;
    }

}
