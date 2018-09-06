package myMinesweeper;

public class Zone {

    private boolean mine; // Shows if the zone is a mine
    private boolean revealed; // Show if the zone is opened by the user
    private int value; // Represents the number of surrounding mines
    private boolean flagged; // Show if the zone is flagged as a mine by the user

    public Zone() {
        mine = false;
        revealed = false;
        value = 0;
        flagged = false;
    }

    public void setFlagged(boolean flag) {
        flagged = flag;
    }

    public boolean getFlagged() {
        return flagged;
    }

    public void setMine() {
        value = -1;
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
        if (revealed) {
            if (mine) {
                System.out.print("*");
            } else if (value == 0) {
                System.out.print(".");
            } else {
                System.out.print(value);
            }
        } else if (flagged) {
            System.out.print("?");
        } else {

            System.out.print(" ");
        }
    }
}
