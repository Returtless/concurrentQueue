package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Поток-АТС после запуска начинает генерировать несколько (например, 60) "звонков" раз в 1 секунду
 */
public class ATC implements Runnable {
    private final static int COUNTER = 2;
    private final static int COUNT_CALLS = 10;
    private final static int SECONDS = 1000;

    private final ConcurrentLinkedQueue<Call> queue;

    public ATC(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //цикл по количеству секунд для генерации звонков
        for (int i = 0; i < COUNTER; i++) {
            //цикл для генерации нескольких звонков
            for (int j = 0; j < COUNT_CALLS; j++) {
                queue.add(new Call());
            }
            try {
                //задержка на одну секунду
                //два цикла нужны чтобы каждую секунду в течение двух секунд генерировать по 10 звонков
                Thread.sleep(SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
