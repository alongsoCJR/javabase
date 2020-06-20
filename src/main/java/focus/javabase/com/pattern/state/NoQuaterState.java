package focus.javabase.com.pattern.state;

public class NoQuaterState implements State {

    StateGumballMachine stateGumballMachine;

    public NoQuaterState(StateGumballMachine stateGumballMachine) {
        this.stateGumballMachine = stateGumballMachine;
    }

    @Override
    public void insertQuater() {
        System.out.println("You inserted a quarter");
        stateGumballMachine.setState(stateGumballMachine.getHasQuaterState());
    }

    @Override
    public void ejectQuater() {
        System.out.println("You haven't inserted a quater");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned,but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}