package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.geometry.TrigonometryCalculator;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by javier.sculli on 7/20/17.
 */
@Component
public class GalaxyColinearAlignmentResolver implements ParticularAlignmentResolver {

    @Override
    public boolean execute(Sun sun, List<Planet> planets, int days) {

        List<Double> degrees = planets.stream().map( p -> p.getDegrees(days) ).collect(Collectors.toList());

        boolean adyacents = false;
        double first = degrees.get(0);

        for (int j = 1; j < degrees.size()-1; j++){

            double cosFirst = TrigonometryCalculator.cos(first);
            double cosNext = TrigonometryCalculator.cos(degrees.get(j));

            if( Math.abs(cosFirst) - Math.abs(cosNext) != 0 ){
                adyacents = false;
                break;
            }
            else
                adyacents = true;
        }

        return adyacents;
    }

    @Override
    public AlignmentType forecast() {
        return AlignmentType.ALL;
    }

}
