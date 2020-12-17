package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池
public class TestExecutors {
    public static void main(String[] args) {
      ExecutorService executorService= Executors.newFixedThreadPool(10);
    }

}
