package focus.javabase.com.pattern.facenote.observer;

import focus.javabase.com.pattern.facenote.Exhibitionist;

import java.util.Observable;
import java.util.Observer;

/**
 * @author chenjianrong-lhq 2019年07月25日 20:52:13
 * @Description:
 * @ClassName: Voyeur
 */
public class Costomer implements Observer {

    public Costomer(Exhibitionist exhibitionist) {
        // Register ourselves as interested in the Exhibitionist.
        exhibitionist.getObservable().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Called when the observable notifies its observers.
        System.out.println("观察者：" + this.getClass().getName() + " || 接受到的消息：" + arg.toString());
    }
}