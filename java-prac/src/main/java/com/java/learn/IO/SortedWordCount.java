package com.java.learn.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author feifei
 * @Classname SortedWordCount
 * @Description TODO 计算单个单词在文本文件中出现的次数
 * @Date 2019/8/21 14:09
 * @Created by 陈群飞
 */
class Counter{
    private int i=1;
    int read(){
        return i;
    }
    void increment(){
        i++;
    }
}
public class SortedWordCount {
    private FileInputStream file;
    private StreamTokenizer st;
    private Hashtable counts=new Hashtable();

    SortedWordCount(String filename)throws FileNotFoundException {
        try{
            file=new FileInputStream(filename);
            st=new StreamTokenizer(file);
            st.ordinaryChar('.');//指出该字符没有特殊含义
            st.ordinaryChar('-');

        }catch (FileNotFoundException e){
            System.out.println("could not open "+filename);
            throw e;
        }
    }
    void cleanup(){
        try{
            file.close();

        }catch (IOException e){
            System.out.println("file.close() unsuccessful");
        }
    }

    void countWords(){
        try{
            while(st.nextToken()!=StreamTokenizer.TT_EOF){
                String s;
                switch (st.ttype){
                    case StreamTokenizer.TT_EOL:
                        s=new String("EOL");
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        s=Double.toString(st.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        s=st.sval;
                        break;
                        default:
                            s=String.valueOf((char) st.ttype);
                }
                if (counts.containsKey(s)){
                    ((Counter)counts.get(s)).increment();
                }else{
                    counts.put(s,new Counter());
                }


            }
        }catch (IOException e){
            System.out.println("st.nextToken() unsuccessful");
        }
    }

    Enumeration values(){
        return counts.elements();
    }

    Enumeration keys(){
        return counts.keys();
    }

    Counter getCounter(String s){
        return (Counter) counts.get(s);
    }

    Enumeration sortKeys(){
        Enumeration e=counts.keys();
        return e;
    }

    public static void main(String[] args) {
        try {
            SortedWordCount wc=new SortedWordCount(args[0]);
            wc.countWords();
            Enumeration keys=wc.sortKeys();
            while(keys.hasMoreElements()){
                String key=(String) keys.nextElement();
                System.out.println(key+":"+wc.getCounter(key).read());
            }
            wc.cleanup();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
