package com.mercadolibre.galaxy.alignment.implementations;

import com.mercadolibre.galaxy.alignment.AlignmentResolver;
import com.mercadolibre.galaxy.alignment.AlignmentType;
import com.mercadolibre.galaxy.alignment.implementations.custom.ParticularAlignmentResolver;
import com.mercadolibre.galaxy.model.Planet;
import com.mercadolibre.galaxy.model.Sun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by javier.sculli on 7/20/17.
 */
@Component
public class CustomAlignmentResolver implements AlignmentResolver {

    List<ParticularAlignmentResolver> resolvers;

    @Autowired
    public CustomAlignmentResolver(List<ParticularAlignmentResolver> resolvers) {
        this.resolvers = resolvers;
    }

    @Override
    public AlignmentType getAlignment(Sun sun, List<Planet> planets, int days) {

        for (ParticularAlignmentResolver resolver: resolvers ) {
            boolean applyResolver = resolver.execute(sun, planets, days);

            if(applyResolver)
                return resolver.forecast();
        }

        return AlignmentType.NONE;
    }

}
