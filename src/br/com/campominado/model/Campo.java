package br.com.campominado.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private boolean minado;
    private final int linha;
    private final int coluna;
    private boolean aberto = false;
    private boolean isMinado = false;
    private boolean marcado = false;
    private List<Campo> vizinhos =new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

}
