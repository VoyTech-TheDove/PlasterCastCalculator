package com.goleb.wojciech;

public class Main {
    public static void main(String[] args) {
        PossibleShapes shape= ShapeCreator.shapeChoice();
        System.out.println(shape.toString());

    }
}