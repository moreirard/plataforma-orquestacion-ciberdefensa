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
}
