package br.com.dgm.cm.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    private final int linha;

    private final int coluna;

    private boolean aberto;

    private boolean minado;

    private boolean marcado;

    private List<Campo> vizinhos = new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public boolean adicionarVizinho(Campo vizinho) {
        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunaDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColunha = Math.abs(coluna - vizinho.coluna);
        int deltaGeral = deltaLinha + deltaColunha;

        if (deltaGeral == 1 && !diagonal) {
            vizinho.adicionarVizinho(vizinho);
            return true;
        } else if (deltaGeral == 2 && diagonal) {
            vizinho.adicionarVizinho(vizinho);
            return true;
        }
        return false;
    }
}
