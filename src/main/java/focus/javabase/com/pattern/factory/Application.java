package focus.javabase.com.pattern.factory;

public class Application {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.orderPizza("cheese");

        System.out.println("===================");
        pizzaStore.orderPizza("clam");

        System.out.println("===================");
        pizzaStore.orderPizza("veggie");

        System.out.println("===================");
        pizzaStore.orderPizza("veggi");
    }
}