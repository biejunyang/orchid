package com.orchid.examples.nio;

public class Handler implements Runnable {


    @Override
    public void run() {
        System.out.println("current thread:"+Thread.currentThread().getName());

        try {
            System.out.println("start--------------------");
            Thread.sleep(20*1000);
            System.out.println("end--------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
