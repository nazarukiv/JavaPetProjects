package TravelCardOOP;

public class TravelCard {

    //count needs to be implemented
    private Journey currentJourney;
    private long id;
    private double balance;
    private Status cardStatus;


    public TravelCard(long id, double balance, Status cardStatus){
        this.id=id;
        this.balance = balance;
        this.cardStatus=cardStatus;
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

        currentJourney = new Journey(station);

    }

    public void touchOut(Station station){ //need implementation
        if (station == null) {
            throw new IllegalArgumentException("Station cannot be null");
        }

        if (currentJourney == null){
            throw new IllegalStateException("not in journey");
        }

        currentJourney.complete(station);
        currentJourney = null;
    }

    private void charge(double amount){
        balance-=amount;
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

    //setters

    public void setCardStatus(Status cardStatus) {
        this.cardStatus = cardStatus;
    }

}
