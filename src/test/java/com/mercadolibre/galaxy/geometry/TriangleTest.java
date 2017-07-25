package com.mercadolibre.galaxy.geometry;

import com.mercadolibre.galaxy.geometry.Coordinate;
import com.mercadolibre.galaxy.geometry.Triangle;
import javafx.geometry.Point2D;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by javier.sculli on 7/10/17.
 */
public class TriangleTest {

    @Test
    public void perimeters(){

        Coordinate point1 = new Coordinate(-3,0);
        Coordinate point2 = new Coordinate(3,0);
        Coordinate point3 = new Coordinate(0,3);

        Triangle triangle = new Triangle(point1, point2, point3);

        Assert.assertEquals(Math.sqrt( 9 + 9 ) * 2 + 6, triangle.getPerimeter(), 1e-14);
    }

   @Test
    public void contains(){

       Coordinate point1 = new Coordinate(-3,0);
       Coordinate point2 = new Coordinate(3,0);
       Coordinate point3 = new Coordinate(0,3);

       Triangle triangle = new Triangle(point1, point2, point3);

       Coordinate coordinate = new Coordinate(1,1);

       Assert.assertTrue(triangle.contains(coordinate));

       coordinate = new Coordinate(0,-1);

       Assert.assertFalse(triangle.contains(coordinate));

       coordinate = new Coordinate(0,0.0000000001);

       Assert.assertTrue(triangle.contains(coordinate));


       //ASSERRT ADYANCENTS
       point1 = new Coordinate(5,0);
       point2 = new Coordinate(3,0);
       point3 = new Coordinate(1,0);

       triangle = new Triangle(point1, point2, point3);

       System.out.println(triangle.isValid());

       coordinate = new Coordinate(0,0);

       Assert.assertTrue(triangle.contains(coordinate));
   }

}
