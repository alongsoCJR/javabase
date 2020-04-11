package focus.javabase.com.baseTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;

/**
 * @author chenjianrong-lhq 2019年08月07日 17:44:12
 * @Description: 测试抽象类
 * @ClassName: AbstractTest
 */
public abstract class AbstractTest {
    protected Log logger = LogFactory.getLog(this.getClass());
    public static String[] inputStrs = {};
    public static String[] outputStrs = {};
    public static String[] exceptedStrs = {};
    public static int[] inputNums = {};
    public static int[] outputNums = {};
    public static int[] exceptedNums = {};
    public static int outputNum = Integer.MAX_VALUE;
    public static int exceptedNum = Integer.MAX_VALUE;
    public static String outputStr = "";
    public static String exceptedStr = "";


    long startTime = 0L;
    long endTime = 0L;

    @Before
    public void begin() {
        startTime = System.currentTimeMillis();
    }

    @After
    public void end() {
        endTime = System.currentTimeMillis();
        System.out.println("测试时间总耗时：" + (endTime - startTime) + "ms");
    }
}
