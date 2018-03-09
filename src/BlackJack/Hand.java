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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        return "The cards in the hand are the following : \n" + sb.toString();
    }
}
