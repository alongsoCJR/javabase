package focus.javabase.com.pattern.factory;

/**
 * @Author chenjianrong-lhq
 * @Description pizza商店
 * @Date 2020-05-24 15:30
 **/
public class PizzaStore {

    Pizza orderPizza(String type) {

        Pizza pizza = null;
        // 变化的一部分
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("peperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        }

        // 不变的一部分
        pizza.preprae();
        pizza.back();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}