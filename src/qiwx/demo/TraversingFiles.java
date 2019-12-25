package qiwx.demo;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

//遍历文件
public class TraversingFiles {
    public static void main(String[] args) {
        File file = new File("files");
        LinkedList<File> list = new LinkedList<>();
        list.addFirst(file);
        while (!list.isEmpty()) {
            File currentFile = list.pop();
            if (currentFile.isDirectory()) {
                File[] temp = currentFile.listFiles();
                for (File f : temp) {
                    list.addFirst(f);
                }
            } else {
                readFile(currentFile);
            }
        }

        LinkedList<Integer> test = new LinkedList<>();
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        test.addFirst(4);
        while (!test.isEmpty()) {
            System.out.println("=====" + test.pop());
        }

    }

    private static void readFile(File file) {
        try {
            InputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
