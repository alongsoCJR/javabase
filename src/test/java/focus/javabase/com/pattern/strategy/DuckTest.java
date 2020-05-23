package focus.javabase.com.pattern.strategy;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuckTest extends AbstractTest {

    @Test
    public void testDuck() {

        // 测试行为实现
        Duck duck = new RedheadDuck();
        perform(duck);

        duck = new MallardDuck();
        perform(duck);

        duck = new RubberDuck();
        perform(duck);

        duck = new DecoyDuck();
        perform(duck);


        // 测试set方法

        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackBehavior(new Quack());
        perform(duck);
    }


    public void perform(Duck duck) {
        duck.display();
        duck.performFly();
        duck.performQuack();
        duck.swim();

        System.out.println("============");
    }
}