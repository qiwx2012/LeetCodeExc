package qiwx.deathlock;

public class MyDeadLock implements Runnable {
    public static Jerry jerry = new Jerry();
    public static Barry barry = new Barry();
    public boolean flag = false;

    @Override
    public void run() {
        if (flag) {
            synchronized (jerry) {
                jerry.say();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (barry) {
                    jerry.eat();
                }
            }
        } else {
            synchronized (barry) {
                barry.say();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (jerry) {
                    barry.eat();
                }

            }
        }


    }
}
