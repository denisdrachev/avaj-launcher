package avaj.helper;

public enum WeatherType {

    RAIN("RAIN"),
    FOG("FOG"),
    SUN("SUN"),
    SNOW("SNOW");

    private final String type;

    WeatherType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
