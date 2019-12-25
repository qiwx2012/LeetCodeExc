package img;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiltImg1 {
    public static void main(String[] args) {
        String path = "java_test/name1.txt";
        String imgPath = "java_test/img";
        File namFile = new File(path);
        List<String> namesList = new ArrayList<String>();
        InputStream in = null;
        try {
            in = new FileInputStream(namFile);
            //按行读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = reader.readLine()) != null) {
                namesList.add(str);
            }
//            System.out.println(namesList.toString());
        } catch (Exception e) {

        }
        File imgFile = new File(imgPath);
        File[] files = imgFile.listFiles();
        for (File file : files) {
            String name = file.getName();
            name = name.substring(0, name.indexOf("."));
            if (namesList.contains(name)) {
                namesList.remove(name);
            }

        }
        for (int i = namesList.size() - 1; i >= 0; i--) {
            System.out.println("缺少图片" + namesList.get(i));
        }
    }
}
