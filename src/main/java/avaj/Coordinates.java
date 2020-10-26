package avaj;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    private Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public static Coordinates Builder(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public void increasesLongitude(int value) {
        longitude += value;
    }

    public void increasesLatitude(int value) { latitude += value; }

    public void increasesHeight(int value) {
        height += value;
    }

    public void decreasesLongitude(int value) {
        longitude -= value;
    }

    public void decreasesLatitude(int value) { latitude -= value; }

    public void decreasesHeight(int value) {
        height -= value;
    }
}
