package de.bcxp.challenge.weather;

import de.bcxp.challenge.weather.model.WeatherData;

import java.util.Comparator;
import java.util.List;

public class WeatherMetrics {

    public WeatherData getDayWithLowestTemperatureSpread(final List<WeatherData> weatherDataList){

        return weatherDataList.stream()
                .filter(weatherData -> weatherData.getMaxTemperature() != null)
                .filter(weatherData -> weatherData.getMinTemperature() != null)
                .min(Comparator.comparingInt(weatherData -> weatherData.getMaxTemperature() - weatherData.getMinTemperature()))
                .orElse(null);
    }
}
