package com.goleb.wojciech;

public class Square extends Figure {
    double side;

    public Square(double side) {
        this.side = side;
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
