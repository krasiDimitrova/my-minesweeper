package myMinesweeper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomTest {

    @Test
    public void givenNumWhenGenerateRandomNumsIsInvokedThenReturnStackWithSizeNumNum() {
        assertEquals(81, Random.generateRandomNums(9).size());
    }

}
