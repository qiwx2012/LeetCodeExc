package qiwx.demo;

public class TestStack {
    public static void main(String[] args) {
        rec(10);
    }
    private static void rec(int n){
        if(n>0){
            rec(n-1);
            rec(n-10);
        }
        System.out.println("N="+n);

    }
}
