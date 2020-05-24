package focus.javabase.com.pattern.factory.factorymethod;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grates Reggiano Chesse");
    }

    @Override
    void box() {
        System.out.println("Boxing in the NY Style Box");
    }
}