package de.bcxp.challenge.cvs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvStringToIntConverterTest {

    private final CsvStringToIntConverter converter = new CsvStringToIntConverter();

    @ParameterizedTest
    @CsvSource(value = {
            "4.036.355,00;4036355",
            "4.036.355;4036355",
            "Test String;",
            "Text,String;",
            "400;400",
            " T3xt ;",
            " ;0",
            ";0"
    }, delimiter = ';')
    void convert_StringToInt(final String input, final Integer expected) {

        final Integer result = converter.convert(input);

        assertEquals(expected, result);
    }
}