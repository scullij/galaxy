package com.mercadolibre.galaxy;

import com.mercadolibre.galaxy.forecast.Forecast;
import com.mercadolibre.galaxy.forecast.ForecastService;
import com.mercadolibre.galaxy.model.Galaxy;
import com.mercadolibre.galaxy.model.factory.GalaxyFactory;
import com.mercadolibre.galaxy.repository.ForecastRespository;
import com.mercadolibre.galaxy.repository.ForecastResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javier.sculli on 7/24/17.
 */

@Component
public class ForecastPredictionJob {

    @Autowired
    ForecastService forecastService;

    @Autowired
    ForecastRespository forecastRespository;

    private static final Logger LOGGER = Logger.getLogger(ForecastPredictionJob.class);

    @PostConstruct
    public void job() {

        LOGGER.info("Forecast Job Started - " + LocalDateTime.now());

        forecastRespository.deleteAll();

        Galaxy galaxy = GalaxyFactory.create();

        List<ForecastResult> forecastResults = new ArrayList<>();

        for (int i = 0; i < 365 * 10; i++) {

            Forecast forecast = forecastService.calculate(galaxy, i);
            forecastResults.add(new ForecastResult(i, forecast));
        }

        forecastRespository.save(forecastResults);

        LOGGER.info("Job completed. Forecast created: " + forecastResults.size());
    }

}
