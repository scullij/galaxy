package com.mercadolibre.galaxy.alignment.implementations;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.junit.Assert;
import org.junit.Ignore;

/**
 * Created by javier.sculli on 7/18/17.
 */
public class GenericAlignmentResolverTest {

    private AlignmentResolver alignmentResolver = new GenericAlignmentResolver();

    @Ignore
    public void all_alignment_test(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        AlignmentType alignment = alignmentResolver.getAlignment(new Sun(), galaxy.getPlanets(), 90);
        Assert.assertEquals(AlignmentType.ALL, alignment);
    }

    @Ignore
    public void none_alignment_test(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 2, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", 3, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        AlignmentType alignment = alignmentResolver.getAlignment(new Sun(), galaxy.getPlanets(), 1);

        Assert.assertEquals(AlignmentType.NONE, alignment);
    }

}
