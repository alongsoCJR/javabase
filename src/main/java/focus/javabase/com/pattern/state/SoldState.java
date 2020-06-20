package focus.javabase.com.pattern.state;

public class SoldState implements State {

    StateGumballMachine stateGumballMachine;

    public SoldState(StateGumballMachine stateGumballMachine) {
        this.stateGumballMachine = stateGumballMachine;
    }

    @Override
    public void insertQuater() {
        System.out.println("please wait,we're already giving you a guaball");
    }

    @Override
    public void ejectQuater() {
        System.out.println("Sorry,you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turing twice doesn't get you another gumball!");

    }

    @Override
    public void dispense() {
        stateGumballMachine.releaseBall();
        if (stateGumballMachine.getCount() > 0) {
            stateGumballMachine.setState(stateGumballMachine.getNoQuaterState());
        } else {
            stateGumballMachine.setState(stateGumballMachine.getSoldOutState());
        }
    }
}