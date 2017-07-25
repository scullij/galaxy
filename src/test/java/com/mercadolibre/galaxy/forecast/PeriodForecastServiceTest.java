package com.mercadolibre.galaxy.forecast;

import com.mercadolibre.galaxy.alignment.implementations.CustomAlignmentResolver;
import com.mercadolibre.galaxy.alignment.implementations.custom.GalaxyColinearAlignmentResolver;
import com.mercadolibre.galaxy.alignment.implementations.custom.ParticularAlignmentResolver;
import com.mercadolibre.galaxy.alignment.implementations.custom.PlanetColinearAlignmentResolver;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.factory.GalaxyFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javier.sculli on 7/24/17.
 */
public class PeriodForecastServiceTest {

    private PeriodForecastService periodForecastService;

    @Before
    public void before(){

        List<ParticularAlignmentResolver> resolvers = new ArrayList<>();

        resolvers.add(new GalaxyColinearAlignmentResolver());
        resolvers.add(new PlanetColinearAlignmentResolver());

        ForecastService forecastService = new ForecastService(new CustomAlignmentResolver(resolvers));
        periodForecastService = new PeriodForecastService(forecastService);
    }

    @Test
    public void galaxy_forecast_in_ten_years(){

        Galaxy galaxy = GalaxyFactory.create();

        PeriodForecastService.ForecastResult forecastResult = periodForecastService.calculate(galaxy, 10 * 365);

        Assert.assertEquals(Integer.valueOf(39), forecastResult.getResult(Forecast.DROUGHT));
        Assert.assertEquals(Integer.valueOf(40), forecastResult.getResult(Forecast.OPTIMAL));


        Assert.assertEquals(Integer.valueOf(1807), forecastResult.getResult(Forecast.RAINY));
        Assert.assertEquals(1368, forecastResult.getRainiestDay());

        Assert.assertEquals(Integer.valueOf(1764), forecastResult.getResult(Forecast.NORMAL));
    }

}
