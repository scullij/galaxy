package com.mercadolibre.galaxy.alignment.implementations;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.alignment.implementations.custom.GalaxyColinearAlignmentResolver;
import com.mercadolibre.galaxy.alignment.implementations.custom.PlanetColinearAlignmentResolver;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by javier.sculli on 7/20/17.
 */
@Component
public class CustomAlignmentResolver implements AlignmentResolver {

    @Override
    public AlignmentType getAlignment(Sun sun, List<Planet> planets, int days) {

        if( GalaxyColinearAlignmentResolver.execute(sun, planets, days) ){

            return AlignmentType.ALL;

        }else if( PlanetColinearAlignmentResolver.execute(sun, planets, days) ){

            return AlignmentType.PLANETS;

        }else{

            return AlignmentType.NONE;
        }

    }

}
