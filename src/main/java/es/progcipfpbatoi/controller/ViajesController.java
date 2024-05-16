package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeExclusivo;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;
import es.progcipfpbatoi.views.ListadoViajesView;
import java.util.List;

public class ViajesController {

    private Usuario usuario;
    private ViajesManager viajesManager;

    public ViajesController() {
        this.viajesManager = new ViajesManager();
        this.usuario = null;
    }

    public void listarViajes() {
        List<Viaje> viajes = viajesManager.buscarViajesDisponibles();
        new ListadoViajesView(viajes).visualizar();
    }

    public void anyadirViaje() {

        int tipoViaje = GestorIO.getInt("Seleccione el tipo de viaje (1: Estándar, 2: Cancelable, 3: Exclusivo, 4: Flexible): ", 1, 4);
        String ruta = GestorIO.getString("Introduzca la ruta a realizar (Ej: Alcoy-Alicante): ");
        int duracion = GestorIO.getInt("Introduzca la duración del viaje en minutos: ");
        double precio = GestorIO.getFloat("Introduzca el precio de cada plaza: ");
        int plazas = GestorIO.getInt("Introduzca el número de plazas disponibles: ");

        if (tipoViaje >= 1 && tipoViaje <= 4) {
            Viaje nuevo = null;
            switch (tipoViaje) {
                case 1 -> {
                    nuevo = new Viaje(usuario, ruta, duracion, plazas, precio);
                }
                case 2 -> {
                    nuevo = new ViajeCancelable(usuario, ruta, duracion, plazas, precio);
                }
                case 3 -> {
                    nuevo = new ViajeExclusivo(usuario, ruta, duracion, plazas, precio);
                }
                case 4 -> {
                    nuevo = new ViajeFlexible(usuario, ruta, duracion, plazas, precio);
                }
            }
            viajesManager.add(nuevo);
            
        }else{
            GestorIO.print("Tipo de viaje incorrecto");
        }

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
