package focus.javabase.com.base;

import org.junit.After;
import org.junit.Before;

public class AbstractTest {

    long startTime = 0L;
    long endTime = 0L;

    @Before
    public void begin() {
        startTime = System.nanoTime();
    }

    @After
    public void end() {
        endTime = System.nanoTime();
        System.out.println("测试时间总耗时：" + (endTime - startTime) + "ns");
    }
}