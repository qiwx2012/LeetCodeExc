package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MonitorHandler2 implements InvocationHandler {
    private Object target;
    public MonitorHandler2(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理2开始执行=====");
        Object object=method.invoke(target,args);
        System.out.println("代理2结束执行=====");
        return object;
    }
}
