package myMinesweeper;

import java.util.Arrays;

public class Matrix {
    public static int[][] getNeighbours(int size, int x, int y) {
        int[][] indexes = new int[2][8];
        Arrays.fill(indexes[0], -1);
        Arrays.fill(indexes[1], -1);
        int count = 0;
        boolean top = (x - 1 < 0);
        boolean bottom = (x + 1 > size - 1);
        boolean left = (y - 1 < 0);
        boolean right = (y + 1 > size - 1);
        if (top) {
            indexes[0][count] = x + 1;
            indexes[1][count++] = y;
            if (!left) {
                indexes[0][count] = x;
                indexes[1][count++] = y - 1;
                indexes[0][count] = x + 1;
                indexes[1][count++] = y - 1;
            }
            if (!right) {
                indexes[0][count] = x;
                indexes[1][count++] = y + 1;
                indexes[0][count] = x + 1;
                indexes[1][count++] = y + 1;
            }
        } else if (bottom) {
            indexes[0][count] = x - 1;
            indexes[1][count++] = y;
            if (!left) {
                indexes[0][count] = x - 1;
                indexes[1][count++] = y - 1;
                indexes[0][count] = x;
                indexes[1][count++] = y - 1;
            }
            if (!right) {
                indexes[0][count] = x - 1;
                indexes[1][count++] = y + 1;
                indexes[0][count] = x;
                indexes[1][count++] = y + 1;
            }
        } else {
            indexes[0][count] = x - 1;
            indexes[1][count++] = y;
            indexes[0][count] = x + 1;
            indexes[1][count++] = y;
            if (!left) {
                indexes[0][count] = x - 1;
                indexes[1][count++] = y - 1;
                indexes[0][count] = x;
                indexes[1][count++] = y - 1;
                indexes[0][count] = x + 1;
                indexes[1][count++] = y - 1;
            }
            if (!right) {
                indexes[0][count] = x - 1;
                indexes[1][count++] = y + 1;
                indexes[0][count] = x;
                indexes[1][count++] = y + 1;
                indexes[0][count] = x + 1;
                indexes[1][count++] = y + 1;
            }
        }
        return indexes;
    }
}
