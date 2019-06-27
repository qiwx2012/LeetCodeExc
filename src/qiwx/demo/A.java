package qiwx.demo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class A {
    public void print(){
        System.out.println("A print");
        ThreadLocal<Float>f=new ThreadLocal<>();
        WeakReference<String> wk=new WeakReference<String>("Hello");
        SoftReference<String> sr=new SoftReference<>("Soft");
        System.out.println(wk.get());
        sr.get();
    }
}
