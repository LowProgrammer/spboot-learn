package com.java.learn.IO;

import java.io.*;

/**
 * @author feifei
 * @Classname InFile
 * @Description TODO
 * @Date 2019/8/21 12:14
 * @Created by 陈群飞
 */
public class InFile extends DataInputStream {
    /**
     * Creates a DataInputStream that uses the specified
     * underlying InputStream.
     *
     * @param file the specified input stream
     */
    public InFile(File file)throws FileNotFoundException {
        this(file.getPath());
    }

    public InFile(String filename)throws FileNotFoundException {
        super(new BufferedInputStream(new FileInputStream(filename)));
    }

}
