package thread;

import java.lang.reflect.Method;

public class TestReturn {
    public static void main(String[] args) {
        new TestReturn().test1();
    }

    public void test1() {
//        doNothing();
        System.out.println("test1");
    }

    public void doNothing(Method method) {

        return;
    }
}
