package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle.
//
//
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it.
//
// Example:
//
//
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
//
// Related Topics 数组

// f(5)=f(4)+ f(4).last()add
public class GenerateT118Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNum = 5;
    }

    @Test
    public void generate() {
        System.out.println(GenerateT118.generate(inputNum));
    }
}