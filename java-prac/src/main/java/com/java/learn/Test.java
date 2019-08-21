package com.java.learn;

import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author feifei
 * @Classname Test
 * @Description TODO
 * @Date 2019/8/19 14:31
 * @Created by 陈群飞
 */
public class Test {
    public static void main(String[] args) {
        String dat="   1";
        System.out.println(dat.trim());
        System.out.println(!"".equals(""));

        try{
            File file=new File(".");
            String[] list;
            if(args.length==0){
                list=file.list();
            }else{
                list=file.list(new FileFilter(args[0]));
            }
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
class FileFilter implements FilenameFilter {
    String afn;
    FileFilter(String afn){
        this.afn=afn;
    }
    @Override
    public boolean accept(File dir, String name) {
        String f=new File(name).getName();

        return f.indexOf(afn)!=-1;
    }
}
