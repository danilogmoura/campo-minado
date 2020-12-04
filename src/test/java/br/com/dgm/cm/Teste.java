package br.com.dgm.cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Teste {

    @Test
    void testSeIgualADoid() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    void testarSeIgualATres() {
        int a = 2 + 3;
        assertEquals(5, a);
    }
}
