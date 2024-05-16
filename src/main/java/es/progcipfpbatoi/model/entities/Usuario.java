package es.progcipfpbatoi.model.entities;

/**
 *
 * Clase que representa a un usuario de la aplicación
 */
public class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Getters y setters para los atributos

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    @Override
    public boolean equals(Object usario){
        Usuario u = (Usuario) usario;
        return this.nombreUsuario.equals(u.nombreUsuario) && this.contrasena.equals(u.contrasena);
    }
    @Override
    public String toString(){
        return nombreUsuario;
    }
}
