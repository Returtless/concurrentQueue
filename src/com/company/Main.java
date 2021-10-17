package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    private final static int COUNT_THREADS = 3;

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue<>();
	    Thread atc = new Thread(new ATC(queue));
	    atc.start();
        for (int i = 0; i < COUNT_THREADS; i++) {
            new Thread(new Specialist(queue)).start();
        }
    }
}
