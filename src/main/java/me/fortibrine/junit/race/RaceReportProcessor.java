package me.fortibrine.junit.race;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class RaceReportProcessor {

    public void generateReport(String driverFileLocation, String racePerfomanceLocation) throws Exception {
        FileInputStream driverInputStream = new FileInputStream(driverFileLocation);
        List<Driver> driverList = readFileToObjectList(driverInputStream);

        FileInputStream racePerfomanceInputStream = new FileInputStream(racePerfomanceLocation);
        List<RacePerfomance> racePerfomanceList = readFileToObjectList(racePerfomanceInputStream);

        combineDriverAndRaceToReport(driverList, racePerfomanceList);
    }

    private <T> List<T> readFileToObjectList(FileInputStream stream) {
        return new ArrayList<>();
    }

    private void combineDriverAndRaceToReport(List<Driver> driverList, List<RacePerfomance> racePerfomanceList) {
        // some logic
    }



}
