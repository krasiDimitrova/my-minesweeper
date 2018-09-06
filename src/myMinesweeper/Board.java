package myMinesweeper;

import java.util.Stack;

public class Board {
    private Zone[][] gameboard;
    private int size; // height and width
    private int mines; // number of mines
    private int opened;

    public Board(int size, int mines) {
        this.size = size;
        gameboard = new Zone[size][size];
        this.mines = mines;
        opened = 0;
    }

    public boolean allOpened() {
        return opened == size * size - mines;
    }

    public void setZones() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameboard[i][j] = new Zone();
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
            int r = nIndex[0][i];
            int c = nIndex[1][i];
            if (r == -1) {
                break;
            }
            if (!gameboard[r][c].getMine()) {
                gameboard[r][c].incrementValue();
            }
        }
    }

    private void printTop() {
        System.out.println();
        for (int i = 0; i <= size; i++) {
            if (i > 0) {
                System.out.print(" " + (i - 1) + " |");
            } else {
                System.out.print("   |");
            }
        }
        System.out.println();
        for (int j = 0; j <= size; j++) {
            System.out.print("----");
        }
    }

    public void printBoard() {
        printTop();
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    System.out.print(" " + i + " | ");
                } else {
                    System.out.print(" | ");
                }
                gameboard[i][j].printZone();
            }
            System.out.println();
            for (int j = 0; j <= size; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean openZone(int x, int y) {
        if (x < 0 || y < 0 || x > size - 1 || y > size - 1) {
            System.out.println("Invalid location");
            return false;
        } else if (gameboard[x][y].getRevealed()) {
            System.out.println("Already oppened");
        } else {
            opened++;
            gameboard[x][y].setRevealed();
            openZeroes(x, y);
        }
        return gameboard[x][y].getMine();

    }

    public void openZeroes(int x, int y) {
        int[][] nIndex = Matrix.getNeighbours(size, x, y);
        for (int i = 0; i < 8; i++) {
            if (nIndex[0][i] == -1) {
                break;
            }
            int r = nIndex[0][i];
            int c = nIndex[1][i];
            if (gameboard[r][c].getValue() == 0 && !gameboard[r][c].getRevealed()) {
                gameboard[r][c].setRevealed();
                opened++;
                openZeroes(r, c);
            } else if (gameboard[r][c].getValue() > 0 && !gameboard[r][c].getRevealed()) {
                gameboard[r][c].setRevealed();
                opened++;
            }
        }
    }

    public void openAllZones() {
        for (Zone[] zA : gameboard) {
            for (Zone z : zA) {
                z.setRevealed();
            }
        }
    }

    public void flag(int x, int y) {
        gameboard[x][y].setFlagged(true);
    }

    public void unFlag(int x, int y) {
        gameboard[x][y].setFlagged(false);
    }

}
