package focus.javabase.com.pattern.singleton;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SingleInstanceT01Test extends AbstractTest {

    // 测试线程不安全的懒汉式
    @Test
    public void getInstance() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleInstanceT01 singleInstance = SingleInstanceT01.getInstance();
                    System.out.println(Thread.currentThread() + "获取singleInstance的hashCode值为：" + singleInstance.hashCode());
                }
            });
            thread.start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}