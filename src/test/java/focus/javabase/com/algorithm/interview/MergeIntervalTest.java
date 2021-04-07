package focus.javabase.com.algorithm.interview;

import focus.javabase.com.baseTest.AbstractTest;
import focus.javabase.com.leetcode.base.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeIntervalTest extends AbstractTest {

    List<Interval> inputList = new ArrayList<>();

//    @Before
    public void setUp() throws Exception {
        inputList.add(new Interval(1, 3));
        inputList.add(new Interval(2, 4));
        inputList.add(new Interval(6, 9));
    }

//    @Before
    public void setUp1() throws Exception {
        inputList.add(new Interval(1, 3));
        inputList.add(new Interval(6, 9));
        inputList.add(new Interval(2, 10));
    }



    @Before
    public void setUp2() throws Exception {
        inputList.add(new Interval(6, 9));
        inputList.add(new Interval(2, 10));
        inputList.add(new Interval(0, 3));
        inputList.add(new Interval(12, 23));
        inputList.add(new Interval(15, 18));
        inputList.add(new Interval(30, 100));
    }

    // [1,3][2,4][6,9]         [1,3][6,9][2,10]-->[1,3][2,10][6,9]
    //
    //[1,4][6,9]        [1,10]
    @Test
    public void merge() {
        List<Interval> outputList = MergeInterval.merge(inputList);
    }
}