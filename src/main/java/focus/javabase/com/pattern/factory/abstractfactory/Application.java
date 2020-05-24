package focus.javabase.com.pattern.factory.abstractfactory;


public class Application {

    public static void main(String[] args) {

        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());
        System.out.println(pizza.toString());
        System.out.println("==============");

        pizzaStore = new ChicagoPizzaStore();
        pizza = pizzaStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza.getName());
        System.out.println(pizza.toString());

    }
}