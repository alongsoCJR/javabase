package focus.javabase.com.pattern.factory.factorymethod;

public class Application {

    public static void main(String[] args) {

        NYStylePizzaStore nyStylePizzaStore = new NYStylePizzaStore();
        Pizza pizza = nyStylePizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());
        System.out.println("==============");

        ChicagoStylePizzaStore chicagoStylePizzaStore = new ChicagoStylePizzaStore();
        pizza = chicagoStylePizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());

    }
}