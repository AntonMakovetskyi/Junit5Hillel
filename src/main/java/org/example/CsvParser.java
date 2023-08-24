package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CsvParser {
    public static void main(String[] args) throws IOException {
        File userCsv = new File("files/userCsv.csv");
        List<String> csvLines = Files.readAllLines(userCsv.toPath());

        List<String> header = Arrays.asList(csvLines.get(0).split(","));

        List<Map<String, String>> usersList = new ArrayList<>();

        for (int i = 1; i < csvLines.size(); i++) {
            Map<String, String> userInfo = new HashMap<>();
            List<String> userData = Arrays.asList(csvLines.get(i).split(","));
            for(int j = 0; j < userData.size(); j++) {
                userInfo.put(header.get(j), userData.get(j));
            }
            usersList.add(userInfo);
        }

        System.out.println(usersList);

    }
}
