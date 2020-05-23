package focus.javabase.com.pattern.strategy;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是红头鸭！");
    }
}