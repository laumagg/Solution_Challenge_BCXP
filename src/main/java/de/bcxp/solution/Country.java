package de.bcxp.solution;

public class Country {
    private String countryName;
    private int population;
    private int area;
    private float popDensity;

    public Country(String countryName, int population, int area) {
        this.countryName = countryName;
        this.population = population;
        this.area = area;
        popDensity = population / area;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getPopDensity() {
        return popDensity;
    }
}
