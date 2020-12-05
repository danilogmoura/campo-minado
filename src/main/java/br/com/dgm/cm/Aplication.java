package br.com.dgm.cm;

import br.com.dgm.cm.model.Tabuleiro;

public class Aplication {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        tabuleiro.abrir(3,3);
        tabuleiro.alterarMarcacao(4,4);
        tabuleiro.alterarMarcacao(4,5);

        System.out.println(tabuleiro);
    }
}
