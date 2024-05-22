package es.progcipfpbatoi.menu;

import es.progcipfpbatoi.controller.ReservaController;
import es.progcipfpbatoi.controller.UsuarioController;
import es.progcipfpbatoi.controller.ViajesController;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Reserva;
import es.progcipfpbatoi.model.managers.ReservaManager;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;
import java.util.ArrayList;

/**
 * Clase que gestiona el menú de opciones. A partir de esta clase se ejecutan
 * las diferentes opciones del menú (casos de uso).
 *
 * @author batoi
 */
public class Menu {

    private static final int OPCION_SALIR = 9;

    private ViajesController viajesController;
    private UsuarioController usuarioController;
    private Usuario usuario;
    private final ReservaController reservaController;

    public Menu() {
        ViajesManager viajesManager = new ViajesManager();
        ReservaManager reservaManager = new ReservaManager(new ArrayList<>(), new ArrayList<>());

        this.viajesController = new ViajesController(viajesManager, reservaManager);
        this.usuarioController = new UsuarioController();
        this.usuario = null;
        this.reservaController = new ReservaController(usuario, reservaManager);
    }

    public void iniciar() {
        GestorIO.print("BatBatCar");
        GestorIO.print("=========");
        int opcionSeleccionada;

        do {
            mostrarOpciones();
            opcionSeleccionada = solicitarOpcion();
            ejecutarOpcion(opcionSeleccionada);
        } while (opcionSeleccionada != OPCION_SALIR);
    }

    private void mostrarOpciones() {
        GestorIO.print("1. Establecer usuario (login)");
        GestorIO.print("2. Listar todos los viajes");
        GestorIO.print("3. Añadir viaje");
        GestorIO.print("4. Cancelar viaje ");
        GestorIO.print("5. Realizar reserva");
        GestorIO.print("6. Modificar reserva");
        GestorIO.print("7. Cancelar reserva");
        GestorIO.print("8. Buscar viaje y realizar reserva");
        GestorIO.print("9. Salir");
        GestorIO.print("Seleccione una opción [1-9]: ");
    }

    private int solicitarOpcion() {
        return GestorIO.getInt("Introduce una opcion", 1, 9);
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                usuario = usuarioController.login(usuario);
                if (usuario != null) {
                    viajesController.setUsuario(usuario);
                    reservaController.setUsuario(usuario);
                }
                break;
            case 2:
                viajesController.listarViajes();
                break;
            case 3:

                if (usuario != null) {
                    viajesController.anyadirViaje();
                } else {
                    GestorIO.print("Tienes que que logearte antes de acceder!!!!");
                }

                break;
            case 4:
                if (usuario != null) {
                    viajesController.cancelarViaje();
                } else {
                    GestorIO.print("Tienes que que logearte antes de acceder!!!!");
                }
                break;
            case 5:
                if (usuario != null) {
                    Reserva reserva = viajesController.realizarReserva();
                    if (reserva != null) {
                        reservaController.anyadirReserva(reserva);
                    }
                } else {
                    GestorIO.print("Tienes que que logearte antes de acceder!!!!");
                }
                break;
            case 6:
                if (usuario != null) {
                    reservaController.modificarReserva();
                } else {
                    GestorIO.print("Tienes que que logearte antes de acceder!!!!");
                }
                break;
            case 7:
                reservaController.cancelarReserva();
                break;
            case 8:
                if (usuario != null) {
                    viajesController.buscarViajeYRealizarReserva();
                } else {
                    GestorIO.print("Tienes que logearte antes de acceder!!!!");
                }
                break;
            case 9:
                GestorIO.print("Gràcies per utilitzar BatBatCar. Fins aviat!");
                break;
            default:
                GestorIO.print("Opció invàlida. Si us plau, selecciona una opció vàlida.");
        }
    }
}
