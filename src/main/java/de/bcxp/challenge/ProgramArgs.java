package de.bcxp.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgramArgs {

    private String weatherFilePath;
    private String populationFilePath;
}
