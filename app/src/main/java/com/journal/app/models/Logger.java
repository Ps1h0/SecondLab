package com.journal.app.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public void createLog(String log) throws IOException {
        File logfile = new File("D:\\SecondLab\\app\\log.txt");
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("dd.MM.yyyy H:mm");
        String timelog = time.format(date);
        String text = timelog + ": "+ log + "\n";
        FileWriter fileWriter;
        fileWriter = new FileWriter(logfile,true);
        fileWriter.write(text);
        fileWriter.close();
    }
}
