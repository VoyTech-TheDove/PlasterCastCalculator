package com.goleb.wojciech;

public class FigureCreator {
    public static PossibleShapes shapeChoice() {
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

    public Figure createFigure(PossibleShapes shape) {
        switch (shape) {
            case CIRCLE:
                return createCircle();
            case SQUARE:
                return createSquare();
            case TRIANGLE:
                return createTriangle();
            default:
                return null;
        }
    }
    private Circle createCircle(){
        System.out.println("please enter circle radius");
        double radius =Input.getDoubleFromUser();
        return new Circle(radius);
    }
    private Triangle createTriangle(){
        System.out.println("please enter triangle base length");
        double base =Input.getDoubleFromUser();
        System.out.println("please enter triangle height");
        double height =Input.getDoubleFromUser();
        return new Triangle(base, height);
    }
    private Square createSquare(){
        System.out.println("please enter square width");
        double side =Input.getDoubleFromUser();
        return new Square(side);
    }
}

