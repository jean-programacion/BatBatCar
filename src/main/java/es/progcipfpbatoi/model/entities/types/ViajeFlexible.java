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
public class ViajeFlexible extends ViajeCancelable {
    public ViajeFlexible(Usuario propietari, String ruta, int duracionMinutos, int plazasOfrecidas, double precioPorPlaza) {
        super(propietari, ruta, duracionMinutos, plazasOfrecidas, precioPorPlaza);
    }

    // Implementación específica para permitir cambios en la reserva
    public boolean modificarReserva(int codigoReserva, int nuevasPlazasSolicitadas) {
        // Lógica para modificar la reserva y cambiar el número de plazas
        return false; // Retornar true si la modificación se realizó con éxito
    }

    // Implementación específica para permitir cambios en el precio del viaje
    public boolean cambiarPrecio(double nuevoPrecio) {
        // Lógica para cambiar el precio del viaje
        return false; // Retornar true si el cambio se realizó con éxito
    }
}
