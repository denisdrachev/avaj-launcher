package avaj.weather;

import avaj.Coordinates;

import static avaj.Printer.writeToFile;
import static avaj.weather.WeatherProvider.getProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return getProvider().getCurrentWeather(coordinates);
    }

    private void changeWeather() {
        conditionsChanged();
    }

    public void simulate(int rounds) {
        for (int i = 1; i <= rounds; i++) {
            writeToFile("\nround: " + i);
            changeWeather();
        }
    }
}
