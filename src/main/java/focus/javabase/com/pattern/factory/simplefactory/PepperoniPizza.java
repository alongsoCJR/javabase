package focus.javabase.com.pattern.factory.simplefactory;

import java.util.ArrayList;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        this.name = "pepperoni";
        this.dough = "pepperoni dough";
        ArrayList list = new ArrayList();
        list.add("fire");
        list.add("click");
        this.toppings = list;
    }
}