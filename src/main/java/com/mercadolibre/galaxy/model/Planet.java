package com.mercadolibre.galaxy.model;

import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.geometry.TrigonometryCalculator;

/**
 * Created by javier.sculli on 7/8/17.
 */
public class Planet {

    private String name;
    private double angularSpeed;
    private Coordinate position;
    private double degrees;
    private double radio;

    public Planet(String name, double angularSpeed, Coordinate position, double radio) {
        this.name = name;
        this.angularSpeed = angularSpeed;
        this.position = position;
        this.radio = radio;
        this.degrees = 0;
    }

    public double getDegrees(double days){
        return days * angularSpeed;
    }

    public Coordinate getPosition(double days){
        return TrigonometryCalculator.point(radio, this.getDegrees(days));
    }

    public String getName() {
        return name;
    }

    public double getAngularSpeed() {
        return angularSpeed;
    }

    public Coordinate getPosition() {
        return position;
    }

    public double getDegrees() {
        return degrees % 360;
    }

    public double getAbsoluteDegrees(){
        return degrees;
    }

    public double getRadio() {
        return radio;
    }

}
