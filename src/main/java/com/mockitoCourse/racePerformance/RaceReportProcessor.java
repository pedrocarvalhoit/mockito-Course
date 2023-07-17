package com.mockitoCourse.racePerformance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RaceReportProcessor {

    public void generateReport(String driverFileLocation, String racePerformanceLocation) throws IOException, ClassNotFoundException {

        FileInputStream driverInputStream = new FileInputStream(driverFileLocation);
        List<Driver> driverList = readFileToObjectList(driverInputStream);

        FileInputStream racePerformanceInputSream = new FileInputStream(racePerformanceLocation);
        List<RacePerformance> racePerformanceList = readFileToObjectList(racePerformanceInputSream);

        //combines data
        combineDriverAndRaceToReport(driverList, racePerformanceList);
    }

    private void combineDriverAndRaceToReport(List<Driver> driverList, List<RacePerformance> racePerformanceList) {
        //combines two reports into one and saves
    }

    <T> List<T> readFileToObjectList(FileInputStream driverFile) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(driverFile);
        List<T> objectList = new ArrayList<>();
        while(ois.readObject() != null){
            objectList.add((T) ois.readObject());
        }
        return objectList;
    }

}
