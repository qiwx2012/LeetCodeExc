package qiwx.deathlock;

public class DeathLockTest {
    public static void main(String[] args) {
        MyDeadLock t1=new MyDeadLock();
        MyDeadLock t2=new MyDeadLock();
        t1.flag=true;
        t2.flag=false;
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
