package TravelCardOOP;

public class Station {

    private final String name;
    private final int zone; // London zones; 1–9

    public Station(String name, int zone) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Station name cannot be empty");
        }

        if (zone < 1 || zone > 9) {
            throw new IllegalArgumentException("Zone must be between 1 and 9");
        }

        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public int getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return name + " (Zone " + zone + ")";
    }
}