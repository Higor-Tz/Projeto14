/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javafx.scene.image.Image;

/**
 *
 * @author higor
 */
public class Roda {
    
    private EspacoRoda[] espacos;
    private EspacoRoda espacoAtual;

    private static final String EXTENSAO_IMAGEM = "jpg";
    private static final int NUMERO_ESPACOS = 24;
    private static final String CAMINHO_IMAGENS = "figuras";

    /**
     * Inicializa a roda e faz o um giro.
     */
    public Roda() {
        inicializarRoda();
        girarRoda();
    }

    /**
     * Retorna o valor atual da roda
     * @return int
     */
    public int getValorAtual() {
        return espacoAtual.getValor();
    }

    /**
     * Retorna a imagem atual da roda
     * @return Image
     */
    public Image getImagemAtual() {
        return espacoAtual.getImagem();
    }

    /**
     * Gira a roda aleatoriamente, [1,24]
     */
    public void girarRoda() {
    
    }

    /**
     * Inicializa os valores e as imagens da roda.
     */
    private void inicializarRoda() {

    }

    /**
     * Classe interna para armazenar cada valor e imagem.
     */
    private class EspacoRoda {

        int valor;
        Image imagen;

        EspacoRoda(final int valor, final Image imagem) {
            this.valor = valor;
            this.imagen = imagem;
        }

        int getValor() {
            return valor;
        }

        Image getImagem() {
            return imagen;
        }
    }

}