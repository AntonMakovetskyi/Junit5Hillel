package org.example;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    public static void main(String[] args) throws IOException {
        Properties baseProp = new Properties();
        baseProp.load(new FileReader(new File("files/base.properties")));

        System.out.println(baseProp.getProperty("url"));
        System.out.println(baseProp.getProperty("user.name"));
        System.out.println(baseProp.getProperty("user.pass"));
    }


}
