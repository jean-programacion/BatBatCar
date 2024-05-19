/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.types.Reserva;
import es.progcipfpbatoi.views.GestorIO;

/**
 *
 * @author jeanm
 */
public class TicketReservaView {

    private Reserva reserva;

    public TicketReservaView(Reserva reserva) {
        this.reserva = reserva;
    }

    public void visualizar() {
        GestorIO.print("* * * * * * * * * * * * * * * * * * * * * * *");
        GestorIO.print("*                 Reserva                    *");
        GestorIO.print("*                                                   *");
        GestorIO.print("* Código de Reserva: " + reserva.getCodigoReserva());
        GestorIO.print("* Usuario: " + reserva.getUsuario().getNombreUsuario());
        GestorIO.print("* Plazas: " + reserva.getNumPlazasSolicitadas());
        GestorIO.print("*                                                    *");
        GestorIO.print("* * * * * * * * * * * * * * * * * * * * * * *");
    }
}
