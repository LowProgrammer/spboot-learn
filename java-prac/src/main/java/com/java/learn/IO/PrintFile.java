package com.java.learn.IO;

import java.io.*;

/**
 * @author feifei
 * @Classname PrintFile
 * @Description TODO
 * @Date 2019/8/21 12:19
 * @Created by 陈群飞
 */
public class PrintFile extends PrintStream {
    public PrintFile(String filename)throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filename)));
    }

    public PrintFile(File file) throws IOException{
        this(file.getPath());
    }
}
