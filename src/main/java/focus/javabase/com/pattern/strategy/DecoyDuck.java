package focus.javabase.com.pattern.strategy;

/**
 * @Author chenjianrong-lhq
 * @Description 诱饵鸭 不会飞，不会叫
 * @Date 2020-05-23 11:27
 **/
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是诱饵鸭");
    }


}