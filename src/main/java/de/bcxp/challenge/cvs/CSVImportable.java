package de.bcxp.challenge.cvs;

import java.io.FileNotFoundException;
import java.util.List;

public interface CSVImportable {

    <T> List<T> importData(final String absoluteFilePath, final Class<T> dataClass) throws FileNotFoundException;
}
