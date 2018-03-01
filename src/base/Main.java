package base;

public class Main {

    public static void main(String[] args) {

        DeckOfCards deck = new DeckOfCards();
        int cardNumber = 1;

        deck.shuffle();

        while (deck.hasMoreCards())
        {
            System.out.println(cardNumber + ": " + deck.deal());
            cardNumber++;
        }

    }
}
