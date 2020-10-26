package avaj.air;

import avaj.Aircraft;
import avaj.Coordinates;
import avaj.Flyable;
import avaj.helper.WeatherString;
import avaj.helper.WeatherType;
import avaj.weather.WeatherTower;

import static avaj.Printer.writeToFile;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        writeToFile( this + ": " + WeatherString.weatherText.get(weather));

        switch (WeatherType.valueOf(weather)) {
            case SUN:
                coordinates.increasesLongitude(2);
                coordinates.increasesHeight(4);
                break;
            case RAIN:
                coordinates.decreasesHeight(5);
                break;
            case FOG:
                coordinates.decreasesHeight(3);
                break;
            case SNOW:
                coordinates.decreasesHeight(15);
                break;
        }
        if (coordinates.getHeight() > 100)
            coordinates.setHeight(100);
        if (coordinates.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        writeToFile("Tower says: " + this + " registered to weather tower.");
    }
}
