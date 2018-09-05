package myMinesweeper;

import java.util.Collections;
import java.util.Stack;

public class Random {
    public static Stack<Integer> generateRandomNums(int size) {
        Stack<Integer> nums = new Stack<Integer>();
        int counter = 0;
        while (counter < size) {
            for (int i = 0; i < size; i++) {
                nums.push(i);
            }
            counter++;
        }
        Collections.shuffle(nums);
        return nums;
    }
}
