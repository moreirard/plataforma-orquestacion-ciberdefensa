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

    public void ampliarCapacidad(Integer caudal) {
        this.capacidadActual += caudal;
    }

    public void restringirCapacidad(Integer caudal) {
        this.capacidadActual -= caudal;
    }

}
