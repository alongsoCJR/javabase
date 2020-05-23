package focus.javabase.com.pattern.strategy;

/**
 * @Author chenjianrong-lhq
 * @Description 橡皮鸭 不会飞 吱吱叫
 * @Date 2020-05-23 11:26
 **/
public class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Squack();
    }

    @Override
    public void display() {
        System.out.println("我是橡皮鸭！");
    }
}