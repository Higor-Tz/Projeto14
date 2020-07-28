package roda_da_fortuna;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.Jogador;
import modelo.Roda;
import modelo.Tabuleiro;

/**
 *
 * @author braulio
 */
public class PainelJogoController {

    @FXML
    private Label ptoJog1;

    @FXML
    private Label ptoJog2;

    @FXML
    private Label ptoJog3;

    @FXML
    private GridPane paneJogadores;

    @FXML
    private Button comprarVogal, girarRoda, resolverPuzzle;

    @FXML
    private ImageView imagemRoda;

    @FXML
    private Label labelPuzzle;

    @FXML
    private GridPane paneVogais, paneConsoantes;

    private final int quantidadeJogadores = 3;
    private final int custoVogal = 250;
    private int posicaoJogadorAtual = 0;

    private int countVogais = 0;
    private int countConsoantes = 0;

    private Tabuleiro tabuleiro;
    private Roda roda;
    private final Jogador[] jogadores = new Jogador[quantidadeJogadores];
    private Jogador jogadorAtual;

    private final SepiaTone selected = new SepiaTone(1.5);
    private final SepiaTone deselected = new SepiaTone(0);

    /**
     * Inicializa a cena da primeira jogada.
     */
    @FXML
    private void initialize() {
        // bloquear comprarVogal
        this.comprarVogal.disableProperty().set(true);

        // instanciar a Roda
        this.roda = new Roda();
        // setar a imagem atual da Roda
        imagemRoda.setImage(this.roda.getImagemAtual()); // remover comentario, 
        // apos implementar a classe Roda

        // bloquear o painel das vogais
        this.paneVogais.disableProperty().set(true);
        // setar o evento clicarVogal em cada botao das vogais
        this.paneVogais.getChildren().forEach(n -> ((Button) n).setOnAction(e -> clicarVogal(e, (Button) n)));

        // bloquear o painel das consoantes
        this.paneConsoantes.disableProperty().set(true);
        // setar o evento clicarConsoante em cada botao das consoantes
        this.paneConsoantes.getChildren().forEach(n -> ((Button) n).setOnAction(e -> clicarConsoante(e, (Button) n)));

    }

    /**
     * Implementa a logica de comprar uma vogal.
     *
     * @param event
     */
    @FXML
    private void comprarVogalAction(ActionEvent event) {
        this.paneVogais.disableProperty().set(false);
        this.resolverPuzzle.disableProperty().set(true);
        this.girarRoda.disableProperty().set(true);
        this.comprarVogal.disableProperty().set(true);
        jogadorAtual.reduzirPontos(custoVogal);
    }

    /**
     * Implementa a logica de girar a roda.
     *
     * @param event
     */
    @FXML
    private void girarRodaAction(ActionEvent event) {
        this.roda.girarRoda();
        this.imagemRoda.setImage(roda.getImagemAtual());
        if (roda.getValorAtual() == Roda.PROX || roda.getValorAtual() == Roda.RESET) {
            if (roda.getValorAtual() == Roda.RESET) {
                jogadorAtual.zerarPontos();
            }
            avancarProximoJogador();
        } else {
            this.paneConsoantes.disableProperty().set(false);
            this.resolverPuzzle.disableProperty().set(true);
            this.girarRoda.disableProperty().set(true);
        }
    }

    /**
     * Implementa a logica de tentar adivinhar o puzzle.
     *
     * @param event
     */
    @FXML
    private void resolverPuzzleAction(ActionEvent event) {

    }

    /**
     * Implementa a logica de clicar em uma CONSOANTE.
     *
     * @param event
     */
    private void clicarConsoante(ActionEvent event, Button n) {
        this.paneConsoantes.disableProperty().set(true);
        n.disableProperty().set(true);
        countConsoantes++;
        String spl[] = event.getSource().toString().split("'");
        char letra = spl[1].charAt(0);
        if (tabuleiro.receberPalpite(letra)) {
            jogadorAtual.aumentarPontos(roda.getValorAtual() * tabuleiro.getLetrasPalpite());
            palpiteCorreto();
        } else {
            avancarProximoJogador();
        }
    }

    /**
     * Implementa a logica de clicar em uma VOGAL.
     *
     * @param event
     */
    private void clicarVogal(ActionEvent event, Button n) {
        this.paneVogais.disableProperty().set(true);
        String spl[] = event.getSource().toString().split("'");
        n.disableProperty().set(true);
        countVogais++;
        char letra = spl[1].charAt(0);
        if (tabuleiro.receberPalpite(letra)) {
            palpiteCorreto();
        } else {
            avancarProximoJogador();
        }
    }

    private void palpiteCorreto() {
        this.labelPuzzle.setText(this.tabuleiro.getPalpitePuzzle());
        habilitarNovaJogada();
    }

    /**
     * Verifica se o jogo terminou, ou seja, se todas as letras do puzzle foram
     * preenchidas, e, em caso positivo, exibe uma mensagem informando quem
     * ganhou e termina a aplicacao.
     */
    private void isFimDoJogo() {
        //if(tabuleiro)
    }

    /**
     * Valida se todos os botoes das VOGAIS foram clicados, i.e., ficaram
     * desativados.
     *
     * @return boolean
     */
    private boolean isVogaisEsgotadas() {
        return (countVogais == 5);
    }

    /**
     * Valida se todos os botoes das CONSOANTES foram clicados, i.e., ficaram
     * desativados.
     *
     * @return boolean
     */
    private boolean isConsoantesEsgotadas() {
        return (countConsoantes == 21);
    }

    /**
     * Cria e exibe uma janela de alerta.
     *
     * @param type
     * @param titulo
     * @param conteudo
     */
    private void alerta(AlertType type, String titulo, String conteudo) {

    }

    public void habilitarNovaJogada() {
        this.paneConsoantes.disableProperty().set(true);
        this.paneVogais.disableProperty().set(true);
        
        boolean mostraVogal = (isVogaisEsgotadas() && (Integer.parseInt(jogadorAtual.getPontos()) >= custoVogal));
        this.comprarVogal.disableProperty().set(mostraVogal);
        this.girarRoda.disableProperty().set(isConsoantesEsgotadas());
        this.resolverPuzzle.disableProperty().set(false);
        
        ptoJog1.setText(jogadores[0].getPontos());
        ptoJog2.setText(jogadores[1].getPontos());
        ptoJog3.setText(jogadores[2].getPontos());
    }

    /**
     * Avanca para o proximo jogador. Adiciona o efeito de selecionado, i.e.,
     * <code>selected</code>, no <code>TitledPane</code> do jogador atual.
     */
    private void avancarProximoJogador() {
        ((TitledPane) this.paneJogadores.getChildren().get(posicaoJogadorAtual)).setEffect(deselected);
        posicaoJogadorAtual = (posicaoJogadorAtual + 1 < quantidadeJogadores) ? posicaoJogadorAtual + 1 : 0;
        ((TitledPane) this.paneJogadores.getChildren().get(posicaoJogadorAtual)).setEffect(selected);
        jogadorAtual = jogadores[posicaoJogadorAtual];
        habilitarNovaJogada();

        for (int i = 0; i < quantidadeJogadores; i++) {
            System.out.println(jogadores[i].getNome() + " -> " + jogadores[i].getPontos());
        }
    }

    /**
     * Recebe o puzzle e os nomes dos jogadores.
     *
     * @param puzzle
     * @param nomeJogadores
     */
    public void setPuzzleENomeJogadores(final String puzzle, final String... nomeJogadores) {
        this.tabuleiro = new Tabuleiro(puzzle);
        this.labelPuzzle.setText(this.tabuleiro.getPalpitePuzzle());

        for (int i = 0; i < quantidadeJogadores; i++) {
            ((TitledPane) this.paneJogadores.getChildren().get(i)).setText(nomeJogadores[i]);

            this.jogadores[i] = new Jogador(nomeJogadores[i]);
            this.jogadores[i].setRoda(this.roda);
        }

        this.jogadorAtual = this.jogadores[posicaoJogadorAtual];
        ((TitledPane) this.paneJogadores.getChildren().get(posicaoJogadorAtual)).setEffect(selected);
    }

}
