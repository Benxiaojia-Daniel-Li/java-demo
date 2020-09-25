package com.study.demo.concurrency;

/**
 * @Classname NoneLock
 * @Description 测试没有锁的时候线程如何运行
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/25
 */
public class NoneLock {

     static class ThreadA implements Runnable {
         @Override
         public void run(){
             for (int i = 0; i < 100; i++) {
                System.out.println("ThreadA： "+i);
             }
         }
     }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("ThreadB： " + i);
            }
        }
    }

    public static void main(String[] args) {

         // 每次执行线程的顺序都无法确定
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }

}
