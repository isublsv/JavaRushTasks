package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    private static class AmigoThreadFactory implements ThreadFactory {
        AtomicInteger integer=new AtomicInteger(1);
        AtomicInteger factoryNum=new AtomicInteger(1);
        static AtomicInteger factoryCount=new AtomicInteger(1);
        public AmigoThreadFactory() {
            factoryNum.set(factoryCount.getAndIncrement());
        }
        @Override
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            t.setName(t.getThreadGroup().getName()+"-pool-"+factoryNum+"-thread-"+integer.getAndIncrement());
            return t;
        }
    }
}
