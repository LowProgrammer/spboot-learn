package com.java.learn.IO;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * @author feifei
 * @Classname AnalyzeSentence
 * @Description TODO
 * @Date 2019/8/21 14:45
 * @Created by 陈群飞
 */
public class AnalyzeSentence {
    public static void main(String[] args) {
        analyze("I am happy about this");
        analyze("I am not happy about this");
    }
    static StringTokenizer st;
    static void analyze(String s){
        prt("\n new sentence >>"+s);
        boolean sad=false;
        st=new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String token=next();

            if (!token.equals("I")&&!token.equals("Are")){
                continue;
            }
            if (token.equals("I")){
                String tk2=next();
                if(!tk2.equals("am")){
                    break;
                }else{
                    String tk3=next();
                    if (tk3.equals("sad")){
                        sad=true;
                        break;
                    }
                    if (tk3.equals("not")){
                        String tk4=next();
                        if(tk4.equals("sad")){
                            break;
                        }
                        if (tk4.equals("happy")){
                            sad=true;
                            break;
                        }
                    }
                }
            }
            if (token.equals("Are")){
                String tk2=next();
                if (!tk2.equals("you")){
                    break;
                }
                String tk3=next();
                if(tk3.equals("sad")){
                    sad=true;
                }
                break;
            }
        }
        if (sad){
            prt("SAD");
        }
    }
    static String next(){
        if (st.hasMoreTokens()){
            String s= st.nextToken();
            prt(s);
            return s;
        }else{
            return "";
        }
    }
    static void prt(String s){
        System.out.println(s);
    }
}
