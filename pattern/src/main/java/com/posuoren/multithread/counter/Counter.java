package com.posuoren.multithread.counter;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/19 20:07
 */
public class Counter {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public int addAndGetter(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + String.format("before: %d", count));
            count += 1;
            System.out.println(Thread.currentThread().getName() + String.format("after: %d", count));
            return count;
        }
    }

    public int reduceAndGetter(){
        synchronized (this){
            count += 1;
            return count;
        }
    }
}
