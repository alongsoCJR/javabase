package focus.javabase.com.pattern.factory.abstractfactory;

public abstract class Pizza {

    String name;

    // 面团
    Dough dough;

    // 酱料
    Sauce sauce;

    // 一套佐料
    Cheese cheese;

    Pepperoni pepperoni;

    Clams clams;

    abstract void preprae();


    void bake() {
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clams=" + clams +
                '}';
    }
}