package ar.edu.unahur.obj2.ciber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExcepcionesTest {

    @Test
    void dadaUnaRestriccionMasiva_cuandoSuperaElLimiteAbsoluto_entoncesLanzaExcepcionYNoAlteraElEstado() {
        // Given
        NodoRed nodo = new NodoRed("NODO-1", 10000);
        // Si restamos 65000 a 10000, quedaríamos en -55000 (Ilegal porque supera los -50000 permitidos)
        RestriccionTrafico restriccion = new RestriccionTrafico(nodo, 65000);

        // When & Then (Combinados usando JUnit assertThrows)
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            restriccion.ejecutar();
        });

        // Verificamos el mensaje de error para asegurar que fue por el motivo correcto
        assertEquals("Límite absoluto de sobrecarga excedido", excepcion.getMessage());
        
        // Verificación de Transaccionalidad: El nodo debe seguir intacto
        assertEquals(10000, nodo.getCapacidadActual(), "La capacidad del nodo no debió verse afectada tras la excepción");
    }

}
