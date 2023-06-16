package de.bcxp.challenge;

import de.bcxp.solution.Country;
import de.bcxp.solution.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void calculateSmallestTemperatureSpreadTest() {
        //Create dummy weather list
        List<Weather> weatherList = new ArrayList<Weather>(){{
            add(new Weather(1, 20, 1));
            add(new Weather(2, 25, 1));
            add(new Weather(3, 15, 1));
        }};

        //Assert method
        assertEquals(3, App.getDayWithSmallestTemperatureSpread(weatherList));
    }
    @Test
    void calculateHighestPopDensityTest() {
        //Create dummy country list
        List<Country> countryList = new ArrayList<Country>(){{
            add(new Country("A", 50, 50));
            add(new Country("B", 100, 50));
            add(new Country("C", 25, 50));
        }};

        //Assert method
        assertEquals("B", App.getCountryWithHighestPopulationDensity(countryList));
    }
}