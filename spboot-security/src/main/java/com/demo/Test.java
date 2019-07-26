package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/7/25 19:09
 * @Created by ChenS
 */
public class Test {

    public static  void main(String[] args){
        String str="武汉市蔡甸区永安街古迹岗村陈家岭111号";
        String pa="/^.+(省|自治区).+(市|州).+(区|县).+(路|街|社区|大道).+(号|小区).+号楼.+单元.+(室|户)|.+(省|自治区).+(市|州).+(区|县).+(街|乡|镇).+村.+(屯|队|组).+号|.+(省|自治区).+(县|区).+(镇|乡).+村.+(组|屯).+号*$/";
        String par="/^.+(市|州).+(区|县).+(街|社区).+(村|小区).+号$/";
        //省市区街村号
        Pattern r=Pattern.compile(par);
        Matcher m=r.matcher(str);
        System.out.println(m.matches());
    }
}
