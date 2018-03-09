package BlackJack;

import java.util.ArrayList;

public class Hand {

    public ArrayList<Card> cards = new ArrayList<>();

    int getHandCount() {

        int handCountTotal = 0;

        for (Card card : cards) {
            handCountTotal += card.getFace();
        }

        return handCountTotal;
    }

}
