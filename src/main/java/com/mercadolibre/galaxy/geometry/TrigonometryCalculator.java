package com.mercadolibre.galaxy.geometry;

import javafx.geometry.Point2D;

/**
 * Created by javier.sculli on 7/10/17.
 */
public class TrigonometryCalculator {

    private static final double ERROR = 1.0E-14;
    private static final double SLOPE_ERROR = 1.0E-05;

    private static boolean equal(double d1, double d2) {
        return Math.abs(d1 - d2) < ERROR;
    }

    public static boolean equalSlopes(double slope1, double slope2){
        return Math.abs( Math.abs(slope1) - Math.abs(slope2) ) < SLOPE_ERROR;
    }

    public static double getSlope(Coordinate a, Coordinate b) {
        double num = b.getY() - a.getY();
        double den = b.getX() - a.getX();

        if (equal(den, 0)) {
            return Double.POSITIVE_INFINITY;
        }

        return num / den;
    }

    public static double cos(double degrees){
        double cos = Math.cos(Math.toRadians(degrees));
        if (Math.abs(cos) < ERROR)
            cos = 0;
        return cos;
    }

    public static double sin(double degrees){
        double cos = Math.sin(Math.toRadians(degrees));
        if (Math.abs(cos) < ERROR)
            cos = 0;
        return cos;
    }

    public static Coordinate point(double distanceToSun, double degrees){
        double x = distanceToSun * TrigonometryCalculator.cos(degrees);
        double y = distanceToSun * TrigonometryCalculator.sin(degrees);
        return new Coordinate(x,y);
    }
}
