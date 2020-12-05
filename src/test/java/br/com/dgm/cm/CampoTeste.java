package br.com.dgm.cm;

import br.com.dgm.cm.exception.ExplosaoException;
import br.com.dgm.cm.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void teste_valor_padra_atriburo_marcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void teste_alternar_marcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void teste_alternar_marcacao_duas_chamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void teste_abrir_nao_minado_nao_marcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void teste_abrir_nao_minado_marcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void teste_abrir_minado_marcado() {
        campo.minar();
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void teste_abrir_minado_nao_marcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> campo.abrir());
    }

    @Test
    void teste_valor_padra_atriburo_aberto() {
        assertFalse(campo.isAberto());
    }

    @Test
    void teste_abrir_com_vizinhos_1() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void teste_abrir_com_vizinhos_2() {
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 1);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}
