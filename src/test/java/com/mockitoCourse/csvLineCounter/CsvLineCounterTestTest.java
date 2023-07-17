package com.mockitoCourse.csvLineCounter;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class CsvLineCounterTestTest {

    //With this rule the folder wil be delected automactily
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void countLinesFromFileWithRule() throws IOException {
        temporaryFolder.create();
        File file = temporaryFolder.newFile("./test.csv");

        String csvData = "a,b,c\nd,e,f\ng";
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(csvData);
        bw.close();

        long actualLines = CsvLineCounter.countLinesFromFile(file.toPath());

        assertEquals(3, actualLines);

    }

    @Test
    void countLinesFromFileWithoutRule() throws IOException {
        File file = new File("./test.csv");

        //Deleting the file after test
        try {
            String csvData = "a,b,c\nd,e,f\ng";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(csvData);
            bw.close();

            long actualLines = CsvLineCounter.countLinesFromFile(file.toPath());

            assertEquals(3, actualLines);
        } finally {
            Files.delete(file.toPath());
        }
    }
}