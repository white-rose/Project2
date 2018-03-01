package base;

import java.util.Collections;
import java.util.Stack;

public class DeckOfCards {

    Stack<Card> deck = new Stack();

    public DeckOfCards() {

        deck.push(new Card(Card.ACE, SUIT.DIAMOND));
        deck.push(new Card(Card.TWO, SUIT.DIAMOND));
        deck.push(new Card(Card.THREE, SUIT.DIAMOND));
        deck.push(new Card(Card.FOUR, SUIT.DIAMOND));
        deck.push(new Card(Card.FIVE, SUIT.DIAMOND));
        deck.push(new Card(Card.SIX, SUIT.DIAMOND));
        deck.push(new Card(Card.SEVEN, SUIT.DIAMOND));
        deck.push(new Card(Card.EIGHT, SUIT.DIAMOND));
        deck.push(new Card(Card.NINE, SUIT.DIAMOND));
        deck.push(new Card(Card.TEN, SUIT.DIAMOND));
        deck.push(new Card(Card.JACK, SUIT.DIAMOND));
        deck.push(new Card(Card.QUEEN, SUIT.DIAMOND));
        deck.push(new Card(Card.KING, SUIT.DIAMOND));

        deck.push(new Card(Card.ACE, SUIT.HEART));
        deck.push(new Card(Card.TWO, SUIT.HEART));
        deck.push(new Card(Card.THREE, SUIT.HEART));
        deck.push(new Card(Card.FOUR, SUIT.HEART));
        deck.push(new Card(Card.FIVE, SUIT.HEART));
        deck.push(new Card(Card.SIX, SUIT.HEART));
        deck.push(new Card(Card.SEVEN, SUIT.HEART));
        deck.push(new Card(Card.EIGHT, SUIT.HEART));
        deck.push(new Card(Card.NINE, SUIT.HEART));
        deck.push(new Card(Card.TEN, SUIT.HEART));
        deck.push(new Card(Card.JACK, SUIT.HEART));
        deck.push(new Card(Card.QUEEN, SUIT.HEART));
        deck.push(new Card(Card.KING, SUIT.HEART));

        deck.push(new Card(Card.ACE, SUIT.CLUB));
        deck.push(new Card(Card.TWO, SUIT.CLUB));
        deck.push(new Card(Card.THREE, SUIT.CLUB));
        deck.push(new Card(Card.FOUR, SUIT.CLUB));
        deck.push(new Card(Card.FIVE, SUIT.CLUB));
        deck.push(new Card(Card.SIX, SUIT.CLUB));
        deck.push(new Card(Card.SEVEN, SUIT.CLUB));
        deck.push(new Card(Card.EIGHT, SUIT.CLUB));
        deck.push(new Card(Card.NINE, SUIT.CLUB));
        deck.push(new Card(Card.TEN, SUIT.CLUB));
        deck.push(new Card(Card.JACK, SUIT.CLUB));
        deck.push(new Card(Card.QUEEN, SUIT.CLUB));
        deck.push(new Card(Card.KING, SUIT.CLUB));

        deck.push(new Card(Card.ACE, SUIT.SPADE));
        deck.push(new Card(Card.TWO, SUIT.SPADE));
        deck.push(new Card(Card.THREE, SUIT.SPADE));
        deck.push(new Card(Card.FOUR, SUIT.SPADE));
        deck.push(new Card(Card.FIVE, SUIT.SPADE));
        deck.push(new Card(Card.SIX, SUIT.SPADE));
        deck.push(new Card(Card.SEVEN, SUIT.SPADE));
        deck.push(new Card(Card.EIGHT, SUIT.SPADE));
        deck.push(new Card(Card.NINE, SUIT.SPADE));
        deck.push(new Card(Card.TEN, SUIT.SPADE));
        deck.push(new Card(Card.JACK, SUIT.SPADE));
        deck.push(new Card(Card.QUEEN, SUIT.SPADE));
        deck.push(new Card(Card.KING, SUIT.SPADE));

    }

    public Card deal() {

        return deck.pop();

    }

    public int getNumCardsInDeck() {
        return deck.size();
    }

    public boolean hasMoreCards() {
        if (deck.isEmpty())
            return false;
        else
            return true;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

}
