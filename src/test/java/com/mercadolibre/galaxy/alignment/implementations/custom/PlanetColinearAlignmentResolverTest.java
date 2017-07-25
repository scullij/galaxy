package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.alignment.implementations.custom.PlanetColinearAlignmentResolver;
import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by javier.sculli on 7/20/17.
 */
public class PlanetColinearAlignmentResolverTest {

    @Test
    public void collinear_sun_and_planets_at_start_position_test(){

        Galaxy galaxy = galaxy();

        boolean arePlanetsColinearllyAlignment = PlanetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 0);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void collinear_sun_and_planets_test(){

        Galaxy galaxy = galaxy();

        boolean arePlanetsColinearllyAlignment = PlanetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 90);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void not_collinear_planets_test(){

        Galaxy galaxy = galaxy();

        boolean arePlanetsColinearllyAlignment = PlanetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 5);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void collinear_planets_test(){

        Galaxy galaxy = galaxy();

        for (int i = 0; i < 365; i++) {

            boolean arePlanetsColinearllyAlignment = PlanetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), i);

            if( arePlanetsColinearllyAlignment ){
                //System.out.println(i);
            }
        }

        //Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    private Galaxy galaxy(){
        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        return new Galaxy(ferengi, betasoide, vulcano);
    }

}
