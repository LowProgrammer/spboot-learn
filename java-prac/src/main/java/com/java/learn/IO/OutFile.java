package com.java.learn.IO;

import java.io.*;

/**
 * @author feifei
 * @Classname OutFile
 * @Description TODO
 * @Date 2019/8/21 12:21
 * @Created by 陈群飞
 */
public class OutFile extends DataOutputStream {
    public OutFile(String filenama)throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filenama)));
    }

    public OutFile(File file)throws IOException{
        this(file.getPath());
    }
}
