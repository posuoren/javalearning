package consumer.sync;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/20 13:33
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final CakeMaker cakeMaker = new CakeMaker();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cakeMaker.produce();
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
                    cakeMaker.consume();
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
