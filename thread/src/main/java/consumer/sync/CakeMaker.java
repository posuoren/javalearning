package consumer.sync;

import java.util.LinkedList;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 13:28
 */
public class CakeMaker {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 8;

    public void produce() throws InterruptedException {
        int value = 0;
        do {
            synchronized (this) {
                while (list.size() == capacity) {
                    System.out.println("is full");
                    wait();
                }

                System.out.println("做出了蛋糕-" + value);

                // to insert the jobs in the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to  understand
                Thread.sleep(1000);
            }
        } while (true);
    }

    public void consume() throws InterruptedException {
        do {
            synchronized (this) {
                while (list.size() == 0) {
                    System.out.println("is empty");
                    wait();
                }

                int val = list.removeFirst();

                System.out.println("别人消费了蛋糕-"
                    + val);

                notify();
                Thread.sleep(1000);
            }
        } while (true);
    }
}
