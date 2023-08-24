package leetcode;

import java.util.LinkedList;

public class ProducerConsumer {

    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 10;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == CAPACITY) {
                    wait();
                }
                System.out.println("Producer produced-" + value);                buffer.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.size() == 0) {
                    wait();
                }
                int value = buffer.removeFirst();
                System.out.println("Consumer consumed-" + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
