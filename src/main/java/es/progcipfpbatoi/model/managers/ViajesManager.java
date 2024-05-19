package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de viajes. Manejará la lista de los viajes tanto para almancenar nueva
 * información sobre ella como para recuperar la totalidad o parte de la
 * información como también información relacionada con dicha lista.
 *
 * @author batoi
 */
public class ViajesManager {

    private List<Viaje> viajes;

    public ViajesManager() {
        this.viajes = new ArrayList<>();
        init();
    }

    /**
     * Añade un nuevo viaje al repositorio
     *
     * @param viaje
     */
    public void add(Viaje viaje) {
        viajes.add(viaje);
    }

    /**
     * Cancela un viaje
     *
     * @param viaje
     */
    public void cancel(Viaje viaje) {
        viaje.cancelarViatge();
    }

    /**
     * Obtiene el número de viajes actualmente registrados
     *
     * @return
     */
    public int getNumViajes() {
        // Implementación para obtener el número de viajes
        return viajes.size();
    }

    /**
     * Obtiene todos los viajes
     *
     * @return
     */
    public List<Viaje> findAll() {
        return viajes;
    }

    private void init() {
        Usuario propietario1 = new Usuario("sergio123", "password1");
        Usuario propietario2 = new Usuario("raul00", "password2");
        Usuario propietario3 = new Usuario("alex32", "password3");

        this.add(new Viaje(propietario1, "Madrid-Murcia-Alicante", 120, 1, 5.00) {
          
        });
        this.add(new ViajeCancelable(propietario2, "Madrid-Barcelona", 180, 1, 10.00));
        this.add(new ViajeFlexible(propietario3, "Alcoy-Cocentaina", 30, 2, 2.00));
        this.add(new Viaje(propietario1, "Alcoy-Alicante", 45, 3, 3.00));
            
    }

    public Usuario autenticarUsuario(String nombreUsuario, String contrasena) {
        // Crear un nuevo usuario con el nombre de usuario y contraseña proporcionados

        Usuario usuario = new Usuario("Manolo", "1234");
        Usuario usuarioReg = new Usuario(nombreUsuario, contrasena);

        return (usuario);
    }

    public List<Viaje> buscarViajesDisponibles() {
        // Implementación para buscar viajes disponibles
        return viajes;
    }

    /*public Viaje getViajeByCodigo(int codigoViaje) {
        for (Viaje viaje : viajes) {
            if (viaje.getCodigo() == codigoViaje) {
                return viaje;
            }
        }
        return null;
    }*/

    
    
}
