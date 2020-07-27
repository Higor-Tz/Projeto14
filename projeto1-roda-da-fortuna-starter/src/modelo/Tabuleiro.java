package modelo;

/**
 *
 * @author braulio
 */
public class Tabuleiro {

    private final String puzzle;
    private final char[] palpitePuzzle;
    private int palpitesRestantes;
    private int letrasPalpite;

    /**
     * Seta o puzzle do jogo e inicializa o tabuleiro.
     *
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
        for (int i = 0; i < puzzle.length(); i++) {
            char charFill = filterSpecialCharacter(puzzle.charAt(i));
            palpitePuzzle[i] = (charFill < 'A' || charFill > 'Z') ? charFill : '_';
        }
        System.out.println(String.valueOf(palpitePuzzle));
    }

    public char filterSpecialCharacter(char c) {
        switch (c) {
            case 'À':
            case 'Á':
            case 'Ã':
            case 'Â':
                return 'A';
            case 'È':
            case 'É':
            case 'Ê':
                return 'E';
            case 'Ì':
            case 'Í':
            case 'Î':
                return 'I';
            case 'Ò':
            case 'Ó':
            case 'Õ':
            case 'Ô':
                return 'O';
            case 'Ù':
            case 'Ú':
            case 'Û':
                return 'U';
            case 'Ç':
                return 'C';
            case 'Ñ':
                return 'N';
            default:
                return c;
        }
    }

    /**
     * Recebe o palpite do jogador
     *
     * @param palpite
     * @return true se bateu o palpite
     */
    public boolean receberPalpite(char palpite) {
        if (puzzle.contains(String.valueOf(palpite))) {
            letrasPalpite = 0;
            for (int i = 0; i < puzzle.length(); i++) {
                char charFill = filterSpecialCharacter(puzzle.charAt(i));
                if (palpite == charFill) {
                    palpitePuzzle[i] = puzzle.charAt(i);
                    letrasPalpite++;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna os palpites do jogo a serem mostrados na tela.
     *
     * @return String
     */
    public String getPalpitePuzzle() {
        return String.valueOf(palpitePuzzle);
    }

    public int getPalpitesRestantes() {
        return palpitesRestantes;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public int getLetrasPalpite() {
        return letrasPalpite;
    }

}
