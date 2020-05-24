package focus.javabase.com.pattern.factory;

import focus.javabase.com.pattern.factory.simplefactory.SimplePizzaFactory;

/**
 * @Author chenjianrong-lhq
 * @Description pizza商店
 * @Date 2020-05-24 15:30
 **/
public class PizzaStore {

    Pizza orderPizza(String type) {

        // 变化的一部分
        Pizza pizza = new SimplePizzaFactory().create(type);

        // 不变的一部分
        pizza.preprae();
        pizza.back();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}