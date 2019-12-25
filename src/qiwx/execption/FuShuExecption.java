package qiwx.execption;

public class FuShuExecption extends Exception {
    private int value;

    public FuShuExecption() {
        super();
    }

    public FuShuExecption(String msg, int value) {
        super(msg);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
