package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Reserva;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeExclusivo;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;
import es.progcipfpbatoi.views.ListadoViajesView;
import java.util.ArrayList;
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
                    nuevo = new Viaje(usuario, ruta, duracion, plazas, precio) {};
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

        } else {
            GestorIO.print("Tipo de viaje incorrecto");
        }

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
    /*public void cancelarViaje(int codigo){
        List<Viaje> viajes = getViajesCancelables();
        Viaje v = new Viaje(codigo);
        if(isValido(codigo) && viajes.remove(v)){
            gestor.cancel(v);
            GestorIO.print("El viaje se ha cancelado exitosamente");
        }else{
            GestorIO.print("El viaje no se ha podido cancelar, intentalo de nuevo");
        }
    }*/

    public void cancelarViaje() {
        List<Viaje> viajes = viajesManager.buscarViajesDisponibles();
        List<Viaje> viajesNoCancelados = new ArrayList<>();

        // Filtramos los viajes que no estén cancelados y que pertenezcan al usuario actual
        for (Viaje viaje : viajes) {
            if (viaje.getPropietario().equals(usuario) && !viaje.isCancelado()) {
                viajesNoCancelados.add(viaje);
            }
        }

        if (viajesNoCancelados.isEmpty()) {
            GestorIO.print("No tienes viajes disponibles para cancelar.");
            return;
        }

        new ListadoViajesView(viajesNoCancelados).visualizar();

        int codigoViaje = GestorIO.getInt("Introduce el código del viaje que deseas cancelar: ");

        Viaje viajeSeleccionado = null;
        for (Viaje viaje : viajesNoCancelados) {
            if (viaje.getCodigoViatge() == codigoViaje) {
                viajeSeleccionado = viaje;
                break;
            }
        }
        
        

        if (viajeSeleccionado == null) {
            GestorIO.print("El código de viaje introducido no es válido.");
            return;
        }

        if (viajeSeleccionado.isCancelado()) {
            GestorIO.print("El viaje ya ha sido cancelado.");
            return;
        }

        viajeSeleccionado.cancelarViatge();
        GestorIO.print("El viaje ha sido cancelado con éxito.");

    }
    
    public Reserva realizarReserva() {
        if (usuario == null) {
            GestorIO.print("Error: No hay usuario autenticado.");
            return null;
        }

        List<Viaje> viajesReservables = obtenerViajesReservables();
        if (viajesReservables.isEmpty()) {
            GestorIO.print("No hay viajes disponibles para reservar.");
              return null;
        }

        new ListadoViajesView(viajesReservables).visualizar();

        int codigoViaje = GestorIO.getInt("Introduce el código del viaje a seleccionar: ");
        Viaje viajeSeleccionado = buscarViajePorCodigo(viajesReservables, codigoViaje);

        if (viajeSeleccionado == null) {
            GestorIO.print("El código de viaje introducido no es válido.");
              return null;
        }

        int numPlazas = GestorIO.getInt("Introduce el número de plazas a reservar: ");

        if (viajeSeleccionado.realizarReserva(usuario, numPlazas)) {
            Reserva reserva = obtenerReserva(viajeSeleccionado, usuario, numPlazas);
            if (reserva != null) {
                new TicketReservaView(reserva).visualizar();
                   return reserva;
            } else {
                GestorIO.print("Error al realizar la reserva.");
            }
        } else {
            GestorIO.print("No se pudo realizar la reserva. Verifica las plazas disponibles.");
        }
        
           return null;
    }

    private List<Viaje> obtenerViajesReservables() {
        List<Viaje> viajesDisponibles = viajesManager.buscarViajesDisponibles();
        List<Viaje> viajesReservables = new ArrayList<>();

        for (Viaje viaje : viajesDisponibles) {
            if (!viaje.isCancelado() && !viaje.isCerrado() && !viaje.getPropietario().equals(usuario)) {
                viajesReservables.add(viaje);
            }
        }
        return viajesReservables;
    }

    private Viaje buscarViajePorCodigo(List<Viaje> viajes, int codigo) {
        for (Viaje viaje : viajes) {
            if (viaje.getCodigoViatge() == codigo) {
                return viaje;
            }
        }
        return null;
    }

    private Reserva obtenerReserva(Viaje viaje, Usuario usuario, int numPlazas) {
        for (Reserva reserva : viaje.getReservasRealizadas()) {
            if (reserva.getUsuario().equals(usuario) && reserva.getNumPlazasSolicitadas() == numPlazas) {
                return reserva;
            }
        }
        return null;
    }

    public void cancelarReserva() {
        // Implementación de cancelar reserva
    }

    public void buscarViajeYRealizarReserva() {
        // Implementación de buscar viaje y realizar reserva
    }

    public ViajesManager getViajesManager() {
        return viajesManager;
    }


}
