package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private AtomicInteger firstJobDone = new AtomicInteger();
    private AtomicInteger secondJobDone = new AtomicInteger();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }
    public void second(Runnable printSecond) throws InterruptedException{
        while (firstJobDone.get()!=1){

        }
        printSecond.run();
        secondJobDone.incrementAndGet();
    }
    public void third(Runnable printThird) throws InterruptedException{
        while (secondJobDone.incrementAndGet()!=1){

        }
        printThird.run();
    }
}
