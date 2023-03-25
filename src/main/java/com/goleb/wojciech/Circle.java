package com.goleb.wojciech;

public class Circle extends Figure {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return (Math.PI*radius*radius);
    }
    @Override
    public String toString (){
        return "Circle with: "+this.radius+ "mm radius";
    }
}
