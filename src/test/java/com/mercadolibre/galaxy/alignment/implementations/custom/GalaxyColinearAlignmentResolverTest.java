package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by javier.sculli on 7/20/17.
 */
public class GalaxyColinearAlignmentResolverTest {

    @Test
    public void test(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        boolean isGalaxyColinearllyAlignment = GalaxyColinearAlignmentResolver.execute(null, galaxy.getPlanets(), 90);

        Assert.assertEquals(true, isGalaxyColinearllyAlignment);

        isGalaxyColinearllyAlignment = GalaxyColinearAlignmentResolver.execute(null, galaxy.getPlanets(), 3);

        Assert.assertEquals(false, isGalaxyColinearllyAlignment);

        isGalaxyColinearllyAlignment = GalaxyColinearAlignmentResolver.execute(null, galaxy.getPlanets(), 180);

        Assert.assertEquals(true, isGalaxyColinearllyAlignment);
    }

}
