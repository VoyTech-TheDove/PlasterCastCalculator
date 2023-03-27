package com.goleb.wojciech;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    public static final String LOG_FILE_NAME = "workLog.txt";
    List<LocalDateTime> workLog = new ArrayList<>();

    public void updateLog() {
        loadLogFromFile();
        workLog.add(LocalDateTime.now());
        saveLogToFile();
    }


    private void saveLogToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(LOG_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(workLog);
            oos.close();
        } catch (IOException e) {
            System.out.println("IOException while saving the log");
        }
    }

    private void loadLogFromFile() {
        if (fileExist(LOG_FILE_NAME)) {
            try {
                FileInputStream fis = new FileInputStream(LOG_FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                workLog = (List<LocalDateTime>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                System.out.println("error while loading the file");
            }
        } else {
            System.out.println(LOG_FILE_NAME +" not found");
        }
    }

    private boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public void resetLog() {
        workLog = new ArrayList<>();
        saveLogToFile();
    }

    public long numberOfLogsThisYear() {
        long number = workLog.stream()
                .filter(dates -> dates.getYear() ==
                        LocalDateTime.now().getYear()
                ).count();
        return number;
    }
}
