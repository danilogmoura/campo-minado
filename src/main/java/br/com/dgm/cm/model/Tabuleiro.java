package br.com.dgm.cm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

    private int linhas;

    private int colunas;

    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void abrir(int linha, int coluna) {
        campos.stream()
                .filter(campo -> campo.getLinha() == linha && campo.getColuna() == coluna)
                .findFirst()
                .ifPresent(campo -> campo.abrir());
    }

    public void alterarMarcacao(int linha, int coluna) {
        campos.stream()
                .filter(campo -> campo.getLinha() == linha && campo.getColuna() == coluna)
                .findFirst()
                .ifPresent(campo -> campo.alternarMarcacao());
    }

    private void gerarCampos() {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                campos.add(new Campo(linha, coluna));
            }
        }
    }

    private void associarVizinhos() {
        for (Campo campo1 : campos) {
            for (Campo campo2 : campos) {
                campo1.adicionarVizinho(campo2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = campo -> campo.isMinado();

        do {
            minasArmadas = campos.stream().filter(minado).count();
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
        } while (minasArmadas < minas);
    }

    public boolean objetivoAlcancado() {
        return campos.stream().allMatch(campo -> campo.objetivoAlcancado());
    }

    public void reinicar() {
        campos.stream().forEach(campo -> campo.reiniciar());
        sortearMinas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                sb.append("");
                sb.append(campos.get(index));
                sb.append("");
                index++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
