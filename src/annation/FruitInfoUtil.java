package annation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FruitInfoUtil {
    public static void main(String[] args) {
        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvicer = "供应商信息：";
        Class cl = Apple.class;
        //获取Apple类所有属性
        Field[] fields = cl.getDeclaredFields();
        //获取Apple类所有public属性
        Field[] fields1=cl.getFields();
        try {
            Field field= cl.getDeclaredField("appleName");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //获取所有方法，但是不包括继承的方法
        Method[] methods1=cl.getDeclaredMethods();
        //获取public方法，包括继承类的公共方法
        Method[] methods=cl.getMethods();
        try {
            Method method=cl.getDeclaredMethod("setAppleName",String.class);
            method.setAccessible(true);
            method.invoke(cl.newInstance(),"fff");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取全部够早方法
       Constructor[] constructors= cl.getDeclaredConstructors();
        //获取public够早方法
       Constructor[] constructors1= cl.getConstructors();
        try {
            Constructor constructor=cl.getDeclaredConstructor(String.class,String.class);
            try {
                constructor.newInstance("香蕉","火龙果");
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Class[] cls= cl.getDeclaredClasses();
        Package pck=cl.getPackage();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = fruitName.value();
                System.out.println(strFruitName);

            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.adress();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
