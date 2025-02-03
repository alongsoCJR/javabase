package focus.javabase.com.thread.providerconsumer;

public class Consumer00 implements Runnable {

    private ProducerConsumer00 producerConsumer00;

    public Consumer00(ProducerConsumer00 producerConsumer00) {
        this.producerConsumer00 = producerConsumer00;
    }

    @Override
    public void run() {
        while (true) {
            producerConsumer00.consume();
        }
    }
}