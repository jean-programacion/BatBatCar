package es.progcipfpbatoi.views;

/**
 * Vista dedicada a los listados de viajes. De cada viaje se muestra su código,
 * ruta, precio, propietario, tipo de viaje, plazas disponibles y si está
 * cancelado.
 */
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.progcipfpbatoi.model.entities.types.Viaje;
import java.util.List;

public class ListadoViajesView {

    private final List<Viaje> viajes;

    private static final int ANCHO_TABLA = 100;

    public ListadoViajesView(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    private AsciiTable buildASCIITable() {

        AsciiTable view = new AsciiTable();
        view.addRule();
        view.addRow("*", "*", "*", "*", "*", "*", "*", "*");
        view.addRule();
        view.addRow(null, null, null, null, null, null, null, "Listado Viajes");
        view.addRule();
        view.addRow("Cod. Viaje", null, "Ruta", "Precio", "Propietario", "Tipo", "Plazas Disponibles", "Cancelado");
        view.addRule();
        generarFilasViajes(view);
        view.setTextAlignment(TextAlignment.CENTER);
        return view;
    }

    @Override
    public String toString() {
        return buildASCIITable().render(ANCHO_TABLA);
    }

    public void visualizar() {
        System.out.println(buildASCIITable().render(ANCHO_TABLA));
    }

    private void generarFilasViajes(AsciiTable tabla) {

        for (Viaje next : viajes) {
            tabla.addRow(next.getCodigoViatge(), null, next.getRuta(), next.getPrecioPorPlaza(), next.getPropietario(), next.getTipo(), next.getPlazasOfrecidas(), (next.isCancelado()) ? "Si" : "No");
        }

        // Implementa este método usando un bucle que itere sobre la lista de viajes y mostrando uno por fila.
        tabla.addRule();
    }
}
