package com.goleb.wojciech;

public class Square extends Shape {
    long side;

    public Square(long side) {
        this.side = side;
    }
    @Override
    long calculateArea() {
        return side*side;
    }
}
