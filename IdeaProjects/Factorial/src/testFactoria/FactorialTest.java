package testFactoria;

import factorial.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void calcular() {

        int resultado;

        resultado = Factorial.calcular(5);

        int numero = 120;

        assertEquals(resultado, numero);

    }

    @Test
    void calcularError() {

        int resultado;

        resultado = Factorial.calcular(-5);

        int numero = -1;

        assertEquals(resultado, numero);


    }

}