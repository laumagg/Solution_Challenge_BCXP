package de.bcxp.challenge;

import de.bcxp.solution.Country;
import de.bcxp.solution.CsvReader;
import de.bcxp.solution.DataParser;
import de.bcxp.solution.Weather;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public final class App {

    public static void main(String[] args) {
        outputMinTemperatureSpread();
        outputMaxPopulationDensity();
    }

    private static List<String[]> readFile(String path, char separator) {
        List<String[]> data = null;
        CsvReader reader = new CsvReader();
        try {
            data = reader.read(new File(path), separator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    private static void outputMinTemperatureSpread() {
        // Read File
        List<String[]> data = readFile("src/main/resources/de/bcxp/challenge/weather.csv", ',');
        if (data != null) {
            // Parse data
            DataParser parser = new DataParser();
            List<Weather> weatherList = parser.convertToWeatherType(data);

            //Check tempearture spread of every day
            int dayWithLowestTempSpread = 0;
            int smallestTempSpread = weatherList.get(0).getTemperatureSpread();
            int currentTempSpread;

            for (Weather weather : weatherList) {
                currentTempSpread = weather.getTemperatureSpread();
                //the smallest temp. spread is overwritten when the current temp. spread is smaller than its last value
                if (currentTempSpread < smallestTempSpread) {
                    smallestTempSpread = currentTempSpread;
                    dayWithLowestTempSpread = weather.getDay();
                }
            }

            System.out.printf("Day with smallest temperature spread: %s (%s degrees).%n ", dayWithLowestTempSpread, smallestTempSpread);
        }
    }

    private static void outputMaxPopulationDensity() {
        // Read File
        List<String[]> data = readFile("src/main/resources/de/bcxp/challenge/countries.csv", ';');
        if (data != null) {
            // Parse data
            DataParser parser = new DataParser();
            List<Country> countryList = parser.convertToCountryType(data);

            //Check tempearture spread of every day
            String countryWithHigestDensity = "";
            float highestPopDensity = countryList.get(0).getPopDensity();
            float currentPopDensity;

            for (Country country : countryList) {
                currentPopDensity = country.getPopDensity();
                //the smallest temp. spread is overwritten when the current temp. spread is smaller than its last value
                if (currentPopDensity > highestPopDensity) {
                    highestPopDensity = currentPopDensity;
                    countryWithHigestDensity = country.getCountryName();
                }
            }

            System.out.printf("Country with highest population density: %s%n (%f persons per km2).%n ", countryWithHigestDensity, highestPopDensity);
        }
    }
}
