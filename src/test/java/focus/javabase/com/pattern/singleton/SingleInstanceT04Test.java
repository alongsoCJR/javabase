package focus.javabase.com.pattern.singleton;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SingleInstanceT04Test extends AbstractTest {

    // 内部类 延迟初始化
    @Test
    public void getInstance() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleInstanceT04 singleInstance = SingleInstanceT04.getInstance();
                    System.out.println(Thread.currentThread() + "获取singleInstance的hashCode值为：" + singleInstance.hashCode());
                }
            });
            thread.start();
        }
        try {
            System.in.read(); // 阻塞
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}