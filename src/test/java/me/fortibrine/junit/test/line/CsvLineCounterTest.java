package me.fortibrine.junit.test.line;

import me.fortibrine.junit.line.CsvLineCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvLineCounterTest {

//    @Test
//    public void countLines() throws IOException {
//        File file = new File("./test.csv");
//
//        try {
//            String csvData = "a,b,c\nd,e,f\ng";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write(csvData);
//            writer.close();
//
//            long actualLines = CsvLineCounter.countLinesFromPath(file.toPath());
//
//            assertEquals(3, actualLines);
//        } finally {
//            Files.delete(file.toPath());
//        }
//
//    }

    // DELETED AFTER MIGRATION OF JUNIT 4 TO JUNIT 5
//    @Rule
//    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @TempDir
    private File temporaryFolder;

    @Test
    public void countLines() throws IOException {
        File file = new File(temporaryFolder, "test.csv");

        String csvData = "a,b,c\nd,e,f\ng";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(csvData);
        writer.close();

        long actualLines = CsvLineCounter.countLinesFromPath(file.toPath());

        assertEquals(3, actualLines);

    }

}
