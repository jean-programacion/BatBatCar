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
public class ViajeExclusivo extends Viaje {

    private boolean primeraReservaRealizada;

    public ViajeExclusivo(Usuario propietario, String ruta, int duracionMinutos, int plazasOfrecidas, double precioPorPlaza) {
        super(propietario, ruta, duracionMinutos, plazasOfrecidas, precioPorPlaza);
        this.primeraReservaRealizada = false;
    }

    public boolean realizarReservaExclusiva(Usuario usuario, int numPlazasSolicitadas) {
        if (!primeraReservaRealizada && super.realizarReserva(usuario, numPlazasSolicitadas)) {
            primeraReservaRealizada = true;
            return true;
        }
        return false;
    }

    @Override
    public String getTipo() {
        return "Exclusivo";
    }
}
