package br.com.campominado.application;

import br.com.campominado.model.Tabuleiro;
import br.com.campominado.view.TabuleiroConsole;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(5, 5, 5);
        new TabuleiroConsole(tabuleiro);
    }
}