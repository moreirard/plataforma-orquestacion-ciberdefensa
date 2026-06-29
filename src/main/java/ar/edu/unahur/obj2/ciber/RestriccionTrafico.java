package ar.edu.unahur.obj2.ciber;

public class RestriccionTrafico implements IAccionConfiguracion {

    private NodoRed receptor;
    private Integer caudal;

    public RestriccionTrafico(NodoRed receptor, Integer caudal) {
        this.receptor = receptor;
        this.caudal = caudal;
    }

    @Override
    public void ejecutar() {
        this.receptor.restringirCapacidad(caudal);
    }

    @Override
    public void deshacer() {
        this.receptor.ampliarCapacidad(caudal);
    }

}
