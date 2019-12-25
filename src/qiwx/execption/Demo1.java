package qiwx.execption;

public class Demo1 {
    int div(int a, int b) throws FuShuExecption {
        if (b < 0) {
            throw new FuShuExecption("出现了负数情况", b);
        }
        return a / b;
    }
}
