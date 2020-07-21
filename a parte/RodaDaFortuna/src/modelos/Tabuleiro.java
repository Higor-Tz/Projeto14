/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author higor
 */
public class Tabuleiro {
    
    private final String puzzle;
    private final char[] palpitePuzzle;
    private int palpitesRestantes;

    /**
     * Seta o puzzle do jogo e inicializa o tabuleiro.
     * @param puzzle 
     */
    public Tabuleiro(String puzzle) {
        this.puzzle = puzzle.toUpperCase();
        this.palpitePuzzle = new char[puzzle.length()];
        inicializarTabuleiro();
    }

    /**
     * Inicializa <code>palpitesRestantes</code>, so considera as letras, e
     * <code>palpitePuzzle</code>.
     */
    private void inicializarTabuleiro() {
        
    }

    /**
     * Recebe o palpite do jogador
     * @param palpite
     * @return true se bateu o palpite
     */
    public boolean receberPalpite(char palpite) {
        return false; // remover
    }

    /**
     * Retorna os palpites do jogo a serem mostrados na tela.
     * @return String
     */
    public String getPalpitePuzzle() {
        return ""; // remover
    }

    public int getPalpitesRestantes() {
        return palpitesRestantes;
    }

    public String getPuzzle() {
        return puzzle;
    }

}