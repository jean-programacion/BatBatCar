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
public class ViajeCancelable extends Viaje {

    public ViajeCancelable(Usuario propietario, String ruta, int duracionMinutos, int plazasOfrecidas, double precioPorPlaza) {
        super(propietario, ruta, duracionMinutos, plazasOfrecidas, precioPorPlaza);
    }

    public boolean cancelarReserva(int codigoReserva) {
        for (Reserva reserva : getReservasRealizadas()) {
            if (reserva.getCodigoReserva() == codigoReserva) {
                return cancelarReserva(reserva);
            }
        }
        return false;
    }

    @Override
    public String getTipo() {
        return "Cancelable";
    }
}
