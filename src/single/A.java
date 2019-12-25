package single;

public class A {
    public A() {
        System.out.println("A Create");
    }

    static {
        int i = 0;
        System.out.println("static 代码块执行");
    }

    public static class B {
        public B() {
            System.out.println("B Create");
        }

        public static void addNum() {
            System.out.println("调用静态内部类的静态方法");
        }

    }

    class C {
        public C() {
            System.out.println("C Create");
        }
    }
}
