package ar.edu.unahur.obj2.ciber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrquestadorAccionesTest {

    @Test
    void dadasVariasAccionesPendientes_cuandoElOrquestadorEjecuta_entoncesProcesaTodasYVaciaLaCola() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        OrquestadorAcciones orquestador = new OrquestadorAcciones();

        orquestador.registrarAccion(new AmpliacionTrafico(nodo, 2000));
        orquestador.registrarAccion(new RestriccionTrafico(nodo, 5000));

        // When
        orquestador.ejecutarPendientes();

        // Then
        assertEquals(7000, nodo.getCapacidadActual()); // 10k + 2k - 5k
    }

    @Test
    void dadoUnLoteDeAcciones_cuandoSeEjecutaYSeDeshace_entoncesRespetaElOrdenLIFO() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        LoteAcciones lote = new LoteAcciones();
        lote.agregarAccion(new RestriccionTrafico(nodo, 5000)); // Queda en 5000
        lote.agregarAccion(new AmpliacionTrafico(nodo, 2000));  // Queda en 7000

        // When (Ejecutamos)
        lote.ejecutar();
        assertEquals(7000, nodo.getCapacidadActual()); // Assert intermedio para seguridad
        
        // Cuando deshacemos
        lote.deshacer();

        // Then (Debe volver a 10000 sin errores)
        assertEquals(10000, nodo.getCapacidadActual());
    }


}
