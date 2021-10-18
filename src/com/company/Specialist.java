package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Specialist implements Runnable {
    private final static int THREE_SECONDS = 3000;

    private final ConcurrentLinkedQueue<Call> queue;

    public Specialist(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //если в очереди присутствует звонок - принимаем его
        while (queue.poll() != null) {
            System.out.printf("%s отвечает на звонок\n", Thread.currentThread().getName());
            try {
                Thread.sleep(THREE_SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
