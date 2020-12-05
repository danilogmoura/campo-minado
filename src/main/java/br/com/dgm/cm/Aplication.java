package br.com.dgm.cm;

import br.com.dgm.cm.model.Tabuleiro;
import br.com.dgm.cm.view.TabuleiroConsole;

public class Aplication {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        new TabuleiroConsole(tabuleiro);

    }
}
