package es.progcipfpbatoi.model.entities.types;

import es.progcipfpbatoi.model.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/*
 * Clase que representa a un viaje estándar
*/
public  class Viaje {
    private static int contadorCodigo = 1;
    private int codigoViatge;
    private Usuario propietario;
    private String ruta;
    private int duracionMinutos;
    private int plazasOfrecidas;
    private int plazasReservadas;
    private double precioPorPlaza;
    boolean cerrado;
    private boolean cancelado;
    private List<Reserva> reservasRealizadas;

    public Viaje(Usuario propietario, String ruta, int duracionMinutos, int plazasOfrecidas, double precioPorPlaza) {
        this.codigoViatge = contadorCodigo++;
        this.propietario = propietario;
        this.ruta = ruta;
        this.duracionMinutos = duracionMinutos;
        this.plazasOfrecidas = plazasOfrecidas;
        this.precioPorPlaza = precioPorPlaza;
        this.plazasReservadas = 0;
        this.cerrado = false;
        this.cancelado = false;
        this.reservasRealizadas = new ArrayList<>();
    }

    // Getters y Setters

    public List<Reserva> getReservasRealizadas() {
        return reservasRealizadas;
    }

    // Métodos para gestionar reservas

    public boolean realizarReserva(Usuario usuario, int numPlazasSolicitadas) {
        if (!cerrado && !cancelado && plazasReservadas + numPlazasSolicitadas <= plazasOfrecidas) {
            Reserva reserva = new Reserva(usuario, numPlazasSolicitadas, this);
            reservasRealizadas.add(reserva);
            plazasReservadas += numPlazasSolicitadas;
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(Reserva reserva) {
        if (reservasRealizadas.contains(reserva)) {
            reservasRealizadas.remove(reserva);
            plazasReservadas -= reserva.getNumPlazasSolicitadas();
            return true;
        }
        return false;
    }
    

    // Otros métodos
    protected void cerrarViatge() {
        cerrado = true;
    }

    public void cancelarViatge() {
        this.cancelado = true;
    }

    public int getCodigoViatge() {
        return codigoViatge;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public String getRuta() {
        return ruta;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public int getPlazasOfrecidas() {
        return plazasOfrecidas;
    }

    public int getPlazasReservadas() {
        return plazasReservadas;
    }

    public double getPrecioPorPlaza() {
        return precioPorPlaza;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public boolean isCancelado() {
        return cancelado;
    }
    
     //public abstract String getTipo();
    
    public String getTipo(){
        
        return "Estandar";
        
    }

    public int getPlazasOfertadas() {
        return plazasOfrecidas;
    }

    public void setPlazasReservadas(int nuevasPlazasReservadas) {
        this.plazasReservadas = nuevasPlazasReservadas;
    }

    public boolean isFlexible() {
        return false;
    }

    public String getCodigo() {
        return String.valueOf(codigoViatge);
    }

     
}