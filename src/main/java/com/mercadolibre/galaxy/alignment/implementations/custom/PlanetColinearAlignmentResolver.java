package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.geometry.TrigonometryCalculator;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;

import java.util.List;

/**
 * Created by javier.sculli on 7/20/17.
 */
public class PlanetColinearAlignmentResolver {

    public static boolean execute(Sun sun, List<Planet> planets, int days) {

        double t;

        for (int day = days * 1000; day < (days + 1) * 1000; day++) {

            t = day / (double) 1000;

            if( arePlanetsInTheSameLine(sun, planets, t) ){
                return true;
            }

        }

        return false;
    }

    private static boolean arePlanetsInTheSameLine(Sun sun, List<Planet> planets, double day){

        double sunSlope = TrigonometryCalculator.getSlope(sun.getPosition(day), planets.get(0).getPosition(day));

        double slope1 = TrigonometryCalculator.getSlope(planets.get(0).getPosition(day), planets.get(1).getPosition(day));
        double slope2 = TrigonometryCalculator.getSlope(planets.get(1).getPosition(day), planets.get(2).getPosition(day));

        boolean isSunInTheSameLine = TrigonometryCalculator.equalSlopes(sunSlope, slope1);
        boolean arePlanetsInTheSameLine = TrigonometryCalculator.equalSlopes(slope1, slope2);

        return arePlanetsInTheSameLine && ! isSunInTheSameLine;
    }

}
