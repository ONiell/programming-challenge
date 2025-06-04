package de.bcxp.challenge.population.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import de.bcxp.challenge.cvs.CsvStringToIntConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopulationData {

    @CsvBindByName(column = "Name")
    private String country;

    @CsvBindByName(column = "Capital")
    private String capitalCity;

    @CsvBindByName(column = "Accession")
    private Integer accession;

    @CsvCustomBindByName(column = "Population",  converter = CsvStringToIntConverter.class)
    private Integer population;

    @CsvBindByName(column = "Area (km²)")
    private Integer areaInSquareKM;

    @CsvBindByName(column = "GDP (US$ M)")
    private Integer gdpInMioUsd;

    @CsvBindByName(column = "HDI")
    private Double humanDevelopmentIndex;

    @CsvBindByName(column = "MEPs")
    private Integer memberCountOfEuropeanParliament;
}

