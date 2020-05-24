package focus.javabase.com.pattern.factory.abstractfactory;

import focus.javabase.com.pattern.factory.simplefactory.VeggiePizza;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough("ThinCrustDough");
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce("MarinaraSauce");
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese("ReggianoCheese");
    }

    @Override
    public VeggiePizza createVeggiePizza() {
        return null;
    }

    @Override
    public Pepperoni createPepperoni() {
        return null;
    }

    @Override
    public Clams createClams() {
        return new FreshClams("FreshClams");
    }
}