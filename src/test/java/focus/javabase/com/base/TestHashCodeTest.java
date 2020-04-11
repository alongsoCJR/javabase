package focus.javabase.com.base;



import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestHashCodeTest {

    @Test
    public void testHashCode() {
        for (int i = 0; i < 1000000; i++) {
            Object obj1 = new Object();
            Object obj2 = new Object();
            assertTrue(obj1.hashCode() != obj2.hashCode());
        }
    }

    @Test
    public void testStringHashCode() {
        for (int i = 0; i < 1000000; i++) {
            String obj1 = new String(i+"");
            String obj2 = new String(i+"");
//            assertTrue(obj1.hashCode()==0);
            assertTrue(obj1.hashCode() == obj2.hashCode());
        }
    }

}