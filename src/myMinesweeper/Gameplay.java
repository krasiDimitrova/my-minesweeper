package myMinesweeper;

public class Gameplay {

    private Board board;

    public Gameplay(int size, int mines) {
        board = new Board(size, mines);
        board.setZones();
        board.setMines();
        board.printBoard();
    }
}
