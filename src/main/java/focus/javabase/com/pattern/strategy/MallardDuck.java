package focus.javabase.com.pattern.strategy;

public class MallardDuck extends Duck {


    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭！");

    }
}