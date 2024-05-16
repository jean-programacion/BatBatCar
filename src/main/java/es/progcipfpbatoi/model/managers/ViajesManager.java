package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
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
        // añade a la colección "viajes" todos los viajes que creas necesario tener de inicio en tu sistema
        // this.add(new Viaje(....));
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

}
