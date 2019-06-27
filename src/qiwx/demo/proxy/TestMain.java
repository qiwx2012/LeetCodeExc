package qiwx.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMain {
    public static void main(String[] args) {
        ISinger singer=new Singer();
        ISinger prox=(ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  System.out.println("向观众问好");
                  method.invoke(singer,args);
                  System.out.println("向观众致谢");
                return null;
            }
        });
        prox.sing();
        prox.sing2("小星星");
    }
}
