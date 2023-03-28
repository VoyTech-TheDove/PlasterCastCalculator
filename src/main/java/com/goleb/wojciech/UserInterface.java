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
    final OrderRepository orderRepository = new OrderRepository();

    public void start() {
        printGreetings();
        updateLogsAndLastLoginDisplay();
        displayNumberOfLogsThisYear();
        askAndClearTheLoginLog();
        askAndCreateMonthlyReport();
        askAndAddAnOrder();
    }

    private void askAndCreateMonthlyReport() {
        System.out.println("Would you like to create a monthly Report?");
        if (askForConfirmation()) {
         orderRepository.monthlyOrderReport();
        }
    }

    private void askAndAddAnOrder() {
        System.out.println("Would you like to add an order?");
        if (askForConfirmation()) {
            newOrder();
        }
    }

    private void newOrder() {
        clientName = askForClientName();
        getFigureListFromUser();
        OrderService orderService = new OrderService();
        orderService.createOrderAndUpdateOrderLog(clientName, figureList);
        displayNewOrder();
        
    }

    private void displayNewOrder() {
        displayClientName();
        displayFigureList();
        CastCalculator castCalculator = new CastCalculator();
        castCalculator.calculationAndDisplay(figureList);
    }

    private void askAndClearTheLoginLog() {
        System.out.println("Would you like to clear the Login log?");
        if (askForConfirmation()) {
            repository.resetLoginLog();
        }
    }

    private static boolean askForConfirmation() {
        String wantsToClear = Input.getStringFromUser().toUpperCase();
        if (wantsToClear.equals(KEYWORD_1) || wantsToClear.equals(KEYWORD_2)) {
            return true;
        } else {
            return false;
        }
    }

    private void updateLogsAndLastLoginDisplay() {
        orderRepository.updateOrderLogFromFile();
        repository.updateLoginLog();
        lastLoginDisplay();
    }

    private void displayNumberOfLogsThisYear() {
        System.out.print("Number of logs this year: ");
        System.out.println(repository.numberOfLoginsThisYear());
    }

    private void lastLoginDisplay() {
        if (repository.workLog.size() > 1) {
            System.out.print("Last login: ");
            System.out.println(timeAsString(repository.workLog.get(repository.workLog.size() - 2)));
        } else {
            System.out.println("First time login");
        }
    }

    private static String todaysDateAsString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(dateFormat);
    }

    public static String timeAsString(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("hh:mm dd-MM-yyyy");
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
        return (wantsToExit.equals(KEYWORD_2)
                || wantsToExit.equals(KEYWORD_1)
                || wantsToExit.equals(EXIT_KEYWORD));
    }
}
