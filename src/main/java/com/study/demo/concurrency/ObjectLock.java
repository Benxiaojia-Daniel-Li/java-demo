package com.study.demo.concurrency;

/**
 * @Classname ObjectLock
 * @Description 测试加上对象锁后线程如何运行
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/25
 */
public class ObjectLock {
    private static Object lock = new Object();

    static class ThreadA implements Runnable{
        @Override
        public void run(){
            synchronized(lock){
                for (int i = 0; i < 100; i++) {
                    System.out.println("ThreadA： " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run(){
            synchronized(lock){
                for (int i = 0; i < 100; i++) {
                    System.out.println("ThreadB： " + i);
                }
            }
        }
    }

    public static void main(String[] args) {

        // 加上对象锁，每次执行线程的顺序都确定
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }
}
