package qiwx.demo.proxy;

public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("唱一首歌");
    }

    @Override
    public void sing2(String name) {
        System.out.println(name);
    }
}
