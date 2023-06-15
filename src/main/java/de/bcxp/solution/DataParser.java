package de.bcxp.solution;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<Weather> convertToWeatherType(List<String[]> data) {
        List<Weather> convertedData = new ArrayList<>();

        int day, maxTemp, minTemp;
        for (int i = 1; i < data.size(); i++) { //First line is title - will be ignored
            try {
                day = tryParseStringToInt(data.get(i)[0]);
                maxTemp = tryParseStringToInt(data.get(i)[1]);
                minTemp = tryParseStringToInt(data.get(i)[2]);

                Weather weather = new Weather(day, maxTemp, minTemp);
                convertedData.add(weather);
            } catch (NumberFormatException e) {
                System.out.printf("Error parsing CSV. Stopped at line: %s%n", i);
            }
        }

        return convertedData;
    }

    public List<Country> convertToCountryType(List<String[]> data) {
        List<Country> convertedData = new ArrayList<>();

        int population, area;
        for (int i = 1; i < data.size(); i++) { //First line is title - will be ignored
            try {
                population = tryParseStringToInt(data.get(i)[3]);
                area = tryParseStringToInt(data.get(i)[4]);

                Country country = new Country(data.get(i)[0], population, area);
                convertedData.add(country);
            } catch (NumberFormatException e) {
                System.out.printf("Error parsing CSV. Problem at line: %s%n", i);
            }
        }

        return convertedData;
    }

    private int tryParseStringToInt(String param) throws NumberFormatException {
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            throw e;
        }
    }


}
