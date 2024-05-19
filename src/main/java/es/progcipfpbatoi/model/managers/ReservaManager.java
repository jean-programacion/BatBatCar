/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.types.Reserva;
import es.progcipfpbatoi.model.entities.types.Viaje;
import java.util.List;

/**
 *
 * @author jeanm
 */
public class ReservaManager {

    private List<Reserva> reservas;
    private List<Viaje> viajes;

    public ReservaManager(List<Reserva> reservas, List<Viaje> viajes) {
        this.reservas = reservas;
        this.viajes = viajes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }
    
    public boolean addReserva(Reserva reserva) {
        return reservas.add(reserva);
    }

    public Iterable<Reserva> getAll() {
        return reservas;
    }
    
    

}
