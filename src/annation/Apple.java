package annation;

public class Apple {
    @FruitName("Apple")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;
    @FruitProvider(id=1,name ="红富士",adress = "陕西")
    private String applePrivicer;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
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

}
