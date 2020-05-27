package focus.javabase.com.pattern.singleton;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleInstanceEnumT05Test extends AbstractTest {

    @Test
    public void getInstance() {

        SingleInstanceEnumT05 instance = SingleInstanceEnumT05.getInstance();

        System.out.println(instance);
    }
}