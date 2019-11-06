package dynamicproxy;

public class Monitor {
    public static void begin(String method) {
        System.out.println("begin monitor" + method + "--" + System.currentTimeMillis());
    }

    public static void end(String method) {
        System.out.println("end monitor" + method + "--" + System.currentTimeMillis());
    }
}
