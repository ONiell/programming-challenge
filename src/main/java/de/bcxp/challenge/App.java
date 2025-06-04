package de.bcxp.challenge;

import de.bcxp.challenge.cvs.CsvImporter;
import de.bcxp.challenge.population.PopulationMetrics;
import de.bcxp.challenge.population.model.PopulationData;
import de.bcxp.challenge.weather.WeatherMetrics;
import de.bcxp.challenge.weather.model.WeatherData;

import java.io.FileNotFoundException;

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

        final var programArgs = extractProgramArgs(args);

        try {
            final var weatherDataList = csvImporter.importData(programArgs.getWeatherFilePath(), WeatherData.class);

            final var weatherDataWithSmallestTempSpread = weatherMetrics.getDayWithLowestTemperatureSpread(weatherDataList);
            System.out.printf("Day with smallest temperature spread is Nr.: %s%n", weatherDataWithSmallestTempSpread.getDayInMonth());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            csvImporter.setSeparator(';');
            final var populationDataList = csvImporter.importData(programArgs.getPopulationFilePath(), PopulationData.class);

            final var populationDataWithHighestPopulationDensity = populationMetrics.getMaxPopulationDensity(populationDataList);
            System.out.printf("Country with highest population density: %s%n", populationDataWithHighestPopulationDensity.getCountry());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static ProgramArgs extractProgramArgs(final String[] args) {

        var weatherFilePath = "";
        var populationFilePath = "";

        for (int i = 0; i < args.length; i++) {

            if (args[i].equalsIgnoreCase("-w") && args.length > i + 1) {
                weatherFilePath = args[i+1];
            }else if (args[i].equalsIgnoreCase("-p")  && args.length > i + 1) {
                populationFilePath = args[i+1];
            }
        }

        return new ProgramArgs(weatherFilePath, populationFilePath);
    }
}
