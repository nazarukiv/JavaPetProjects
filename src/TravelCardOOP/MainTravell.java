package TravelCardOOP;

public class MainTravell {
    public static void main(String[] args) {
        TravelCard card = new TravelCard(1, 10.0, Status.ACTIVE);

        Station bank = new Station("Bank", 1);
        Station stratford = new Station("Stratford", 3);

        card.touchIn(bank);
        card.touchOut(stratford);

        System.out.println("Balance: " + card.getBalance());
        System.out.println("History: " + card.getJourneyHistory());
    }
}