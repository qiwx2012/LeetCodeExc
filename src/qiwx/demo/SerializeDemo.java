package qiwx.demo;

import java.io.*;

//序列化
public class SerializeDemo {

    public static void main(String[] args) throws Exception {
        serilizePerson();
        System.out.println(deserilizePerson().getName());


    }

    private static void serilizePerson() throws Exception {
        Person person = new Person();
        person.setAge(20);
        person.setName("jhon");
        person.setSex("male");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("E:/java_test/Person.txt"));
        oo.writeObject(person);
        oo.close();
    }
    private static Person deserilizePerson() throws Exception{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:/java_test/Person.txt"));
        Person person=(Person)ois.readObject();
        return person;


    }

}
