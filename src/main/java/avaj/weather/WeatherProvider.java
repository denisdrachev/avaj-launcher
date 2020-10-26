package avaj.weather;

import avaj.Coordinates;
import avaj.helper.WeatherType;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private static String[] weather;

    private WeatherProvider() {
        weather = new String[]{
                WeatherType.FOG.getType(),
                WeatherType.RAIN.getType(),
                WeatherType.SNOW.getType(),
                WeatherType.SUN.getType()
        };
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        int index = ((coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length +
                ((int) (Math.random() * weather.length))) % weather.length;
        return weather[index];
    }
}
