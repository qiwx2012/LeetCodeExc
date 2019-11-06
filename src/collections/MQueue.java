package collections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue queue= new ArrayBlockingQueue(10);
        queue.add("fd");
    }
}
