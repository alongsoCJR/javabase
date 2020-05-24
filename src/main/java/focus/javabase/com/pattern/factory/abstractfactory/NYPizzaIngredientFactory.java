package focus.javabase.com.pattern.factory.abstractfactory;

import focus.javabase.com.pattern.factory.simplefactory.VeggiePizza;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough("ThickCrustDough");
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce("PlumTomatoSauce");
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese("MozzarellaCheese");
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
        return new FrozenClams("FrozenClams");
    }
}