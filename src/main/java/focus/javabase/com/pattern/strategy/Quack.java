package focus.javabase.com.pattern.strategy;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子呱呱叫！");

    }
}