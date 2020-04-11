package focus.javabase.com.facenote;

/**
 * @author chenjianrong-lhq 2019年07月25日 20:51:07
 * @Description:
 * @ClassName: Exhibitionist
 */
public class Exhibitionist {
    MyObservable myObservable = new MyObservable();

    public Exhibitionist() {}

    public java.util.Observable getObservable() {
        return myObservable;
    }

    public void trigger(String condition) {
        myObservable.invalidate();
        myObservable.notifyObservers(condition);
    }

    private class MyObservable extends java.util.Observable {
        private void invalidate() {
            setChanged();
        }
    }
}

