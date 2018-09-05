package myMinesweeper;

public class Zone {

    private boolean mine; // Shows if the zone is a mine
    private boolean revealed; // Show if the zone is opened by the user
    private int value; // Represents the number of surrounding mines
    private int x; // X coordinate on the board
    private int y; // Y coordinate on the board

    public Zone(int x, int y) {
        mine = false;
        revealed = false;
        value = 0;
        this.x = x;
        this.y = y;
    }

    public void setMine() {
        mine = true;
    }

    public boolean getMine() {
        return mine;
    }

    public void setRevealed() {
        revealed = true;
    }

    public boolean getRevealed() {
        return revealed;
    }

    public void incrementValue() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public void printZone() {
        if (mine) {
            System.out.println("*");
        } else {
            System.out.println(value);
        }
    }
}
