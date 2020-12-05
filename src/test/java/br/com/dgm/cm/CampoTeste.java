package br.com.dgm.cm;

import br.com.dgm.cm.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CampoTeste {

    private Campo campo;

    @BeforeEach
    void init() {
        campo = new Campo(3, 3);
    }

    @Test
    void teste_vizinho_real_esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_direita() {
        Campo vizinho = new Campo(3, 4);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_emcima() {
        Campo vizinho = new Campo(2, 3);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_distancia_embaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }


    @Test
    void teste_vizinho_real_distancia_diagonal_superior_esquerda() {
        Campo vizinho = new Campo(2, 2);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_distancia_diagonal_superior_direita() {
        Campo vizinho = new Campo(2, 4);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_distancia_diagonal_inferior_esquerda() {
        Campo vizinho = new Campo(4, 2);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_vizinho_real_distancia_diagonal_inferior_direita() {
        Campo vizinho = new Campo(4, 4);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertTrue(adicionado);
    }

    @Test
    void teste_nao_vizinho_real_distancia_1() {
        Campo vizinho = new Campo(3, 1);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertFalse(adicionado);
    }

    @Test
    void teste_nao_vizinho_real_diagonal_distancia_2() {
        Campo vizinho = new Campo(1, 5);
        boolean adicionado = campo.adicionarVizinho(vizinho);
        assertFalse(adicionado);
    }
}
