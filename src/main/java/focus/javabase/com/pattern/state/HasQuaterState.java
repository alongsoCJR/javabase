package focus.javabase.com.pattern.state;

public class HasQuaterState implements State {

    StateGumballMachine stateGumballMachine;


    public HasQuaterState(StateGumballMachine stateGumballMachine) {
        this.stateGumballMachine = stateGumballMachine;
    }

    @Override
    public void insertQuater() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuater() {
        System.out.println("Quarter returned");
        stateGumballMachine.setState(stateGumballMachine.getNoQuaterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        stateGumballMachine.setState(stateGumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}