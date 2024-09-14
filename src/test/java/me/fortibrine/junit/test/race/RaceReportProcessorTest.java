package me.fortibrine.junit.test.race;

import me.fortibrine.junit.race.RaceReportProcessor;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaceReportProcessorTest {

    @Test
    public void generateReportDriverFileThrowsFileNotFound() throws Exception {
        RaceReportProcessor processor = new RaceReportProcessor();
        String driverFile = "drivers/driver.csv";
        String raceFile = "racePerfomance/race.csv";
//        processor.generateReport(driverFile, raceFile);

        // JUST FOR ME IT'S DEPRECATED FEATURE, JUST USE assertThrows
        // catchException(processor).generateReport(driverFile, raceFile);
        // caughtException() isntanceof FileNotFoundException

        assertThrows(
                FileNotFoundException.class,
                () -> processor.generateReport(driverFile, raceFile)
        );
    }

}
