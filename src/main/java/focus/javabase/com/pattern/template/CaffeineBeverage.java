package focus.javabase.com.pattern.template;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void pourInCup() {

        System.out.println("Pouring into cup");
    }


    private void boilWater() {
        System.out.println("Boiling water");
    }
}