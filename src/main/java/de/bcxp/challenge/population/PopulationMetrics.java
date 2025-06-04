package de.bcxp.challenge.population;

import de.bcxp.challenge.population.model.PopulationData;

import java.util.Comparator;
import java.util.List;

public class PopulationMetrics {

    public PopulationData getMaxPopulationDensity(final List<PopulationData> populationDataList){

         return populationDataList.stream()
                .filter(populationData -> populationData.getAreaInSquareKM() > 0)
                .max(Comparator.comparingInt(value -> value.getPopulation() / value.getAreaInSquareKM()))
                .orElse(null);
    }
}
