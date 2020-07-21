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
public class Jogador {
    private String nome;
    private int numeroJogada = 0;
    private int pontos = 0;

    private Roda roda; // referencia a Roda global do PainelJogoController

    public Jogador(String nome) {
        this.nome = nome;
    }

    /**
     * Interage com a Roda e realiza um giro.
     */
    public void girarRoda() {
        this.roda.girarRoda();
    }

    /**
     * Reduz os pontos en <code>aReduzir</code>
     * @param aReduzir 
     */
    public void reduzirPontos(int aReduzir) {
        this.pontos -= aReduzir;
    }

    /**
     * Aumenta os pontos en <code>aAumentar</code>
     * @param aAumentar 
     */
    public void aumentarPontos(int aAumentar) {
        this.pontos += aAumentar;
    }

    /**
     * Zera todos os pontos do jogador
     */
    public void zerarPontos() {
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroJogada() {
        return numeroJogada;
    }

    public void setNumeroJogada(int numeroJogada) {
        this.numeroJogada = numeroJogada;
    }

    /**
     * Retorna os pontos do jogador como uma String
     * @return String
     */
    public String getPontos() {
        return String.valueOf(pontos);
    }

    public void setRoda(Roda roda) {
        this.roda = roda;
    }

}
