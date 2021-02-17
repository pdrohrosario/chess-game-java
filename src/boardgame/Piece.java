package boardgame;

public class Piece {
    protected Position position;
    protected Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
        //a peça começa com uma posição nula pois ainda não foi
        //colocada no tabuleiro
    }

    //Board - Somente classes e subclasses do mesmo pacote tem acesso a ele
    protected Board getBoard() {
        return board;
    }
}
