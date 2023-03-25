package com.goleb.wojciech;

import java.util.Arrays;

public class ShapeCreator {
    public static PossibleShapes shapeChoice() {
        System.out.println("please select");
        for (PossibleShapes shape : PossibleShapes.values())
            System.out.println(shape);
        return PossibleShapes.valueOf(Input.getStringFromUser().toUpperCase());
    }
}
