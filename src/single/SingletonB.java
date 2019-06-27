package single;

public class SingletonB {
 private SingletonB(){
     System.out.println("SingletonB实例化");

 }
 public static SingletonB getInstance(){
     return SingletonHolder.instance;
 }
 private static class SingletonHolder{
     private static final SingletonB instance=new SingletonB();
 }
}
