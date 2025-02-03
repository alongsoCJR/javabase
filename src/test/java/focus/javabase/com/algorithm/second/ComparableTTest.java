package focus.javabase.com.algorithm.second;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class ComparableTTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
        inputArrayList.add(new ComparableT(3));
        inputArrayList.add(new ComparableT(5));
        inputArrayList.add(new ComparableT(3));
        inputArrayList.add(new ComparableT(6));
        inputArrayList.add(new ComparableT(8));
        inputArrayList.add(new ComparableT(9));
        inputArrayList.add(new ComparableT(0));
    }

    @Test
    public void compareTo() {
        Collections.sort(inputArrayList);
    }
}