package com.mercadolibre.galaxy.controller;

import com.mercadolibre.galaxy.repository.ForecastRespository;
import com.mercadolibre.galaxy.repository.ForecastResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by javier.sculli on 7/24/17.
 */
@RestController("/forecast")
public class ForecastController {

    @Autowired
    ForecastRespository forecastRespository;

    @RequestMapping()
    public ForecastResult getForecastByDay(@RequestParam("day") Integer day) {

        ForecastResult forecast = forecastRespository.findByDay(day);

        return forecast;
    }

}
