package ar.edu.unahur.obj2.ciber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccionesTest {
        @Test
    void dadaUnaAmpliacion_cuandoSeEjecuta_entoncesAumentaLaCapacidadDelNodo() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        AmpliacionTrafico ampliacion = new AmpliacionTrafico(nodo, 3000);

        // When
        ampliacion.ejecutar();

        // Then
        assertEquals(13000, nodo.getCapacidadActual());
    }

    @Test
    void dadaUnaAmpliacionEjecutada_cuandoSeDeshace_entoncesVuelveAlEstadoOriginal() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        AmpliacionTrafico ampliacion = new AmpliacionTrafico(nodo, 3000);
        ampliacion.ejecutar(); // Pasa a 13000

        // When
        ampliacion.deshacer();

        // Then
        assertEquals(10000, nodo.getCapacidadActual());
    }
}