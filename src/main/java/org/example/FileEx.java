package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("files/file1.txt");

//        FileReader fileReader = new FileReader(file);
//        fileReader.
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> fileLines = Files.readAllLines(file.toPath());
       System.out.println(fileLines);

       fileLines.clear();

       fileLines.add("test4");
       fileLines.add("test5");
       fileLines.add("test6");

       Files.write(file.toPath(), fileLines);
    }
}
