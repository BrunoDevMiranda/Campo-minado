package br.com.campominado.model;

import br.com.campominado.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private boolean minado;
    private final int linha;
    private final int coluna;
    private boolean aberto = false;
    private boolean isMinado = false;
    private boolean marcado = false;
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
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
        int deltaGeral = deltaLinha + deltaColuna;
         if (deltaGeral ==1 && !diagonal){
             vizinhos.add(vizinho);
             return true;
         }else if (deltaGeral ==2 && diagonal){
             vizinhos.add(vizinho);
             return true;
         }else {
             return false;
         }
    }

    public void alternaMarcacao(){
        if (!aberto){
            aberto = true;
        }
    }
    public boolean abrir() {
        if (!aberto && !marcado) {
            if (isMinado) {
                throw new ExplosaoException();
            }

            if (vizinhaSegura()) {
                vizinhos.forEach(v -> v.abrir());
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean vizinhaSegura(){
        return vizinhos.stream()
                .noneMatch(v -> v.isMinado);
    }

}
