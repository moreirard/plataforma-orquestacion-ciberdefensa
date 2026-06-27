package ar.edu.unahur.obj2.ciber;

/**
 * AmpliacionTrafico
 */
public class AmpliacionTrafico implements IAccionConfiguracion {

    private NodoRed receptor;
    private Integer caudal;

    public AmpliacionTrafico(NodoRed receptor, Integer caudal) {
        this.receptor = receptor;
        this.caudal = caudal;
    }

    @Override
    public void ejecutar() {
        receptor.ampliarCapacidad(caudal);
    }

    @Override
    public void deshacer() {
        receptor.restringirCapacidad(caudal); // La inversa
    }
}
