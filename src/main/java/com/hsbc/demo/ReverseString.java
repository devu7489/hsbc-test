package com.hsbc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ReverseString {

    @Autowired
    ReadWriteFile readFile;

    public String reverserString() throws IOException {

        String content = readFile.readFile("src/main/resources/Input.txt");
        String temp = content.replace("\n", "").replace("\r", "");
        int n = temp.length();
        char[] reversedCharArr = new char[n];

        for(int i=0; i<n; i++) {
            reversedCharArr[i] = temp.charAt(n-i-1);
        }

        String output = new String(reversedCharArr);
        readFile.writeFile("src/main/resources/Output.txt", output);
        return output;
    }

}
