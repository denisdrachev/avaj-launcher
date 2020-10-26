package avaj.helper;

import java.util.HashMap;
import java.util.Map;

import static avaj.helper.WeatherType.*;

public class WeatherString {

    public static Map<String, String> weatherText = new HashMap<>();

    static {
        weatherText.put(RAIN.getType(), "It's Raining Men! Hallelujah!");
        weatherText.put(FOG.getType(), "A hedgehog comes out...");
        weatherText.put(SUN.getType(), "The eye of Sauron is watching you!");
        weatherText.put(SNOW.getType(), "That's it, I looked at the snow, you can remove it.");
    }

}
