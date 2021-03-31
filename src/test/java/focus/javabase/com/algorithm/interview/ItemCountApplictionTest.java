package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ItemCountApplictionTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputStrs = new String[]{"1", "1", "2", "3", "4", "1", "2", "2", "2"};
    }


    //    @Before
    public void setUp1() throws Exception {
        inputStrs = new String[]{"1", "2", "3", "4"};
    }

    @Test
    public void getSortedResult() {
        Set set = ItemCountAppliction.getSortedResult(inputStrs);
    }
}