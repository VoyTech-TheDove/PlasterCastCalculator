package com.goleb.wojciech;

public class Circle extends Figure {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    static Circle create(){
        System.out.println("please enter circle radius");
        double radius =Input.getDoubleFromUser();
        return new Circle(radius);
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
