package com.study.demo.concurrency;

/**
 * @Classname Signal
 * @Description 测试一下volatile
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/25
 */
public class Signal {

    private static volatile int signal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 100) {
                if (signal % 2 == 0) {
                    System.out.println("threadA: " + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 100) {
                if (signal % 2 == 1) {
                    System.out.println("threadB: " + signal);
                    signal = signal + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
//        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
