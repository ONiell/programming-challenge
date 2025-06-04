package de.bcxp.challenge.cvs;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

@Setter
public class CsvImporter implements DataImportable {

    private Character separator = ',';

    public <T> List<T> importData(final String absoluteFilePath, final Class<T> dataClass) throws FileNotFoundException {

        if(StringUtils.isBlank(absoluteFilePath) || dataClass == null) {
            return Collections.emptyList();
        }

        return new CsvToBeanBuilder<T>(new FileReader(absoluteFilePath))
                .withSeparator(separator)
                .withType(dataClass)
                .build()
                .parse();

    }
}
