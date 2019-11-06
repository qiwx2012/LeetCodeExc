package jvm;

public class TestGC {
    public static void main(String[] args) {
        ObjA objA=new ObjA();
        ObjB objB=new ObjB();
//        objA.instance=objB;
//        objB.instance=objA;
        objA=null;
        objB=null;
        System.gc();
    }
}
