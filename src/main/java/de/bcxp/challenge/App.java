package de.bcxp.challenge;

import de.bcxp.solution.CsvReader;

import java.io.File;

public final class App {
    private static void outputMinTemperatureSpread(){
        // Read File
        CsvReader reader = new CsvReader();
        try {
            reader.read(new File("weather.csv"), ',');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // TODO
        //  Convert data
        //  Output
        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
    }

    private static void outputMaxPopulationDensity(){

        // TODO
        //  read file
        //  convert
        //  output
        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    public static void main(String[] args) {

        outputMinTemperatureSpread();
        outputMaxPopulationDensity();
    }
}
