package myMinesweeper;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MatrixTest {

    @Test
    public void givenMatrixSizeWhenGetNeighboursForAChosenMiddleElementThenReturnIndexArrayOfItsNeighbours() {
        int[][] expected = { { 0, 2, 0, 1, 2, 0, 1, 2 }, { 1, 1, 0, 0, 0, 2, 2, 2 } };
        assertArrayEquals(expected, Matrix.getNeighbours(9, 1, 1));
    }

    @Test
    public void givenGameboardWhenGetNeighboursForAChosenCornerElementThenReturnIndexMapOfItsNeighbours() {
        int[][] expected = { { 1, 0, 1, -1, -1, -1, -1, -1 }, { 0, 1, 1, -1, -1, -1, -1, -1 }, };
        assertArrayEquals(expected, Matrix.getNeighbours(9, 0, 0));
    }

    @Test
    public void givenGameboardWhenGetNeighboursForAChosenBottomElementThenReturnIndexMapOfItsNeighbours() {
        int[][] expected = { { 7, 7, 8, 7, 8, -1, -1, -1 }, { 1, 0, 0, 2, 2, -1, -1, -1 }, };
        assertArrayEquals(expected, Matrix.getNeighbours(9, 8, 1));
    }

    @Test
    public void givenGameboardWhenGetNeighboursForAChosenLeftElementThenReturnIndexMapOfItsNeighbours() {
        int[][] expected = { { 0, 2, 0, 1, 2, -1, -1, -1 }, { 0, 0, 1, 1, 1, -1, -1, -1 }, };
        assertArrayEquals(expected, Matrix.getNeighbours(9, 1, 0));
    }

}
