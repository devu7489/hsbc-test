package com.hsbc.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.io.IOException;

@SpringBootTest
@ActiveProfiles("test")
public class ReadFileTest {

    @Mock
    ReadWriteFile readFile;

    @InjectMocks
    ReverseString readFileService;

    @Test
    void whenStringProvided_thenReverseIt() throws IOException {
        Mockito.when(readFile.readFile("src/main/resources/Input.txt")).thenReturn("SOMETEXTPP");
        String output = readFileService.reverserString();
        Assert.isTrue(output.equals("PPTXETEMOS"), "Text not reversing");
    }
}
