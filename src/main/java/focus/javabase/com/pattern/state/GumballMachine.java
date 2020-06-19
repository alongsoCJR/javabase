package focus.javabase.com.pattern.state;

public class GumballMachine {

    final static int SOLD_OUT = 0;
    final static int NO_QUARTE = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTE;
        }
    }

    // 投入硬币
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You cna't insert another quarter");
        } else if (state == NO_QUARTE) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't insert a quarter,the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("please wait,we're already giving you a guaball");
        }

    }

    // 退回硬币
    public void ejectQuater() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTE;
        } else if (state == NO_QUARTE) {
            System.out.println("You haven't inserted a quater");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject,you haven't inserted a quarter yet");
        } else if (state == SOLD) {
            System.out.println("Sorry,you already turned the crank");
        }

    }

    // 转动曲柄
    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTE) {
            System.out.println("You turned,but there are no gumballs");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned,but there are no gumballs");
        } else if (state == SOLD) {
            System.out.println("Turing twice doesn't get you another gumball!");
        }
    }


    // 发放糖果
    public void dispense() {
        if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        } else if (state == NO_QUARTE) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops,out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTE;
            }
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}