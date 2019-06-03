package com.farmer.x.samples;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ReadTools {

    public void read(String fileName) {
        try {
            FileUtils.readFileToByteArray(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(String name, int age) {
        System.out.printf("My Name is %s and Age is %s \r\n", name, age);
    }
}
