package com.goleb.wojciech;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static final String LOG_FILE_NAME = "workLog.dat";
    List<LocalDateTime> workLog = new ArrayList<>();

    public void updateLoginLog() {
        loadLogFromFile(LOG_FILE_NAME, workLog);
        workLog.add(LocalDateTime.now());
        saveLogToFile(LOG_FILE_NAME, workLog);
    }


    protected void saveLogToFile(String fileName, List<?> list) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            System.out.println("IOException while saving the log");
        }
    }

    public void loadLogFromFile(String fileName, List<?> list) {
        if (fileExist(fileName)) {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (List<LocalDateTime>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                System.out.println("error while loading the file");
            }
        } else {
            System.out.println(fileName + " not found");
        }
    }

    private boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public void resetLoginLog() {
        resetLog(LOG_FILE_NAME, workLog);
    }

    public void resetLog(String fileName, List<?> list) {
        list = new ArrayList<>();
        saveLogToFile(fileName,list);
    }
    public long numberOfLoginsThisYear() {
        long number = workLog.stream()
                .filter(dates -> dates.getYear() ==
                        LocalDateTime.now().getYear()
                ).count();
        return number;
    }
}
