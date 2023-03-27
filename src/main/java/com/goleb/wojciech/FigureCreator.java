package com.goleb.wojciech;

public class FigureCreator {
    public static PossibleShapes userChooseShape() {
        System.out.println("please select");
        for (PossibleShapes shape : PossibleShapes.values())
            System.out.println(shape);
        try {
            return PossibleShapes.valueOf(Input.getStringFromUser().toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("incorrect input");
            return null;
        }

    }

    public static Figure createFigure(PossibleShapes shape) {
        switch (shape) {
            case CIRCLE:
                return Circle.create();
            case SQUARE:
                return Square.create();
            case TRIANGLE:
                return Triangle.create();
            default:
                return null;
        }
    }

}

