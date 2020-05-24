package focus.javabase.com.pattern.factory.abstractfactory;

import focus.javabase.com.pattern.factory.simplefactory.VeggiePizza;

public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    VeggiePizza createVeggiePizza();

    Pepperoni createPepperoni();

    Clams createClams();
}