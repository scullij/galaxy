package com.mercadolibre.galaxy.forecast;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.geometry.Triangle;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by javier.sculli on 7/20/17.
 */

@Service
public class ForecastService {

    @Autowired
    private AlignmentResolver alignmentResolver;

    private double maxPerimeter;
    private int maxPerimeterDay;

    @Autowired
    public ForecastService(AlignmentResolver alignmentResolver) {
        this.alignmentResolver = alignmentResolver;
        this.maxPerimeter = 0;
    }

    public Forecast calculate(Galaxy galaxy, int day){

        Sun sun = galaxy.getSun();
        List<Planet> planets = galaxy.getPlanets();

        AlignmentType alignment = alignmentResolver.getAlignment(sun, planets, (day));

        switch (alignment) {
            case NONE:

                Triangle triangle = getPlanetsTriangle(planets, day);

                if( triangle.contains( sun.getPosition() ) ){

                    if( triangle.getPerimeter() > maxPerimeter ){
                        maxPerimeter = triangle.getPerimeter();
                        maxPerimeterDay = day;
                    }

                    return Forecast.RAINY;
                }

                return Forecast.NORMAL;
            case PLANETS:
                return Forecast.OPTIMAL;
            case ALL:
                return Forecast.DROUGHT;

            default:
                return Forecast.NORMAL;
        }

    }

    private Triangle getPlanetsTriangle(List<Planet> planets, int day){

        List<Coordinate> positions = planets.stream().map(p -> p.getPosition(day)).collect(Collectors.toList());

        return new Triangle(positions.get(0), positions.get(1), positions.get(2));
    }

    public double getMaxPerimeter() {
        return maxPerimeter;
    }

    public int getMaxPerimeterDay() {
        return maxPerimeterDay;
    }
}
