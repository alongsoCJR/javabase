package focus.javabase.com.pattern.factory.simplefactory;

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
        // 烘烤
        pizza.bake();
        // 切片
        pizza.cut();
        // 装盒
        pizza.box();
        return pizza;
    }
}