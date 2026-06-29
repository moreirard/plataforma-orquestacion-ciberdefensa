package ar.edu.unahur.obj2.ciber;

/**
 * ObservadorSpy
 * Creamos una interfaz genérica y la implementamos falsamente en el test.
 */
public class ObservadorSpy implements IObservadorNodo {

    public Integer llamadas = 0;

    @Override
    public void reaccionarCambioCapacidad(NodoRed nodo) {
        this.llamadas++;
    }

}
