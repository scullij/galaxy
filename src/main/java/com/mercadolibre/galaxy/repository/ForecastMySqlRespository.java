package com.mercadolibre.galaxy.repository;

import com.mercadolibre.galaxy.forecast.Forecast;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by javier.sculli on 7/24/17.
 */
public class ForecastMySqlRespository {

    private static final Logger LOGGER = Logger.getLogger(ForecastMySqlRespository.class);

    private Connection conn;

    public ForecastMySqlRespository() {

        try {
            String url = System.getProperty("cloudsql");

            LOGGER.info("connecting to: " + url);

            try {

                conn = DriverManager.getConnection(url);

                final String createTableSql = "CREATE TABLE IF NOT EXISTS forecasts ( days INT NOT NULL , forecast VARCHAR(10) NOT NULL )";
                conn.createStatement().executeUpdate(createTableSql);

            } catch (SQLException e) {
                throw new RuntimeException("Unable to connect to Cloud SQL", e);
            }

        } finally {
            // Nothing really to do here.
        }

    }

    public void insert(ForecastResult forecastResult) {

        final String insert = "INSERT INTO forecasts (days, forecast) VALUES (?, ?)";

        try (PreparedStatement insertStatement = conn.prepareStatement(insert)) {

            insertStatement.setInt(1, forecastResult.getDay());
            insertStatement.setString(2, forecastResult.getForecast().toString());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("SQL error", e);
        }
    }

    public ForecastResult find(int day){

        final String select = "SELECT days, forecast FROM forecasts WHERE days = " + day;

        try (ResultSet rs = conn.prepareStatement(select).executeQuery()) {

            while (rs.next()) {
                Integer days = rs.getInt("days");
                Forecast forecast = Forecast.valueOf(rs.getString("forecast"));

                return new ForecastResult(days, forecast);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL error", e);
        }

        return null;
    }

    public void deleteAll() {

        final String delete = "DELETE FROM forecasts";

        try{
            conn.prepareStatement(delete).execute();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error", e);
        }

    }

}