package qiwx.execption;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        Demo1 demo1=new Demo1();
        try {
            demo1.div(1,-1);
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
