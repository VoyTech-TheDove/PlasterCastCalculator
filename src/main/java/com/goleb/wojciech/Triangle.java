package com.goleb.wojciech;

public class Triangle extends Figure {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    double calculateArea() {
        return base*height/2;
    }
    @Override
    public String toString (){
        return "Triangle with "+this.base+ "mm base and "+this.height+"mm height";
    }
}
