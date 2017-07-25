package com.mercadolibre.galaxy.model.factory;

import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;

/**
 * Created by javier.sculli on 7/24/17.
 */
public class GalaxyFactory {

    public static Galaxy create(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        return new Galaxy(ferengi, betasoide, vulcano);
    }

}
