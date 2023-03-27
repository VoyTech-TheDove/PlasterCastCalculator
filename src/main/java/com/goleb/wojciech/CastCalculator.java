package com.goleb.wojciech;


import java.util.List;

public class CastCalculator {
    private static final double PLASTER_COST_PER_LITTER = 3;
    private static final double PLASTER_THICKNESS_IN_MM = 5;
    private static final String CURRENCY = "zl";
    private static final double AREA_CORRECTION_MM2_IN_CM2 = 100;
    private static final double VOLUME_CORRECTION_MM3_IN_LITER = 1000000;
    public void calculationAndDisplay (List<? extends Figure> shapes){
        double areaInMM2=calculateTotalAreaInMM2(shapes);
        displayTotalAreaInCM2String(areaInMM2);
        double plasterVolume = calculateVolumeInLiters(areaInMM2);
        displayTotalVolumeInLiters(plasterVolume);
        displayPlasterCost(calculatePlasterCost(plasterVolume));
    }
    private double calculateTotalAreaInMM2(List<? extends Figure> figures){
        double totalArea =0;
        for (Figure figure : figures) {
            totalArea += figure.calculateArea();
        }
        return totalArea;
    }
    private void displayTotalAreaInCM2String(double totalAreaInMM2){
        double totalAreaInCM2 = totalAreaInMM2 / AREA_CORRECTION_MM2_IN_CM2;
        System.out.printf("Total cast area is %.2fcm2\n",totalAreaInCM2);
    }
    private void displayTotalVolumeInLiters(double totalVolumeInLiters){
        System.out.printf("Total plaster volume is %.2f liters\n", totalVolumeInLiters);
    }
    private void displayPlasterCost(double plasterCost){
        System.out.printf("Total plaster cost is %.2fzl\n", plasterCost);
    }
    private double calculateVolumeInLiters(double totalAreaInMM2){
        return (totalAreaInMM2*PLASTER_THICKNESS_IN_MM/VOLUME_CORRECTION_MM3_IN_LITER);
    }
    private double calculatePlasterCost (double plasterVolume){
        return plasterVolume*PLASTER_COST_PER_LITTER;
    }

}
