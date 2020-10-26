package avaj;

import avaj.air.Baloon;
import avaj.air.Helicopter;
import avaj.air.JetPlane;
import avaj.helper.AircraftType;

public abstract class AircraftFactory {

    static public Flyable newArtifact(String type, String name, int longitude, int latitude, int height) {

        Coordinates newCoordinates = Coordinates.Builder(longitude, latitude, height);

        switch (AircraftType.valueOf(type.toUpperCase())) {
            case BALOON:
                return new Baloon(name, newCoordinates);
            case HELICOPTER:
                return new Helicopter(name, newCoordinates);
            case JETPLANE:
                return new JetPlane(name, newCoordinates);
        }
        return null;
    }
}
