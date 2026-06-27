package ar.edu.unahur.obj2.ciber;

/**
 * NodoRed
 */
public class NodoRed {

    private String id;
    private Integer capacidadActual;

    public NodoRed(String id, Integer capacidadInicial) {
        this.id = id;
        this.capacidadActual = capacidadInicial;
    }

    public Integer getCapacidadActual() {
        return capacidadActual;
    }

    public void ampliarCapacidad(int caudal) {
        this.capacidadActual += caudal;
    }

    public void restringirCapacidad(int caudal) {
        this.capacidadActual -= caudal;
    }

}
