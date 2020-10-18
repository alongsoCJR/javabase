package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindMoneyCombinationsTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputNums = new int[]{1, 5, 10, 20, 50, 100};
        inputNum = 100;
    }

    @Test
    public void getAllComBinations() {
        System.out.println(FindMoneyCombinations.getAllComBinations(inputNums, inputNum));
    }
}