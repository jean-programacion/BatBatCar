/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Reserva;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import es.progcipfpbatoi.model.managers.ReservaManager;

import es.progcipfpbatoi.views.GestorIO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeanm
 */
public class ReservaController {

    private Usuario usuario;
    private final ReservaManager reservaManager;

    public ReservaController(Usuario usuario, ReservaManager reservaManager) {
        this.usuario = usuario;
        this.reservaManager = reservaManager;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void modificarReserva() {
        if (usuario == null) {
            GestorIO.print("Debes estar logueado para modificar una reserva.");
            return;
        }

        int codigoReserva = GestorIO.getInt("Introduce el código de reserva a modificar: ");

        Reserva reserva = getReservaByCodigo(codigoReserva);
        if (reserva == null) {
            GestorIO.print("Código de reserva no encontrado.");
            return;
        }
        if (reserva.getViaje() instanceof ViajeFlexible) {
            int nuevasPlazas = GestorIO.getInt("Introduce el número de plazas a reservar: ");

            if (modificarReserva(reserva, nuevasPlazas)) {
                GestorIO.print("Reserva modificada con éxito. A continuación se mostrará el ticket de confirmación.");
                mostrarTicketConfirmacion(reserva);
            } else {
                GestorIO.print("No quedan suficientes plazas.");
            }
        } else {
            GestorIO.print("Solo se permite modificar los viajes Flexibles");
        }
    }

    public void cancelarReserva() {
        if (usuario == null) {
            GestorIO.print("Debes estar logueado para cancelar una reserva.");
            return;
        }

        List<Reserva> reservasUsuario = getReservasByUsuario(usuario);
        if (reservasUsuario.isEmpty()) {
            GestorIO.print("No tienes reservas para cancelar.");
            return;
        }

        mostrarReservas(reservasUsuario);
        int codigoReserva = GestorIO.getInt("Introduce el código de reserva a cancelar: ");

        Reserva reserva = getReservaByCodigo(codigoReserva);
        if (reserva == null) {
            GestorIO.print("Código de reserva no encontrado.");
            return;
        }

        reservaManager.removeReserva(reserva);
        GestorIO.print("Reserva cancelada con éxito.");

    }

   
    private List<Reserva> getReservasByUsuario(Usuario usuario) {
        List<Reserva> reservasUsuario = new ArrayList<>();
        for (Reserva reserva : reservaManager.getReservas()) {
            if (reserva.getUsuario().equals(usuario)) {
                reservasUsuario.add(reserva);
            }
        }
        return reservasUsuario;
    }

    private Reserva getReservaByCodigo(int codigoReserva) {
        for (Reserva reserva : reservaManager.getReservas()) {
            if (reserva.getCodigo() == codigoReserva) {
                return reserva;
            }
        }
        return null;
    }

    private boolean modificarReserva(Reserva reserva, int nuevasPlazas) {
        Viaje viaje = (Viaje) reserva.getViaje();
        int plazasDisponibles = viaje.getPlazasOfertadas() - viaje.getPlazasReservadas() + reserva.setNumPlazasSolicitadas();

        if (nuevasPlazas <= plazasDisponibles) {
            viaje.setPlazasReservadas(viaje.getPlazasReservadas() - reserva.setNumPlazasSolicitadas() + nuevasPlazas);
            reserva.setPlazas(nuevasPlazas);
            return true;
        } else {
            return false;
        }
    }

    private void mostrarReservas(List<Reserva> reservas) {
        GestorIO.print("Reservas de viajes:");
        for (Reserva reserva : reservas) {
            GestorIO.print("Cod. Reserva: " + reserva.getCodigo()
                    + " Cod. Viaje: " + reserva.getViaje().getCodigo()
                    + " Propietario Viaje: " + reserva.getViaje().getPropietario()
                    + " Plazas Reservadas: " + reserva.setNumPlazasSolicitadas());
        }
    }

    private void mostrarTicketConfirmacion(Reserva reserva) {
        GestorIO.print("Reserva con código " + reserva.getCodigo());
        GestorIO.print("Usuario: " + reserva.getUsuario().getNombreUsuario());
        GestorIO.print("Plazas: " + reserva.setNumPlazasSolicitadas());
        GestorIO.print("Reserva del viaje de tipo " + reserva.getViaje().getTipo()
                + " de " + reserva.getViaje().getPropietario()
                + " código " + reserva.getViaje().getCodigo()
                + " ruta " + reserva.getViaje().getRuta()
                + " modificada con éxito.");
    }

    public void anyadirReserva(Reserva reserva) {
        reservaManager.addReserva(reserva);
    }

}
