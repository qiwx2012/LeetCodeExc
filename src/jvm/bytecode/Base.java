package jvm.bytecode;

//字节码增强,实现在输出"process"之前加上"start"，之后加上"end"
public class Base {
    public void process() {
        System.out.println("process");
    }
}
