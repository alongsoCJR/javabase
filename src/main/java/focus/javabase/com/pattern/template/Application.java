package focus.javabase.com.pattern.template;

public class Application {

    public static void main(String[] args) {
        CaffeineBeverage beverage = new Tea();
        beverage.prepareRecipe();

        beverage = new Caffee();
        beverage.prepareRecipe();
    }
}