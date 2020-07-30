package roda_da_fortuna;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * // interface grafica do braulio
 * @author higor
 */
public class IntroducaoController {

    @FXML
    private Button iniciar;

    @FXML
    private TextField nomeJogador1, nomeJogador2, nomeJogador3, puzzle;

    /**
     * Mostra o tabuleiro do jogo apos enviar os nomes dos jogadores e o puzzle inseridos.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void mostrarTabuleiroAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("painelJogo.fxml"));
        Parent root = loader.load();

        PainelJogoController tabuleiroController = loader.getController();
        tabuleiroController.setPuzzleENomeJogadores(puzzle.getText(), nomeJogador1.getText(), nomeJogador2.getText(),
                nomeJogador3.getText());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Roda da Fortuna");
        stage.resizableProperty().set(false);
        stage.show();
        
        ((Stage) iniciar.getScene().getWindow()).close(); // fechar Introducao
    }

}