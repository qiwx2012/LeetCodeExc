package com.qiwx.test;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-17 11:38
 * 对象引用
 **/
public class TestObjReference {
    public static void main(String[] args) {
        CommonUtil commonUtil=new CommonUtil();

        User user1 =  commonUtil.getUser();
        System.out.println("初次获取"+user1.getName());
        commonUtil.setUser(new User("小红"));
        System.out.println("修改后"+user1.getName());
        System.out.println("修改后"+commonUtil.getUser().getName());

    }


}


class CommonUtil {
    User user = null;


    public  User getUser() {
        if(user==null){
            user=new User("小明");
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
