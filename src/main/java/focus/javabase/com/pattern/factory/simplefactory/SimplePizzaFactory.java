package focus.javabase.com.pattern.factory.simplefactory;

import focus.javabase.com.pattern.factory.*;

/**
 * @Author chenjianrong-lhq
 * @Description 简单工厂
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