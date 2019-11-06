package collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//定义个篮子
public class Basket {
    BlockingQueue<String> busket=new ArrayBlockingQueue<>(3);
    private int i;
    //生产苹果
    public void produce() throws InterruptedException{
        //put放入一个苹果，若basket满了，等到basket有位置
        busket.offer("苹果"+i);
    }
    //消费苹果
    public String consume() throws InterruptedException{
        //get 取出一个苹果，若busket为空，等到busket有为止
        return busket.take();
    }
    //获取篮子里苹果数
    public int getAppleNum(){
        return busket.size();
    }
    public static void testBasket(){
        final Basket basket=new Basket();

        class Producer implements Runnable{
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("生产者准备生产苹果:"+System.currentTimeMillis());
                        basket.produce();
                        System.out.println("生产者生产苹果完毕："+System.currentTimeMillis());
                        System.out.println("现在苹果数量："+basket.getAppleNum()+"个");
                        Thread.sleep(300);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        class Consumer implements Runnable{
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("生产者准备消费苹果:"+System.currentTimeMillis());
                        basket.consume();
                        System.out.println("生产者消费完毕："+System.currentTimeMillis());
                        System.out.println("现在苹果数量："+basket.getAppleNum()+"个");
                        Thread.sleep(1000);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        ExecutorService executorService=Executors.newCachedThreadPool();
        Producer producer=new Producer();
        Consumer consumer=new Consumer();
        executorService.submit(producer);
        executorService.submit(consumer);
        //程序执行10秒后结束
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }

    public static void main(String[] args) {
        testBasket();
    }
}
