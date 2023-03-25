package com.goleb.wojciech;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static double getDoubleFromUser(){
        return getDoubleFromString(getStringFromUser());
    }
    public static double getDoubleFromString(String string) {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
            return 0;
        }
    }
    public static String getStringFromUser() {
        return SCANNER.nextLine();
    }
}
