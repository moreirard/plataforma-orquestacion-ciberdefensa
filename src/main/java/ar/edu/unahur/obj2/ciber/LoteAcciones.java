package ar.edu.unahur.obj2.ciber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LoteAcciones
 */
public class LoteAcciones implements IAccionConfiguracion{

    private List<IAccionConfiguracion> hijos = new ArrayList<>();

    public void agregarAccion(IAccionConfiguracion accion) {
        hijos.add(accion);
    }

    @Override
    public void ejecutar() {
        for (IAccionConfiguracion accion : hijos) {
            accion.ejecutar();
        }
    }

    @Override
    public void deshacer() {
        // Un composite se deshace en orden INVERSO (LIFO)
        List<IAccionConfiguracion> reverso = new ArrayList<>(hijos);
        Collections.reverse(reverso);
        for (IAccionConfiguracion accion : reverso) {
            accion.deshacer();
        }
    }


}
