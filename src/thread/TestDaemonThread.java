package thread;

//测试守护线程，线程分为守护线程和用户线程
//jvm退出时，它会考虑所有用户线程是否执行完毕，是的话就退出。对于守护线程，jvm在退出时不会考虑它是否执行完毕。
//主线程执行完毕后，守护线程跟着结束
public class TestDaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println(Thread.currentThread());
                while (true) {
                    try {
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("我是子线程(用户线程)");
                }
            }
        });
        t1.setDaemon(true);
        t1.setName("t1");
        t1.start();
        // 相当于主线程
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            System.out.println("main:i:" + i);
        }
        System.out.println("主线程执行完毕。。。");
    }
}
