package ar.edu.unahur.obj2.ciber;

import java.util.ArrayList;
import java.util.List;

/**
 * NodoRed
 */
public class NodoRed {

    private String id;
    private Integer capacidadActual;
    private List<IObservadorNodo> observadores = new ArrayList<>();

    public NodoRed(String id, Integer capacidadInicial) {
        this.id = id;
        this.capacidadActual = capacidadInicial;
    }

    public Integer getCapacidadActual() {
        return capacidadActual;
    }

    public void ampliarCapacidad(Integer caudal) {
        this.capacidadActual += caudal;
        notificarObservadores();
    }

    public void restringirCapacidad(Integer caudal) {
        this.capacidadActual -= caudal;
        notificarObservadores();
    }

    public void registrarObservador(IObservadorNodo observador) {
        this.observadores.add(observador);
    }

    // Agregar escenarios de prueba para cobertura
    public void eliminarObservador(IObservadorNodo observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (IObservadorNodo observador : this.observadores) {
            observador.reaccionarCambioCapacidad(this);
        }
    }

}
