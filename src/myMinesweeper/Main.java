package myMinesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gameplay game = new Gameplay(9, 10);
        while (!game.getEndGame()) {
            game.openZones(scanner);
        }
        game.revealBoard();
        scanner.close();
    }

}
