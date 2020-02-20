package counter;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/19 20:10
 */
public class CounterTestDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        for(int i=0; i<=10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int timeCount = 10;
                    while (timeCount >= 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(counter.addAndGetter()));
                        timeCount --;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, String.format("inc-%d", i) ).start();
        }
    }
}
