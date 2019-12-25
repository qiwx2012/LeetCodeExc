package qiwx.demo;

import java.util.concurrent.*;

public class TestA {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
        a1.print();
        a2.print();
        ExecutorService es = new ThreadPoolExecutor(3, 8, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(19);
    }

}

