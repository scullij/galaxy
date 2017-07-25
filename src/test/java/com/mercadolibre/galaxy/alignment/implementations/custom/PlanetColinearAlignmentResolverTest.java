package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Sun;
import com.mercadolibre.galaxy.model.factory.GalaxyFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by javier.sculli on 7/20/17.
 */
public class PlanetColinearAlignmentResolverTest {

    private Galaxy galaxy = GalaxyFactory.create();
    private PlanetColinearAlignmentResolver planetColinearAlignmentResolver = new PlanetColinearAlignmentResolver();

    @Test
    public void collinear_sun_and_planets_at_start_position_test(){

        boolean arePlanetsColinearllyAlignment = planetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 0);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void collinear_sun_and_planets_test(){

        boolean arePlanetsColinearllyAlignment = planetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 90);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void not_collinear_planets_test(){

        boolean arePlanetsColinearllyAlignment = planetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), 5);

        Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

    @Test
    public void collinear_planets_test(){

        for (int i = 0; i < 365; i++) {

            boolean arePlanetsColinearllyAlignment = planetColinearAlignmentResolver.execute(new Sun(), galaxy.getPlanets(), i);

            if( arePlanetsColinearllyAlignment ){
                //System.out.println(i);
            }
        }

        //Assert.assertEquals(false, arePlanetsColinearllyAlignment);
    }

}
