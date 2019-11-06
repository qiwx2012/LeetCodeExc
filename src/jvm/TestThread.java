package jvm;

public class TestThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
