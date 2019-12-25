package dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        TestServiceImp testServiceImp = new TestServiceImp();
        MonitorHandler monitorHandler = new MonitorHandler(testServiceImp);


        TestService proxy = (TestService) Proxy.newProxyInstance(testServiceImp.getClass().getClassLoader(), testServiceImp.getClass().getInterfaces(), monitorHandler);
        MonitorHandler2 monitorHandler2 = new MonitorHandler2(proxy);
        proxy = (TestService) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), proxy.getClass().getInterfaces(), monitorHandler2);
        proxy.test1();
        proxy.test2();
        // proxy.test3("你好");
    }
}
