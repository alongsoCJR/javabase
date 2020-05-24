package focus.javabase.com.pattern.factory.factorymethod;

public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    Pizza creatPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new ChicagoCheesePizza();
        } else if ("peperoni".equals(type)) {
            pizza = new ChicagoPepperoniPizza();
        }
        return pizza;
    }
}