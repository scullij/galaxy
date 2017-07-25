package com.mercadolibre.galaxy.model;

import com.mercadolibre.galaxy.geometry.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javier.sculli on 7/8/17.
 */
public class Galaxy {

    private Sun sun;
    private List<Planet> planets;

    public Galaxy(Planet... planets){
        this.sun = new Sun();
        this.planets = new ArrayList<Planet>();
        for (Planet p : planets) {
            this.planets.add(p);
        }
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public Sun getSun() {
        return sun;
    }
}
