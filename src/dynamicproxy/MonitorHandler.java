package dynamicproxy;

import javax.swing.table.TableRowSorter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MonitorHandler implements InvocationHandler {

    private Object target;
    public MonitorHandler(Object target){
        this.target=target;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         Monitor.begin(target.getClass().getSimpleName()+method.getName());
         Object object=method.invoke(target,args);
         if(args!=null&&args.length>0){
             for (Object o:args
                  ) {
                 System.out.println("动态代理商调取方法时等参数："+o);

             }
         }
         Monitor.end(target.getClass().getSimpleName()+method.getName());
        return object;
    }


}
