package com.mercadolibre.galaxy.alignment.implementations;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.alignment.implementations.GenericAlignmentResolver;
import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.Planet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by javier.sculli on 7/18/17.
 */
public class GenericAlignmentResolverTest {

    private AlignmentResolver planetaryModel = new GenericAlignmentResolver();

    @Test
    public void test(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        //AlignmentType alignment = PlanetaryModel.getAlignment(galaxy.getPlanets(), 90);

        //Assert.assertEquals(PlanetaryModel.AlignmentType.ALL, alignment);
    }

    @Test
    public void test1(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 2, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", 3, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        AlignmentType alignment = planetaryModel.getAlignment(null, galaxy.getPlanets(), 1);

        Assert.assertEquals(AlignmentType.NONE, alignment);
    }

    @Test
    public void test2(){

        Planet ferengi = new Planet("Ferengi", 1, new Coordinate(500,0), 500);
        Planet betasoide = new Planet("Betasoide", 3, new Coordinate(2000,0), 2000);
        Planet vulcano = new Planet("Vulcano", -5, new Coordinate(1000,0), 1000);

        Galaxy galaxy = new Galaxy(ferengi, betasoide, vulcano);

        for (int i = 0; i < 10 * 365; i++) {
            System.out.println("Click: " + i);
            //AlignmentType alignment = planetaryModel.getAlignment(null, galaxy.getPlanets(), i);

            //if(alignment.equals(AlignmentType.PLANETS)){
            //    System.out.println("Planet Alignment : " + i);
            //}
        }

    }

}
