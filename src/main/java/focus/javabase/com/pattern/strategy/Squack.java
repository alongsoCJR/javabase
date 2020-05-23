package focus.javabase.com.pattern.strategy;

public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱叫！");
    }
}