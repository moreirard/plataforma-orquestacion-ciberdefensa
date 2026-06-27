package ar.edu.unahur.obj2.ciber;

/**
 * AmpliacionTrafico
 */
public class AmpliacionTrafico {

    private NodoRed nodo;
    private Integer caudal;

    public AmpliacionTrafico(NodoRed nodo, Integer caudal) {
        this.nodo = nodo;
        this.caudal = caudal;
    }

    public void ejecutar() {
        this.nodo.ampliarCapacidad(caudal);
    }

    public void deshacer() {
        this.nodo.restringirCapacidad(caudal);
    }

}
