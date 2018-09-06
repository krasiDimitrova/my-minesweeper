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
        System.out.print("Enter q, o, f, u: ");
        char c = scanner.next().charAt(0);
        if (c == 'f') {
            board.flag(x, y);
        } else if (c == 'u') {
            board.unFlag(x, y);
        } else {
            endGame = board.openZone(x, y);
        }
        board.printBoard();
        if (endGame) {
            System.out.println("Sorry you opened mine!");
        } else if (c == 'q') {
            endGame = true;
            System.out.println("Goodbye!");
        } else if (board.allOpened()) {
            endGame = true;
            System.out.println("You won!");
        }
    }

    public void revealBoard() {
        board.openAllZones();
        board.printBoard();
    }
}
