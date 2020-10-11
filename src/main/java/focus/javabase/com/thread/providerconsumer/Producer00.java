package focus.javabase.com.thread.providerconsumer;


public class Producer00 implements Runnable {

    private ProducerConsumer00 producerConsumer00;

    public Producer00(ProducerConsumer00 producerConsumer00) {
        this.producerConsumer00 = producerConsumer00;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            producerConsumer00.produce();
        }
    }
}