package com.goleb.wojciech;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    public static final String EXIT_KEYWORD1 = "YES";
    public static final String EXIT_KEYWORD2 = "EXIT";
    String clientName;
    static List<Figure> figureList = new ArrayList<>();
    public void start(){
        greetings();
        clientName =askForClientName();
        boolean doYouWantToExit = false;
        while(!doYouWantToExit) {
            FigureCreator figureCreator = new FigureCreator();
            PossibleShapes chosenShape = FigureCreator.shapeChoice();
            if (chosenShape==null){
                break;
            }
            Figure figure = figureCreator.createFigure(chosenShape);
            figureList.add(figure);
            doYouWantToExit=askIfFinished();
        }
        displayClientName();
        CastCalculator cc = new CastCalculator();
        for (int i = 0; i < figureList.size(); i++) {
            System.out.println(figureList.get(i).toString());
        }
        cc.calculationAndDisplay(figureList);
    }
    public void greetings(){
        System.out.println("hello");
    }
    public String askForClientName(){
        System.out.println("State Client's Name");
        return Input.getStringFromUser();
    }
    public void displayClientName(){
        System.out.println("Client: " +clientName);
    }
    public boolean askIfFinished(){
        System.out.println("Would you like to exit?");
        String wantsToExit = Input.getStringFromUser().toUpperCase();
        return (wantsToExit.equals(EXIT_KEYWORD1)  || wantsToExit.equals(EXIT_KEYWORD2));
    }

}
