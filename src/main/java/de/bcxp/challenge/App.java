package de.bcxp.challenge;

import de.bcxp.challenge.cvs.CsvImporter;
import de.bcxp.challenge.population.PopulationMetrics;
import de.bcxp.challenge.population.model.PopulationData;
import de.bcxp.challenge.weather.WeatherMetrics;
import de.bcxp.challenge.weather.model.WeatherData;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
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

        final var csvImporter = new CsvImporter();
        final var weatherMetrics = new WeatherMetrics();
        final var populationMetrics = new PopulationMetrics();

        final List<WeatherData> weatherDataList;
        final List<PopulationData> populationDataList;

        try {

            var weatherUrl = App.class.getClassLoader().getResource("de/bcxp/challenge/weather.csv");
            assert weatherUrl != null;
            var populationUrl = App.class.getClassLoader().getResource("de/bcxp/challenge/weather.csv");
            assert populationUrl != null;

            weatherDataList = csvImporter.importData(weatherUrl.getPath(), WeatherData.class);
            csvImporter.setSeparator(';');
            populationDataList = csvImporter.importData("F:\\Local_Projects\\Java\\src\\main\\resources\\de\\bcxp\\challenge\\countries.csv", PopulationData.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }


        final var dayWithSmallestTempSpread = weatherMetrics.getDayWithLowestTemperature(weatherDataList);
        System.out.printf("Day with smallest temperature spread is Nr.: %s%n", dayWithSmallestTempSpread);

        final var maxPopulationDensityData = populationMetrics.getMaxPopulationDensity(populationDataList);
        final var countryWithHighestPopulationDensity = maxPopulationDensityData.getCountry();
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
