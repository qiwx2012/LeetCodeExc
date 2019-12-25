package thread;

public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + "-" + i);

                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + "-" + i);
                    if (i == 5) {
                        try {
                            t1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        });
        t2.setName("t2");
        t1.setName("t1");
        t2.start();
        t1.start();
    }
}
