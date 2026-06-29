package ar.edu.unahur.obj2.ciber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ObservadorTest {

        @Test
    void dadoUnObservadorRegistrado_cuandoNodoCambiaCapacidad_entoncesEsNotificado() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        ObservadorSpy espia = new ObservadorSpy();
        nodo.registrarObservador(espia);

        // When
        nodo.ampliarCapacidad(1000);

        // Then
        assertEquals(1, espia.llamadas); // ¡El nodo nos avisó!
    }

}
