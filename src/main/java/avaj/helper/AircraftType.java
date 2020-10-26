package avaj.helper;

public enum AircraftType {

    HELICOPTER("Helicopter"),
    JETPLANE("JetPlane"),
    BALOON("Baloon");

    private final String type;

    AircraftType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
