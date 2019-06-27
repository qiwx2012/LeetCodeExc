package img;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiltImg {
    public static void main(String[] args) {
        String path ="java_test/name.txt";
        String imgPath="java_test/img";
        File namFile =new File(path);
        List<String> namesList=new ArrayList<String>();
        InputStream in=null;
        try {
            in=new FileInputStream(namFile);
            //按行读取
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str=reader.readLine())!=null) {
                namesList.add(str);
            }
            System.out.println(namesList.toString());
        } catch (Exception e) {

        }
        File imgFile=new File(imgPath);
        File[] files=imgFile.listFiles();
	/*	for(File file:files){
			String name=file.getName();
			int index=name.indexOf("_");
			if(index>0)
			name=name.substring(0,index);
			name="20170113400"+name;
			System.out.println(name);

		}*/
	    int size=files.length;
        int count=0;
	    for(int i=0;i<size;i++){
	        File file=files[i];
            String name=file.getName();
            String format=name.substring(name.indexOf("."));//取出图片后缀
            int index=name.indexOf("_");
            name=name.substring(0,index);
            name="20170113400"+name;
            System.out.println(name);

            //boolean isFind=false;
            for(int j=0;j<namesList.size();j++){
                String[] temp=namesList.get(j).split("\\s+");
                System.out.println(temp[0]+"-"+name);
                if(temp[0].equals(name)){
                   // isFind=true;
                    count++;
                    File newFile=new File(file.getParent()+file.separator+temp[2]+format);
                    file.renameTo(newFile);
                    break;
                }
            }
//            if(!isFind){
//                file.delete();
//            }

        }
        System.out.println("总数："+count);
	/*
        for(int i=0;i<size;i++){
            for(File file:files){
                String name=file.getName();
                String format=name.substring(name.indexOf("."));//取出图片后缀
                int index=name.indexOf("_");
                name=name.substring(0,index);
                name="20170113400"+name;
                System.out.println(name);
                if(namesList.contains(name)){
                    File newFile=new File(file.getParent()+file.separator+name+format);
                    file.renameTo(newFile);
                    namesList.remove(name);
                    continue;
                }else{
                    file.delete();

                }

            }
        }*/
        System.out.println("============================================");
        System.out.println(namesList.toString());
    }
}
