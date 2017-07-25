package com.mercadolibre.galaxy.alignment.implementations;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;

import java.util.List;

import static java.lang.Math.sin;

/**
 * Created by javier.sculli on 7/18/17.
 */
public class GenericAlignmentResolver implements AlignmentResolver {

    public AlignmentType getAlignment(Sun sun, List<Planet> planets, int days) {

        double r1 = planets.get(0).getRadio();
        double r2 = planets.get(1).getRadio();
        double r3 = planets.get(2).getRadio();
        double w1 = planets.get(0).getAngularSpeed();
        double w2 = planets.get(1).getAngularSpeed();
        double w3 = planets.get(2).getAngularSpeed();

        boolean aligned = false;
        double t = 0;

        for (int day = days * 1000; day < (days + 1) * 1000; day++) {

            t = day / (double) 1000;

            double slopes = r1 * r2 * sin((w2 - w1) * t) +
                    r2 * r3 * sin((w3 - w2) * t) +
                    r3 * r1 * sin((w1 - w3) * t);

            if (equal(slopes, 0)) {
                aligned = true;
                break;
            }
        }

        if (aligned) {
            double slope = getSlope(planets.get(0), planets.get(1), t);
            double sunSlope = getSlope(planets.get(0).getPosition(), planets.get(2).getPosition());

            if (equal(slope, sunSlope)) {
                return AlignmentType.ALL;
            }
            else {
                return AlignmentType.PLANETS;
            }
        }

        return AlignmentType.NONE;
    }

    private static boolean equal(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.0000001;
    }

    private static double getSlope(Planet pa, Planet pb, double days) {
        Coordinate a = pa.getPosition();
        Coordinate b = pb.getPosition();

        return getSlope(a, b);
    }

    private static double getSlope(Coordinate a, Coordinate b) {
        double num = b.getY() - a.getY();
        double den = b.getX() - a.getX();

        if (equal(den, 0)) {
            return Double.POSITIVE_INFINITY;
        }

        return num / den;
    }


}
