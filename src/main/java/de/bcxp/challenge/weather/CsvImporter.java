package de.bcxp.challenge.weather;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvImporter implements WeatherDataImporter {


    public <T> List<T> importData(final String absoluteFilePath, final Class<T> dataClass) throws FileNotFoundException {

        return new CsvToBeanBuilder<T>(new FileReader(absoluteFilePath))
                .withType(dataClass)
                .build()
                .parse();

    }
}
