package myMinesweeper;

import java.util.Stack;

public class Board {
    private Zone[][] gameboard;
    private int size; // height and width
    private int mines; // number of mines
    private boolean endGame;

    public Board(int size, int mines) {
        this.size = size;
        gameboard = new Zone[size][size];
        this.mines = mines;
        endGame = false;
    }

    public boolean getEndGame() {
        return endGame;
    }

    public void setZones() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameboard[i][j] = new Zone(i, j);
            }
        }
    }

    public void setMines() {
        Stack<Integer> nums = Random.generateRandomNums(size);
        for (int i = 0; i < mines; i++) {
            int x = nums.pop().intValue();
            int y = nums.pop().intValue();
            (gameboard[x][y]).setMine();
            setValuesToNeigbours(x, y);
        }
    }

    private void setValuesToNeigbours(int x, int y) {
        int[][] nIndex = Matrix.getNeighbours(size, x, y);
        for (int i = 0; i < 8; i++) {
            if (nIndex[0][i] == -1) {
                break;
            }
            gameboard[nIndex[0][i]][nIndex[1][i]].incrementValue();
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(" | ");
                }
                gameboard[i][j].printZone();
            }
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
        System.out.println();
    }

}
