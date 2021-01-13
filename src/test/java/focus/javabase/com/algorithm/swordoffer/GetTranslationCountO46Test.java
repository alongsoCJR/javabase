package focus.javabase.com.algorithm.swordoffer;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


// 输入一个数字，翻译成字母（0-a，1-b,2-c,,,25-z），求一共有多少种翻译
// 比如：12258 bccfi、bwfi、bczi、mcfi、mzi 共5种
public class GetTranslationCountO46Test extends AbstractTest {

//    @Before
    public void setUp() throws Exception {
        inputNum = 12258;
        exceptedNum = 5;
    }

    @Before
    public void setUp1() throws Exception {
        inputNum = 12218;
        exceptedNum = 8;
    }

    @Test
    public void testGetTranslationCount() {
        Assert.assertEquals(exceptedNum, GetTranslationCountO46.getTranslationCount(inputNum));
    }


    @Test
    public void testGetTranslationCount2() {
        Assert.assertEquals(exceptedNum, GetTranslationCountO46.getTranslationCount2(inputNum));
    }
}