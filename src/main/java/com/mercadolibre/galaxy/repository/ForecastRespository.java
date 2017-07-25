package com.mercadolibre.galaxy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by javier.sculli on 7/24/17.
 */
public interface ForecastRespository extends MongoRepository<ForecastResult, String> {

    ForecastResult findByDay(Integer day);

}