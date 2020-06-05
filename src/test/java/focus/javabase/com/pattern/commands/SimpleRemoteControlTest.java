package focus.javabase.com.pattern.commands;

import focus.javabase.com.baseTest.AbstractTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleRemoteControlTest extends AbstractTest {

    SimpleRemoteControl simpleRemoteControl = null;
    Light light = null;
    Command command = null;
    GarageDoor garageDoor = null;

    //    @Before
    public void setUp() throws Exception {
        simpleRemoteControl = new SimpleRemoteControl();
        light = new Light();
        command = new LightOnCommand(light);
    }

    @Test
    public void buttonWasPressed() {
        simpleRemoteControl.setCommand(command);
        simpleRemoteControl.buttonWasPressed();
    }

    @Before
    public void setUp1() throws Exception {
        simpleRemoteControl = new SimpleRemoteControl();
        garageDoor = new GarageDoor();
        command = new GarageDoorOpenCommand(garageDoor);
    }

    @Test
    public void garageDoorOpen() {
        simpleRemoteControl.setCommand(command);
        simpleRemoteControl.buttonWasPressed();

    }


}