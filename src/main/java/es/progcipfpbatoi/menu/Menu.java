package es.progcipfpbatoi.menu;

import es.progcipfpbatoi.controller.UsuarioController;
import es.progcipfpbatoi.controller.ViajesController;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.views.GestorIO;
import java.util.Scanner;

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

    public Menu() {
        this.viajesController = new ViajesController();
        this.usuarioController = new UsuarioController();
        this.usuario = null;
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
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        boolean opcionValida = false;

        while (!opcionValida) {
            String input = teclado.nextLine();

            if (input.matches("\\d+")) {
                opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 9) {
                    opcionValida = true;
                } else {
                    GestorIO.print("Opción no válida. Introduce un número del 1 al 9.");
                }
            } else {
                GestorIO.print("Opción no válida. Introduce un número del 1 al 9.");
            }
        }

        return opcion;
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                usuario = usuarioController.login(usuario);

                viajesController.setUsuario(usuario);

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

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:
                GestorIO.print("Gràcies per utilitzar BatBatCar. Fins aviat!");
                break;
            default:
                GestorIO.print("Opció invàlida. Si us plau, selecciona una opció vàlida.");
        }
    }
}
