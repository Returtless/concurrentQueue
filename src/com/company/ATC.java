package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC implements Runnable{
    private final static int COUNTER = 2;
    private final static int COUNT_CALLS = 10;
    private final static int SECONDS = 1000;

    private ConcurrentLinkedQueue<Call> queue;

    public ATC(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNTER; i++) {
            for (int j = 0; j < COUNT_CALLS; j++) {
                queue.add(new Call());
            }
            try {
                Thread.sleep(SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
