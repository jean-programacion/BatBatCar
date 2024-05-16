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

    public Reserva(Usuario usuario, int numPlazasSolicitadas) {
        this.codigoReserva = contadorCodigo++;
        this.usuario = usuario;
        this.numPlazasSolicitadas = numPlazasSolicitadas;
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
}

