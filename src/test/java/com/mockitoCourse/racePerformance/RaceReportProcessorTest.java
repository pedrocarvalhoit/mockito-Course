package com.mockitoCourse.racePerformance;

import org.junit.jupiter.api.Test;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;

import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class RaceReportProcessorTest {

    @Test
    public void generateReportDriverFileThrowFileNotFound(){
        assertThrows(FileNotFoundException.class, () -> {
            RaceReportProcessor reportProcessor = new RaceReportProcessor();
            String driverFile = "driver.csv";
            String raceFile = "race.csv";
            reportProcessor.generateReport(driverFile, raceFile);
        });
    }

    @Test
    public void generateReportDriverFileThrowsFileNotFound() throws Exception{

        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/drivers.csv";
        String raceFile = "racePerformance/race.csv";

        catchException(reportProcessor).generateReport(driverFile, raceFile);

        assertTrue(caughtException() instanceof FileNotFoundException);

    }

    @Test
    public void generateReportDriverFileThrowFileNotFoundCatch(){
        catchException(new CatchExceptionCallable() {
            @Override
            public void call() throws Exception {
                RaceReportProcessor reportProcessor = new RaceReportProcessor();
                String driverFile = "driver.csv";
                String raceFile = "race.csv";
                reportProcessor.generateReport(driverFile, raceFile);
            }
        });

        Exception exception = caughtException();

        assertTrue(exception instanceof FileNotFoundException);
        }


}

