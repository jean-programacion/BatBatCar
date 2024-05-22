/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;
import es.progcipfpbatoi.views.GestorIO;
import java.util.HashSet;

import es.progcipfpbatoi.model.entities.Usuario;

/**
 *
 * @author jeanm
 */
public class UsuarioController {

    private Usuario user;
    private HashSet<Usuario> users;

    public UsuarioController() {
        this.users = new HashSet<>();
        usuarios();
    }

    public Usuario login(Usuario usuario) {

        for (int intentos = 0; intentos < 3; intentos++) {
            String nombreUsuario = GestorIO.getString("Introduce tu nombre de usuario");
            String contrasena = GestorIO.getString("Introduce tu contraseña");

            Usuario u = new Usuario(nombreUsuario, contrasena);

            if (validacion(u)) {
                this.user = u;
                GestorIO.print("¡Bienvenido, " + u.getNombreUsuario() + "!");
                return u;
            } else {
                GestorIO.print("Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.");
            }
        }
        GestorIO.print("Se han superado los intentos máximos permitidos. Saliendo del programa...");

        return null;
    }

    private boolean validacion(Usuario u) {
        for (Usuario x : users) {
            if (x.equals(u)) {
                return true;
            }
        }
        return false;
    }

    private void usuarios() {
        users.add(new Usuario("roberto1979", "12345"));

    }

}