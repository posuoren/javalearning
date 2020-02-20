package consumer.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 13:28
 */
public class CakeMakerWithLock {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 8;
    private final Lock lock = new ReentrantLock();
    private final Condition bufferIsFull = lock.newCondition();
    private final Condition bufferIsEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        int value = 0;
        do {
            lock.lock();
            try {
                while (list.size() == capacity) {
                    System.out.println("is full");
                    bufferIsFull.await();
                }

                System.out.println("做出了蛋糕-" + value);

                // to insert the jobs in the list
                list.add(value++);
                bufferIsEmpty.signalAll();

                // notifies the consumer thread that
                // now it can start consuming

                // makes the working of program easier
                // to  understand

            }finally {
                lock.unlock();
                Thread.sleep(1000);
            }
        } while (true);
    }

    public void consume() throws InterruptedException {
        do {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println("is empty");
                    bufferIsEmpty.await();
                }

                int val = list.removeFirst();

                System.out.println("别人消费了蛋糕-"
                    + val);

                bufferIsFull.signalAll();

            }finally {
                lock.unlock();
                Thread.sleep(3000);
            }

        } while (true);
    }
}
