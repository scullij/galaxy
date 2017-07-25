package com.mercadolibre.galaxy.alignment;

import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;

import java.util.List;

/**
 * Created by javier.sculli on 7/20/17.
 */
public interface AlignmentResolver {

    AlignmentType getAlignment(Sun sun, List<Planet> planets, int days);

}
