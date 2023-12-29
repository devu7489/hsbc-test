package com.hsbc.demo;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ReadWriteFile {
    public String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public void writeFile(String path, String context) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println(context);
        writer.close();
    }
}
