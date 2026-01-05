package TravelCardOOP;

import java.util.ArrayList;

public class TravelCard {

    //count needs to be implemented
    private Journey currentJourney;
    private long id;
    private double balance;
    private Status cardStatus;

    private ArrayList<Journey> journeyHistory;
    private static final double MIN_FARE = 2.0;


    public TravelCard(long id, double balance, Status cardStatus){
        this.id=id;
        this.balance = balance;
        this.cardStatus=cardStatus;
        this.journeyHistory = new ArrayList<>();
    }

    //main methods
    public void topUp(double amount){
        if (amount>0){
            balance+=amount;
        } else {
            throw new IllegalArgumentException("top up amount can be only positive(>0);");
        }
    }

    public void touchIn(Station station){ //need implementation
        if (station == null) {
            throw new IllegalArgumentException("Station cannot be null");
        }

        if (this.cardStatus!=Status.ACTIVE){
            throw new IllegalStateException("Card is not active.");
        }

        if (currentJourney != null) {
            throw new IllegalStateException("Already in journey");
        }

        if (balance < MIN_FARE) {
            throw new IllegalStateException("Not enough balance to start journey");
        }
        currentJourney = new Journey(station);

    }

    public void touchOut(Station station) {
        if (station == null) {
            throw new IllegalArgumentException("Station cannot be null");
        }
        if (currentJourney == null) {
            throw new IllegalStateException("Not in journey");
        }

        currentJourney.complete(station);
        charge(currentJourney.getFareCharged());
        journeyHistory.add(currentJourney);
        currentJourney = null;
    }

    private void charge(double amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Charge amount cannot be negative");
        }
        if (balance < amount) {
            throw new IllegalStateException("Not enough balance");
        }
        balance -= amount;
    }

    //getters
    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Status getCardStatus() {
        return cardStatus;
    }

    public Journey getCurrentJourney() {
        return currentJourney;
    }

    public ArrayList<Journey> getJourneyHistory() {
        return journeyHistory;
    }

    //setters

    public void setCardStatus(Status cardStatus) {
        this.cardStatus = cardStatus;
    }

}
