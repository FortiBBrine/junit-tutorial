package me.fortibrine.junit.line;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvLineCounter {

    public static long countLinesFromPath(Path path) throws IOException {
        return Files.lines(path).count();
    }

}
