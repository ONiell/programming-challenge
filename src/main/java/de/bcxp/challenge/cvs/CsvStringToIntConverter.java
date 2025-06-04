package de.bcxp.challenge.cvs;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;


public class CsvStringToIntConverter extends AbstractBeanField<Integer, String> {

    @Override
    protected Integer convert(final String value) {

        if (StringUtils.isBlank(value)) {
            return 0;
        }

        final String[] stringParts = value.trim().replaceAll("\\.", "").split(",");

        if (stringParts.length == 0) {
            return 0;
        }

        try{
            return Integer.parseInt(stringParts[0]);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
