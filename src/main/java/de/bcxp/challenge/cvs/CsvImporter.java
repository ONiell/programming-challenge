package de.bcxp.challenge.cvs;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Setter
public class CsvImporter implements CSVImportable {

    private Character separator = ',';

    public <T> List<T> importData(final String absoluteFilePath, final Class<T> dataClass) throws FileNotFoundException {

        return new CsvToBeanBuilder<T>(new FileReader(absoluteFilePath))
                .withSeparator(separator)
                .withType(dataClass)
                .build()
                .parse();

    }
}
