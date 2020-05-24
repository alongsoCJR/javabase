package focus.javabase.com.pattern.factory;

import java.util.ArrayList;

public abstract class Pizza {

    String name;

    // 面团
    String dough;

    // 酱料
    String sauce;

    // 一套佐料
    ArrayList toppings = new ArrayList();


    void preprae() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");

        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }


    void back() {
        System.out.println("Bake for 25 minutes at 350");
    }


    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");

    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");

    }

    public String getName() {
        return this.name;
    }
}