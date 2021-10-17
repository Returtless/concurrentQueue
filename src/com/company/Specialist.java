package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Specialist implements Runnable{
    private final static int THREE_SECONDS = 3000;

    private ConcurrentLinkedQueue<Call> queue;

    public Specialist(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()){
            if (queue.poll() != null) {
                System.out.printf("%s отвечает на звонок\n", Thread.currentThread().getName());
                try {
                    Thread.sleep(THREE_SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
