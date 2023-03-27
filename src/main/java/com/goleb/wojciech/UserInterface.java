package com.goleb.wojciech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {


    private static final String KEYWORD_1 = "YES";
    private static final String KEYWORD_2 = "Y";
    private static final String EXIT_KEYWORD = "EXIT";
    private String clientName;
    private final List<Figure> figureList = new ArrayList<>();
    final Repository repository = new Repository();

    public void start() {

        printGreetings();
        updateLogAndLastLoginDisplay();
        displayNumberOfLogsThisYear();
        askToClearTheLog();
        clientName = askForClientName();
        getFigureListFromUser();
        displayClientName();
        displayFigureList();
        CastCalculator castCalculator = new CastCalculator();
        castCalculator.calculationAndDisplay(figureList);
    }

    private void askToClearTheLog() {
        System.out.println("Would you like to clear the log?");
        String wantsToClear = Input.getStringFromUser().toUpperCase();
        if(wantsToClear.equals(KEYWORD_1)||wantsToClear.equals(KEYWORD_2)) {
            repository.resetLog();
        }
    }

    private void updateLogAndLastLoginDisplay() {
        repository.updateLog();
        lastLoginDisplay();
    }

    private void displayNumberOfLogsThisYear() {
        System.out.print("Number of logs this year: ");
        System.out.println(repository.numberOfLogsThisYear());
    }

    private void lastLoginDisplay() {
        if(repository.workLog.size()>1) {
            System.out.print("Last login: ");
            System.out.println(timeAsString(repository.workLog.get(repository.workLog.size() - 2)));
        }else{
            System.out.println("First time login");
        }
    }

    private static String todaysDateAsString() {
        LocalDateTime now =LocalDateTime.now();
        DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(dateFormat);
    }
    private static String timeAsString(LocalDateTime time) {
        DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("hh:mm dd-MM-yyyy");
        return time.format(dateFormat);
    }


    private void displayFigureList() {
        for (Figure figure : figureList) {
            System.out.println(figure);
        }
    }

    private void getFigureListFromUser() {
        boolean doYouWantToExit = false;
        while (!doYouWantToExit) {
            PossibleShapes chosenShape = FigureCreator.userChooseShape();
            if (chosenShape == null) {
                break;
            }
            Figure figure = FigureCreator.createFigure(chosenShape);
            figureList.add(figure);
            doYouWantToExit = askIfFinished();
        }
    }

    public void printGreetings() {
        System.out.println("hello");
        System.out.println("It's " + todaysDateAsString());
    }

    public String askForClientName() {
        System.out.println("State Client's Name");
        return Input.getStringFromUser();
    }

    public void displayClientName() {
        System.out.println("Client: " + clientName);
    }

    public boolean askIfFinished() {
        System.out.println("Would you like to exit?");
        String wantsToExit = Input.getStringFromUser().toUpperCase();
        return (wantsToExit.equals(KEYWORD_2) || wantsToExit.equals(EXIT_KEYWORD));
    }

}
