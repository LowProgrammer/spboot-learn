package com.demo.pracrtice;

import com.demo.model.Image;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * @Classname Practice
 * @Description TODO
 * @Date 2019/6/26 18:21
 * @Created by ChenS
 */
public class Practice {
    public static void permutation(char[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {//1
            return;
        }

        if (i == ss.length - 1) {//2
            System.out.println(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {//3
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);//4
                temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.//5
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }

    static Set<String> set = new HashSet<>();

    public static void selectCharacter(char[] str, int len, int pos) {
        if (pos == len - 1) {
            set.add(getStr(str, len));
            System.out.println(getStr(str, len));
        } else {
            for (int i = pos; i < len; i++) {
                swap(str, i, pos);
                selectCharacter(str, len, pos + 1);
                swap(str, i, pos);
            }
        }
    }

    public static void swap(char[] str, int left, int right) {
        char ch = str[left];
        str[left] = str[right];
        str[right] = ch;
    }

    public static String getStr(char[] str, int le) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < le; i++) {
            buffer.append(str[i]);
        }
        return buffer.toString();
    }

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        int len = tiles.length();


        selectCharacter(chars, len, 0);
        int count = set.size();
        for (int i = len; i > 1; i--) {
            Set<String> seet = new HashSet<>();
            for (String s : set) {
                String string = s.substring(0, i - 1);
                System.out.println("=====" + string);
                seet.add(string);
            }
            count += seet.size();
            System.out.println(seet.size());
            set = seet;
        }
        return count;
    }

    public List<Integer> pathInZigZagTree(int label) {
        int arr[] = new int[label];
        for (int i = 0; i < label; i++) {
            arr[i] = i + 1;
        }
        int lev = 0;
        int le_num = 1;
        int num = 0;


        List<Integer> list = null;
        return list;
    }

    public static void main(String args[]) {
        //permutation(new char[]{'a','b','c','d'},0);

//        char str[]=new char[]{'a','b','c','d'};
//        selectCharacter(str,4,0);
//        int count=set.size();
//        for (int i=4;i>1;i--){
//            Set<String> seet=new HashSet<>();
//            for (String s:set){
//                String string=s.substring(0,i-1);
//                System.out.println("====="+string);
//                seet.add(string);
//            }
//            count+=seet.size();
//            System.out.println(seet.size());
//            set=seet;
//        }
//        for (String s:set){
//            System.out.println(s);
//        }
//        System.out.println(count);


        /*
                Practice practice=new Practice();
        System.out.println(practice.numTilePossibilities("AAAAA"));

        Image i=new Image();
        Image j=new Image();
        i.setId(1);
        i.setId(2);

        i=j;

        i.setId(3);

        System.out.println(j.getId());

        System.out.println(1<<31);
        */

        class test {
            @Override
            public String toString() {
                return "test address:" + this;
            }
        }
        Vector v = new Vector();
        for (int i = 0; i < 10; i++) {
            v.addElement(new Practice());
        }
        System.out.println(v);
    }

    @Override
    public String toString() {
        return "test address:" + this;
    }
}
