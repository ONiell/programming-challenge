package de.bcxp.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void amin_Test() {

        final var coutriesFile = new File("src/test/java/resources/countries_short.csv");
        final var weatherFile = new File("src/test/java/resources/weather_short.csv");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        final String[] args = {"-w", weatherFile.getAbsolutePath(), "-p", coutriesFile.getAbsolutePath()};
        App.main(args);

        final var output = outContent.toString();

        final var expectedOutput = "Day with smallest temperature spread is Nr.: 1\r\n" +
                "Country with highest population density: Austria\r\n";
        assertEquals(expectedOutput, output);

        System.setOut(System.out);

    }
}