package de.bcxp.challenge;

import de.bcxp.challenge.weather.CsvImporter;
import de.bcxp.challenge.weather.WeatherMetrics;
import de.bcxp.challenge.weather.model.WeatherData;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        final CsvImporter csvImporter = new CsvImporter();
        final WeatherMetrics weatherMetrics = new WeatherMetrics();

        final List<WeatherData> weatherDataList;

        try {
            weatherDataList = csvImporter.importData("C:\\ProjekteLokal\\Java\\programming-challenge\\src\\main\\resources\\de\\bcxp\\challenge\\weather.csv", WeatherData.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        final Integer dayWithSmallestTempSpread = weatherMetrics.getDayWithLowestTemperature(weatherDataList);
        System.out.printf("Day with smallest temperature spread is Nr.: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
