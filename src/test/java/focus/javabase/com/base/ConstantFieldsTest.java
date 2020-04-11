package focus.javabase.com.base;

import focus.javabase.com.basejava.ConstantFields;
import org.junit.Test;

public class ConstantFieldsTest {

    @Test
    public void testStaticDate() {
        int[] arr = {12, 3, 21, 86, 39, 23};
        ConstantFields.bubbleSort(arr);
    }

}