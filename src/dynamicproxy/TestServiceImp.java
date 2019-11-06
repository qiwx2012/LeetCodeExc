package dynamicproxy;

public class TestServiceImp implements TestService {
    @Override
    public void test1() {
        System.out.println("执行方法test1");

    }

    @Override
    public void test2() {
        System.out.println("执行方法test2");

    }

    @Override
    public void test3(String content) {
        System.out.println("参数："+ content);
    }
}
