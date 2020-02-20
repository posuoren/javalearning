package consumer.lock;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 13:33
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final CakeMakerWithLock cakeMakerWithLock = new CakeMakerWithLock();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cakeMakerWithLock.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cakeMakerWithLock.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}
