package focus.javabase.com.pattern.factory.factorymethod;

public class NYStylePizzaStore extends PizzaStore {

    @Override
    Pizza creatPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new NYStyleCheesePizza();
        } else if ("peperoni".equals(type)) {
            pizza = new NYStylePepperoniPizza();
        }
        return pizza;
    }
}