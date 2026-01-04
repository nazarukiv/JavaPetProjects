package TravelCardOOP;

import java.time.LocalDateTime;

public class Journey {

    private Station fromStation;
    private Station toStation;
    private LocalDateTime touchInTime;
    private LocalDateTime touchOutTime;

    private double fareCharged;


    private JourneyStatus status;

    public Journey(Station fromStation) {
        this.fromStation = fromStation;
        this.touchInTime = LocalDateTime.now();
        this.status = JourneyStatus.IN_PROGRESS;
    }


    public void complete(Station toStation){
        if (status != JourneyStatus.IN_PROGRESS){
            throw new IllegalStateException("to finish journey, status has to be 'in progress'");
        }

        if (toStation==null) {
            throw new IllegalArgumentException("To station has to be entered");
        }
            this.toStation = toStation;
            this.fareCharged = calculateFare();
            this.touchOutTime = LocalDateTime.now();
            this.status = JourneyStatus.COMPLETED;
        }

    private double calculateFare(){
        double base = 2.0;
        int diff = Math.abs(fromStation.getZone() - toStation.getZone());
        return base + diff * 1.5;
    }


    //getters
    public double getFareCharged() {
        return fareCharged;
    }

}

