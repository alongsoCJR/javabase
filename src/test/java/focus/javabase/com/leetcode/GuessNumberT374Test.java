package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//We are playing the Guess Game. The game is as follows:
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I'll tell you whether the number is higher or low
//er.
//
// You call a pre-defined API guess(int num) which returns 3 possible results (-
//1, 1, or 0):
//
//
//-1 : My number is lower
// 1 : My number is higher
// 0 : Congrats! You got it!
//
//
// Example :
//
//
//
//Input: n = 10, pick = 6
//Output: 6
//
//
// Related Topics 二分查找

public class GuessNumberT374Test extends AbstractTest {

    //    @Before
    public void setUp() throws Exception {
        inputNum = 10;
        GuessNumberT374.pick = 6;
        exceptedNum = 6;
    }

    @Before
    public void setUp1() throws Exception {
        inputNum = 1;
        GuessNumberT374.pick = 1;
        exceptedNum = 1;
    }

    @Test
    public void guessNumber() {
        Assert.assertEquals(exceptedNum, GuessNumberT374.guessNumber(inputNum));
    }
}