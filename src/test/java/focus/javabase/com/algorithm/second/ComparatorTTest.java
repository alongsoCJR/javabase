package focus.javabase.com.algorithm.second;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;

public class ComparatorTTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputArrayList.add(new ComparatorT(3));
        inputArrayList.add(new ComparatorT(5));
        inputArrayList.add(new ComparatorT(3));
        inputArrayList.add(new ComparatorT(6));
        inputArrayList.add(new ComparatorT(8));
        inputArrayList.add(new ComparatorT(9));
        inputArrayList.add(new ComparatorT(0));
    }

    @Test
    public void compare() {
        Collections.sort(inputArrayList, new Comparator<ComparatorT>() {
            @Override
            public int compare(ComparatorT o1, ComparatorT o2) {
                return o2.age - o1.age;
            }
        });
    }
}