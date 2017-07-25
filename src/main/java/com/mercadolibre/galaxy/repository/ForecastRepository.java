package com.mercadolibre.galaxy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by javier.sculli on 7/25/17.
 */
public interface ForecastRepository extends MongoRepository<ForecastResult, String> {

    ForecastResult findByDay(Integer day);

}
