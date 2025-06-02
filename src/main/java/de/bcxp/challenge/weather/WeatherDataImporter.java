package de.bcxp.challenge.weather;

import java.io.FileNotFoundException;
import java.util.List;

public interface WeatherDataImporter {

    <T> List<T> importData(final String absoluteFilePath, final Class<T> dataClass) throws FileNotFoundException;
}
