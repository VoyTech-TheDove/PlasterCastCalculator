package com.goleb.wojciech;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    String userName;
    List<PossibleShapes> shapeList = new ArrayList<>();
    public void start(){
        greetings();
        userName=askForClientName();



    }
    public void greetings(){
        System.out.println("hello");
    }
    public String askForClientName(){
        System.out.println("State Client's Name");
        return Input.getStringFromUser();
    }

}
