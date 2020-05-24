package focus.javabase.com.pattern.factory.abstractfactory;

public class NYPizzaStore extends PizzaStore {

    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    @Override
    Pizza creatPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Style Cheese Pizza");
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("NY Style Clam Pizza");
        }
        return pizza;
    }
}