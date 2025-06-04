package de.bcxp.challenge.cvs;

import de.bcxp.challenge.population.model.PopulationData;
import de.bcxp.challenge.weather.model.WeatherData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvImporterTest {

    private final CsvImporter csvImporter = new CsvImporter();

    @Test
    void importData_validPathAndClass() throws FileNotFoundException {

        final var csvFile = new File("src/test/java/resources/countries_short.csv");

        csvImporter.setSeparator(';');
        final var result = csvImporter.importData(csvFile.getAbsolutePath(), PopulationData.class);

        final var expected = new PopulationData("Austria", "Vienna",1995, 8926000, 83855, 447718, 0.922, 19);

        assertEquals(List.of(expected), result);
    }

    @Test
    void importData_wrongClass() throws FileNotFoundException {

        final var csvFile = new File("src/test/java/resources/countries_short.csv");

        csvImporter.setSeparator(';');
        final var result = csvImporter.importData(csvFile.getAbsolutePath(), WeatherData.class);

        assertEquals(List.of(new WeatherData()), result);
    }

    @Test
    void importData_PathEmpty() throws FileNotFoundException {
        final var result = csvImporter.importData("", WeatherData.class);

        assertNotNull(result);
    }

    @Test
    void importData_ClassNull() throws FileNotFoundException {
        final var result = csvImporter.importData("/some/Path/weather.csv", null);

        assertNotNull(result);
    }

    @Test
    void importData_FileNotFound() {
        assertThrows(FileNotFoundException.class, () ->csvImporter.importData("/some/Path/weather.csv", WeatherData.class));
    }
}