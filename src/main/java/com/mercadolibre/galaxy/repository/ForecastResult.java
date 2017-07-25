package com.mercadolibre.galaxy.repository;

import com.mercadolibre.galaxy.forecast.Forecast;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by javier.sculli on 7/24/17.
 */
public class ForecastResult {

    @Indexed
    private int day;
    private Forecast forecast;

    public ForecastResult(int day, Forecast forecast) {
        this.day = day;
        this.forecast = forecast;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
