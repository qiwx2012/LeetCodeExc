package qiwx.demo;


import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private int age;
    private String sex;
    private String Adress;

//    public String getAdress() {
//        return Adress;
//    }
//
//    public void setAdress(String adress) {
//        Adress = adress;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
