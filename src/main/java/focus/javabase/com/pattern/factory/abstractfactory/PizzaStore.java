package focus.javabase.com.pattern.factory.abstractfactory;


/**
 * @Author chenjianrong-lhq
 * @Description pizza商店
 * @Date 2020-05-24 15:30
 **/
public abstract class PizzaStore {

    Pizza orderPizza(String type) {

        // 变化的一部分
        Pizza pizza = creatPizza(type);
        // 不变的一部分
        pizza.preprae();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza creatPizza(String type);
}