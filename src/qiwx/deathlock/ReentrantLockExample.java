package qiwx.deathlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    int a=0;
    ReentrantLock lock=new ReentrantLock();
    private void writer(){
        lock.lock();
        try {
            a++;
        }finally {
            lock.unlock();
        }
    }
    private void reader(){
        lock.lock();
        try {
            int i=a;
        }finally {
            lock.unlock();
        }
    }

}
