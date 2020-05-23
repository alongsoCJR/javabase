package focus.javabase.com.pattern.strategy;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("鸭子的飞行实现！");
    }
}