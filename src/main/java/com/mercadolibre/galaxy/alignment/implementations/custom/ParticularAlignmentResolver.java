package com.mercadolibre.galaxy.alignment.implementations.custom;

import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;

import java.util.List;

/**
 * Created by javier.sculli on 7/25/17.
 */
public interface ParticularAlignmentResolver {

    boolean execute(Sun sun, List<Planet> planets, int days);

    AlignmentType forecast();

}
