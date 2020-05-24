package focus.javabase.com.pattern.factory.simplefactory;

/**
 * @Author chenjianrong-lhq
 * @Description 简单工厂 1.有加盟店加入,不容易扩展   2.类的依赖度太高了，新增一种类型的，需要改代码
 * @Date 2020-05-24 15:41
 **/
public class SimplePizzaFactory {

    public Pizza create(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("peperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        } else {
            System.out.println("本店没有该口味披萨，请换购其他类型");
        }
        return pizza;
    }
}