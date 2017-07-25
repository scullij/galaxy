package com.mercadolibre.galaxy.forecast;

import com.mercadolibre.galaxy.model.Galaxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by javier.sculli on 7/24/17.
 */
public class PeriodForecastService {

    private ForecastService forecastService;
    private ForecastResult forecastResult;

    public PeriodForecastService(ForecastService forecastService) {
        this.forecastService = forecastService;
        this.forecastResult = new ForecastResult();
    }

    public ForecastResult calculate(Galaxy galaxy, int days) {

        for (int i = 0; i < days; i++) {

            Forecast forecast = forecastService.calculate(galaxy, i);
            forecastResult.add(forecast);
        }

        forecastResult.setRainiestDay(forecastService.getMaxPerimeterDay());

        return forecastResult;
    }

    public class ForecastResult{

        Map<Forecast, Integer> result;
        private int rainiestDay;

        public ForecastResult() {
            this.result = new HashMap<>();
            this.result.put(Forecast.NORMAL, 0);
            this.result.put(Forecast.DROUGHT, 0);
            this.result.put(Forecast.RAINY, 0);
            this.result.put(Forecast.OPTIMAL, 0);
        }

        public void add(Forecast forecast){
            result.merge(forecast, 1, Integer::sum);
        }

        public void setRainiestDay(int rainiestDay) {
            this.rainiestDay = rainiestDay;
        }

        public int getRainiestDay() {
            return rainiestDay;
        }

        public Map<Forecast, Integer> getResult() {
            return result;
        }

        public Integer getResult(Forecast forecast) {
            return result.get(forecast);
        }

    }

}
