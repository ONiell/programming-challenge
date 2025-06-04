package de.bcxp.challenge.weather;

import de.bcxp.challenge.weather.model.WeatherData;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class WeatherMetrics {

    public Integer getDayWithLowestTemperature(final List<WeatherData> weatherDataList){

        return weatherDataList.stream()
                .map(weatherData -> weatherData.getMaxTemperature() - weatherData.getMinTemperature())
                .min(Integer::compare)
                .orElse(null);
    }
}
