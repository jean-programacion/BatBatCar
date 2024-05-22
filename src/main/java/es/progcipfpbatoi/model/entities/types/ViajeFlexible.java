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

    public boolean modificarReserva(int codigoReserva, int nuevasPlazasSolicitadas) {
        return false;
    }

    public boolean cambiarPrecio(double nuevoPrecio) {
        return false;
    }

    @Override
    public String getTipo() {
        return "Flexible";
    }

}
