package de.bcxp.challenge;

import de.bcxp.solution.*;

import java.io.File;
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
            System.out.printf("Couldn't read file");
        }
        return data;
    }

    public static int getDayWithSmallestTemperatureSpread(List<Weather> weatherList) {

        //Check temperature spread of every day
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

        return dayWithLowestTempSpread;
    }

    private static void outputMinTemperatureSpread() {
        // Read File
        List<String[]> data = readFile("src/main/resources/de/bcxp/challenge/weather.csv", ',');
        if (data != null) {
            // Parse data
            DataParser parser = new DataParser();
            List<Weather> weatherList = parser.convertToWeatherType(data);

            if (weatherList.size() > 0) {
                System.out.printf("Day with smallest temperature spread: %s.%n ",
                        getDayWithSmallestTemperatureSpread(weatherList));
            } else {
                System.out.printf("Error while parsing. Weather list is empty.");
            }
        }
    }

    public static String getCountryWithHighestPopulationDensity(List<Country> countryList) {
        //Check country with the highest density
        String countryWithHighestDensity = "";
        float highestPopDensity = countryList.get(0).getPopDensity();
        float currentPopDensity;

        for (Country country : countryList) {
            currentPopDensity = country.getPopDensity();
            //the highest pop. density is overwritten when the current one is higher than its last highest value
            if (currentPopDensity > highestPopDensity) {
                highestPopDensity = currentPopDensity;
                countryWithHighestDensity = country.getCountryName();
            }
        }
        return countryWithHighestDensity;
    }

    private static void outputMaxPopulationDensity() {
        // Read File
        List<String[]> data = readFile("src/main/resources/de/bcxp/challenge/countries.csv", ';');
        if (data != null) {
            // Parse data
            DataParser parser = new DataParser();
            List<Country> countryList = parser.convertToCountryType(data);

            if (countryList.size() > 0) {
                System.out.printf("Country with highest population density: %s.%n ",
                        getCountryWithHighestPopulationDensity(countryList));

            }
            else {
                System.out.printf("Error while parsing. Countries list is empty.");
            }


        }
    }
}
