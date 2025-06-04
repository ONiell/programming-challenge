package de.bcxp.challenge.weather;

import de.bcxp.challenge.weather.model.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WeatherMetricsTest {

    private final WeatherMetrics weatherMetrics = new WeatherMetrics();

    @Test
    void getDayWithLowestTemperatureSpread_emptyList() {

        final var result = weatherMetrics.getDayWithLowestTemperatureSpread(Collections.emptyList());

        assertNull(result);
    }

    @Test
    void getDayWithLowestTemperatureSpread_validList() {

        final var weatherData1 = WeatherData.builder()
                .dayInMonth(1)
                .maxTemperature(50)
                .minTemperature(30)
                .build();

        final var weatherData2 = WeatherData.builder()
                .dayInMonth(2)
                .maxTemperature(50)
                .minTemperature(20)
                .build();

        var result = weatherMetrics.getDayWithLowestTemperatureSpread(List.of(weatherData1, weatherData2));

        assertEquals(weatherData1, result);
    }

    @Test
    void getDayWithLowestTemperatureSpread_MaxTempNull() {

        final var weatherData1 = WeatherData.builder()
                .dayInMonth(1)
                .maxTemperature(null)
                .minTemperature(30)
                .build();

        final var weatherData2 = WeatherData.builder()
                .dayInMonth(2)
                .maxTemperature(50)
                .minTemperature(20)
                .build();

        final var result = weatherMetrics.getDayWithLowestTemperatureSpread(List.of(weatherData1, weatherData2));

        assertEquals(weatherData2, result);
    }

    @Test
    void getDayWithLowestTemperatureSpread_MinTempNull() {

        final var weatherData1 = WeatherData.builder()
                .dayInMonth(1)
                .maxTemperature(50)
                .minTemperature(null)
                .build();

        final var weatherData2 = WeatherData.builder()
                .dayInMonth(2)
                .maxTemperature(50)
                .minTemperature(20)
                .build();

        final var result = weatherMetrics.getDayWithLowestTemperatureSpread(List.of(weatherData1, weatherData2));

        assertEquals(weatherData2, result);
    }
}