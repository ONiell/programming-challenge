package de.bcxp.challenge.population;

import de.bcxp.challenge.population.model.PopulationData;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PopulationMetricsTest {

    private final PopulationMetrics populationMetrics = new PopulationMetrics();

    @Test
    void getMaxPopulationDensity_emptyList() {

        var result = populationMetrics.getMaxPopulationDensity(Collections.emptyList());

        assertNull(result);
    }

    @Test
    void getMaxPopulationDensity_validList() {

        final var populationData1 = PopulationData.builder()
                .country("country1")
                .areaInSquareKM(1000)
                .population(1000)
                .build();

        final var populationData2 = PopulationData.builder()
                .country("country2")
                .areaInSquareKM(500)
                .population(1000)
                .build();

        var result = populationMetrics.getMaxPopulationDensity(List.of(populationData1, populationData2));

        assertEquals(populationData2, result);
    }

    @Test
    void getMaxPopulationDensity_AreaNull() {

        final var populationData1 = PopulationData.builder()
                .country("country1")
                .areaInSquareKM(1000)
                .population(1000)
                .build();

        final var populationData2 = PopulationData.builder()
                .country("country2")
                .areaInSquareKM(null)
                .population(1000)
                .build();

        var result = populationMetrics.getMaxPopulationDensity(List.of(populationData1, populationData2));

        assertEquals(populationData1, result);
    }

    @Test
    void getMaxPopulationDensity_AreaZero() {

        final var populationData1 = PopulationData.builder()
                .country("country1")
                .areaInSquareKM(1000)
                .population(1000)
                .build();

        final var populationData2 = PopulationData.builder()
                .country("country2")
                .areaInSquareKM(0)
                .population(1000)
                .build();

        var result = populationMetrics.getMaxPopulationDensity(List.of(populationData1, populationData2));

        assertEquals(populationData1, result);
    }

    @Test
    void getMaxPopulationDensity_PopulationNull() {

        final var populationData1 = PopulationData.builder()
                .country("country1")
                .areaInSquareKM(1000)
                .population(1000)
                .build();

        final var populationData2 = PopulationData.builder()
                .country("country2")
                .areaInSquareKM(500)
                .population(null)
                .build();

        var result = populationMetrics.getMaxPopulationDensity(List.of(populationData1, populationData2));

        assertEquals(populationData1, result);
    }
}