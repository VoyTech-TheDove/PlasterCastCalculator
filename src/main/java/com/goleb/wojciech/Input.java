package com.goleb.wojciech;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static long getLongFromUser(){
        return getLongFromString(getStringFromUser());
    }
    public static long getLongFromString(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
            return 0;
        }
    }

    public static String getStringFromUser() {
        return SCANNER.nextLine();
    }

}
