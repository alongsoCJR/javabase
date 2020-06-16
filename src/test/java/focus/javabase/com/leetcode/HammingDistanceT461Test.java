package focus.javabase.com.leetcode;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HammingDistanceT461Test extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        exceptedNum = 2;
    }

    @Test
    public void hammingDistance() {
        Assert.assertEquals(exceptedNum, HammingDistanceT461.hammingDistance1(1, 4));
    }
}