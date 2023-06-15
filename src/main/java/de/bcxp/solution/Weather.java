package de.bcxp.solution;

public class Weather {
    private int day;
    private int maxTemp;
    private int minTemp;
    private int tempSpread;

    public Weather(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        tempSpread = maxTemp - minTemp;
    }

    public int getDay() {
        return day;
    }

    public int getTemperatureSpread() {
        return tempSpread;
    }
}