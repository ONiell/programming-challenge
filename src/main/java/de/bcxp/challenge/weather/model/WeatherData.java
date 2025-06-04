package de.bcxp.challenge.weather.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    @CsvBindByName(column = "Day")
    private Integer dayInMonth;

    @CsvBindByName(column = "MxT")
    private Integer maxTemperature;

    @CsvBindByName(column = "MnT")
    private Integer minTemperature;

    @CsvBindByName(column = "AvT")
    private Integer averageTemperature;

    @CsvBindByName(column = "AvDP")
    private Double averageDewPoint;

    @CsvBindByName(column = "1HrP")
    private Integer HourlyPrecipitation;

    @CsvBindByName(column = "PDir")
    private Integer prevailingWindDirection;

    @CsvBindByName(column = "AvSP")
    private Double averageWindSpeed;

    @CsvBindByName(column = "Dir")
    private Integer windDirection;

    @CsvBindByName(column = "MxS")
    private Integer maxWindSpeed;

    @CsvBindByName(column = "SkyC")
    private Double skyCover;

    @CsvBindByName(column = "MxR")
    private Integer maxRelativeHumidity;

    @CsvBindByName(column = "MnR")
    private Integer minRelativeHumidity;

    @CsvBindByName(column = "AvSLP")
    private Double averageSeaLevelPressure;
}
