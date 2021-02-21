package boardgame;

public class Board {

    private int rows;
    private  int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        //array
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //Retornar a matriz pieces na linha row e coluna column
    public Piece piece(int row, int columns){
        if(!positionExists(row, columns)){
            throw  new BoardException("Position not on the board");
        }
        return pieces[row][columns];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw  new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    //Atribuição de position para a peça
    public void placePiece(Piece piece, Position position){
        if(thereAPiece(position)){
            throw  new BoardException("There is alread a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //Metodo auxiliar do public boolean positonExits
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows & column >= 0 && column < columns;
    }

    //Posição existe ?
    public boolean positionExists(Position position){
       return positionExists(position.getRow(), position.getColumn());
    }

    //Tem uma peça nessa position
    public boolean thereAPiece(Position position){
        if(!positionExists(position)){
            throw  new BoardException("Position not on the board");
        }
       return piece(position) != null;
    }


}
