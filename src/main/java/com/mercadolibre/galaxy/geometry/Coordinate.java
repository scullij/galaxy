package com.mercadolibre.galaxy.geometry;

/**
 * Created by javier.sculli on 7/10/17.
 */
public class Coordinate {

    // state data for a coordinate pair (x, y)
    private double x;
    private double y;

    // constructs a point from specified coordinate values
    public Coordinate(double newX, double newY) {
        x = newX;
        y = newY;
    }

    // access x value
    public double getX() {
        return x;
    }

    // access y value
    public double getY() {
        return y;
    }

    // calculates distance between target and this point
    public double distanceTo(Coordinate target) {
        double deltaX = x - target.getX();
        double deltaY = y - target.getY();
        double hypotSquared = (deltaX * deltaX) + (deltaY * deltaY);
        return (Math.sqrt(hypotSquared));
    }

    // pretty-prints the coordinate pair
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }

}
