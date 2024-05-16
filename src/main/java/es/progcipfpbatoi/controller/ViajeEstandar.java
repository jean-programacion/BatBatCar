/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;

/**
 *
 * @author jeanm
 */
public class ViajeEstandar extends Viaje {

    public ViajeEstandar(Usuario propietari, String ruta, int duracionMinutos, int plazasOfrecidas, double precioPorPlaza) {
        super(propietari, ruta, duracionMinutos, plazasOfrecidas, precioPorPlaza);
    }

    @Override
    public String getTipo() {
        return "Estandar";
    }
    
}
