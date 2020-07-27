package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author braulio
 */
public final class Roda {

    private EspacoRoda[] espacos;
    private EspacoRoda espacoAtual;
    private int idx = 0;
    public static final int PROX = -1;
    public static final int RESET = -2;

    private static final String EXTENSAO_IMAGEM = ".jpg";
    private static final int NUMERO_ESPACOS = 24;
    private static final String CAMINHO_IMAGENS = "figuras";
    private final Random rand;

    /**
     * Inicializa a roda e faz o um giro.
     */
    public Roda() {
        rand = new Random();
        inicializarRoda();
        girarRoda();
    }

    /**
     * Retorna o valor atual da roda
     *
     * @return int
     */
    public int getValorAtual() {
        return espacoAtual.getValor();
    }

    /**
     * Retorna a imagem atual da roda
     *
     * @return Image
     */
    public Image getImagemAtual() {
        return espacoAtual.getImagem();
    }

    /**
     * Gira a roda aleatoriamente, [1,24]
     */
    public void girarRoda() {
        idx = rand.nextInt(NUMERO_ESPACOS);
        espacoAtual = espacos[idx];
    }

    /**
     * Inicializa os valores e as imagens da roda.
     */
    private void inicializarRoda() {
        this.espacos = new EspacoRoda[NUMERO_ESPACOS];
        File f = new File("");
        String file_path = f.getAbsolutePath() + "\\" + CAMINHO_IMAGENS + "\\";

        try {
            espacos[0] = new EspacoRoda(PROX, new Image(new FileInputStream(file_path + "1_loseATurn" + EXTENSAO_IMAGEM)));
            espacos[1] = new EspacoRoda(800, new Image(new FileInputStream(file_path + "2_800" + EXTENSAO_IMAGEM)));
            espacos[2] = new EspacoRoda(350, new Image(new FileInputStream(file_path + "3_350" + EXTENSAO_IMAGEM)));
            espacos[3] = new EspacoRoda(450, new Image(new FileInputStream(file_path + "4_450" + EXTENSAO_IMAGEM)));
            espacos[4] = new EspacoRoda(700, new Image(new FileInputStream(file_path + "5_700" + EXTENSAO_IMAGEM)));
            espacos[5] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "6_300" + EXTENSAO_IMAGEM)));

            espacos[6] = new EspacoRoda(600, new Image(new FileInputStream(file_path + "7_600" + EXTENSAO_IMAGEM)));
            espacos[7] = new EspacoRoda(5000, new Image(new FileInputStream(file_path + "8_5000" + EXTENSAO_IMAGEM)));
            espacos[8] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "9_300" + EXTENSAO_IMAGEM)));
            espacos[9] = new EspacoRoda(600, new Image(new FileInputStream(file_path + "10_600" + EXTENSAO_IMAGEM)));
            espacos[10] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "11_300" + EXTENSAO_IMAGEM)));
            espacos[11] = new EspacoRoda(500, new Image(new FileInputStream(file_path + "12_500" + EXTENSAO_IMAGEM)));

            espacos[12] = new EspacoRoda(800, new Image(new FileInputStream(file_path + "13_800" + EXTENSAO_IMAGEM)));
            espacos[13] = new EspacoRoda(550, new Image(new FileInputStream(file_path + "14_550" + EXTENSAO_IMAGEM)));
            espacos[14] = new EspacoRoda(400, new Image(new FileInputStream(file_path + "15_400" + EXTENSAO_IMAGEM)));
            espacos[15] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "16_300" + EXTENSAO_IMAGEM)));
            espacos[16] = new EspacoRoda(900, new Image(new FileInputStream(file_path + "17_900" + EXTENSAO_IMAGEM)));
            espacos[17] = new EspacoRoda(500, new Image(new FileInputStream(file_path + "18_500" + EXTENSAO_IMAGEM)));

            espacos[18] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "19_300" + EXTENSAO_IMAGEM)));
            espacos[19] = new EspacoRoda(900, new Image(new FileInputStream(file_path + "20_900" + EXTENSAO_IMAGEM)));
            espacos[20] = new EspacoRoda(RESET, new Image(new FileInputStream(file_path + "21_bankrupt" + EXTENSAO_IMAGEM)));
            espacos[21] = new EspacoRoda(600, new Image(new FileInputStream(file_path + "22_600" + EXTENSAO_IMAGEM)));
            espacos[22] = new EspacoRoda(400, new Image(new FileInputStream(file_path + "23_400" + EXTENSAO_IMAGEM)));
            espacos[23] = new EspacoRoda(300, new Image(new FileInputStream(file_path + "24_300" + EXTENSAO_IMAGEM)));
        } catch (FileNotFoundException err) {
            System.err.println("Erro ao localizar file:" + err);
        }
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
