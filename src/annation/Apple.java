package annation;

import java.sql.SQLSyntaxErrorException;

public class Apple {
    @FruitName("Apple")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    public String appleColor;
    @FruitProvider(id = 1, name = "红富士", adress = "陕西")
    public String applePrivicer;

    private String getAppleName() {
        return appleName;
    }

    private void setAppleName(String appleName) {
        this.appleName = appleName;
        System.out.print("setAppleName:"+appleName);
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getApplePrivicer() {
        return applePrivicer;
    }

    public void setApplePrivicer(String applePrivicer) {
        this.applePrivicer = applePrivicer;
    }

    public Apple(String st1,String st2){
        System.out.println("====");
        System.out.println(st1+"-"+st2);

    }
    public Apple(String st1){

    }
    private Apple(int a,int b){

    }

}
