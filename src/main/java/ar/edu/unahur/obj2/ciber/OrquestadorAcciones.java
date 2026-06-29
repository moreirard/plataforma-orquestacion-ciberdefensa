package ar.edu.unahur.obj2.ciber;

import java.util.ArrayList;
import java.util.List;

/**
 * OrquestadorAcciones
 */
public class OrquestadorAcciones {

    private List<IAccionConfiguracion> accionesPendientes = new ArrayList<>();

    // Sigue refactorizar para no sobrecargar el método y usar IAccionConfiguracion
    public void registrarAccion(AmpliacionTrafico ampliacionTrafico) {
        this.accionesPendientes.add(ampliacionTrafico);
    }

    public void registrarAccion(RestriccionTrafico restriccionTrafico) {
        this.accionesPendientes.add(restriccionTrafico);
    }

    public void ejecutarPendientes() {
        for (IAccionConfiguracion accion : this.accionesPendientes) {
            accion.ejecutar();
        }
        // Resalizar escenario donde ejecutar pendietes falla por no hacer el clear
        this.accionesPendientes.clear();
    }

}
