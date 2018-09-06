package myMinesweeper;

import java.util.Scanner;

public class Gameplay {

    private Board board;
    private boolean endGame;

    public Gameplay(int size, int mines) {
        board = new Board(size, mines);
        board.setZones();
        board.setMines();
        board.printBoard();
        endGame = false;
    }

    public boolean getEndGame() {
        return endGame;
    }

    public void openZones(Scanner scanner) {
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        System.out.print("Enter q, o, f: ");
        char c = scanner.next().charAt(0);
        endGame = (c == 'q') | board.openZone(x, y) | board.allOpened();
        board.printBoard();
        if (endGame) {
            System.out.println("EndGame!");
        }
    }

    public void revealBoard() {
        board.openAllZones();
        board.printBoard();
    }
}
