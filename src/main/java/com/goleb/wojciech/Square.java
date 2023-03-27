package com.goleb.wojciech;

public class Square extends Figure {
    double side;

    public Square(double side) {
        this.side = side;
    }

    static Square create(){
        System.out.println("please enter square width");
        double side =Input.getDoubleFromUser();
        return new Square(side);
    }

    @Override
    double calculateArea() {
        return side * side;
    }
    @Override
    public String toString (){
        return "Square with "+this.side +"mm side";
    }
}
