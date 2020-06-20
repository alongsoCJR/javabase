package focus.javabase.com.pattern.state;

public interface State {

    void insertQuater();  // 投入硬币

    void ejectQuater();   // 退回硬币

    void turnCrank();     // 转动曲柄

    void dispense();      // 发放糖果
}
