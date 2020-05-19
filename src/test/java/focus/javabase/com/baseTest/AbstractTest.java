package focus.javabase.com.baseTest;

import focus.javabase.com.leetcode.base.ListNode;
import focus.javabase.com.leetcode.base.TreeNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjianrong-lhq 2019年08月07日 17:44:12
 * @Description: 测试抽象类
 * @ClassName: AbstractTest
 */
public abstract class AbstractTest {
    protected Log logger = LogFactory.getLog(this.getClass());
    /** String 数组**/
    public static String[] inputStrs = {};
    public static String[] outputStrs = {};
    public static String[] exceptedStrs = {};

    /** int 数组**/
    public static int[] inputNums = {};
    public static int[] outputNums = {};
    public static int[] exceptedNums = {};

    /** int值**/
    public static int inputNum = Integer.MAX_VALUE;
    public static int outputNum = Integer.MAX_VALUE;
    public static int exceptedNum = Integer.MAX_VALUE;

    /** String字符串**/
    public static String inputStr = "";
    public static String outputStr = "";
    public static String exceptedStr = "";

    /** ListNode l1**/
    public static ListNode inputList = null;
    public static ListNode inputList2 = null;
    public static ListNode exceptedList = null;
    public static ListNode outputList = null;


    /** TreeNode **/
    public static TreeNode inputTree = null;
    public static TreeNode exceptedTree = null;
    public static TreeNode outputTree = null;

    public Boolean exceptedBoolean = null;

    /** List<T>**/
    public static List inputArrayList = new ArrayList<>();
    public static List exceptedArrayList = new ArrayList<>();
    public static List outputArrayList = new ArrayList<>();
    public static int[][] inputTwoArr = new int[][]{};
    public static int[][] outputTwoArr = new int[][]{};


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
