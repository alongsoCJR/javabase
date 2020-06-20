package focus.javabase.com.pattern.state;

public class StateGumballMachine {

    State noQuaterState;
    State hasQuaterState;
    State soldState;
    State soldOutState;


    State state = soldState;
    int count = 0;

    public StateGumballMachine(int count) {
        noQuaterState = new NoQuaterState(this);
        hasQuaterState = new HasQuaterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        this.count = count;
        if (count > 0) {
            state = noQuaterState;
        }
    }

    // 投入硬币
    public void insertQuarter() {
        state.insertQuater();
    }

    // 退回硬币
    public void ejectQuater() {
        state.ejectQuater();
    }

    // 转动曲柄
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }


    // 发放糖果
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    @Override
    public String toString() {
        return "StateGumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoQuaterState() {
        return noQuaterState;
    }

    public void setNoQuaterState(State noQuaterState) {
        this.noQuaterState = noQuaterState;
    }

    public State getHasQuaterState() {
        return hasQuaterState;
    }

    public void setHasQuaterState(State hasQuaterState) {
        this.hasQuaterState = hasQuaterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}