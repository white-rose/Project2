package BlackJack;

import java.util.Random;

public class Card {

    public static final int ACE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, EIGHT = 8, NINE = 9, TEN = 10, JACK = 10, QUEEN = 10, KING = 10,
            CLUBS = 11, DIAMONDS = 12, HEARTS = 13, SPADES = 14;

    int faceValue;
    SUIT suit;

    Card() {

        int[] possibleValues  = new int[] {
                ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
        };

        SUIT[] possibleFaces = new SUIT[] {
                SUIT.DIAMOND, SUIT.CLUB, SUIT.HEART, SUIT.SPADE
        };

        Random random = new Random();
        this.suit = possibleFaces[random.nextInt(4)];
        this.faceValue = possibleValues[random.nextInt(12)];

    }

    Card(int faceValue, SUIT suitValue) {

        this.faceValue = faceValue;
        this.suit = suitValue;

    }

    public int getFace() {
        return this.faceValue;
    }

    public String getFaceName() {
        return "The facevalue";
    }

    public int getSuit() {
        return this.suit.value;
    }

    public String getSuitName() {
        return this.suit.name();
    }

    public boolean isHigherThan(Card card2) {
        if (this.faceValue > card2.faceValue)
            return true;
        else
            return false;
    }

    public boolean isHigherThan(Card card2, boolean aceHigh) {
        if (this.faceValue > card2.faceValue)
            return true;
        else
            return false;
    }

    public String toString() {

        return "The face of this card is " + this.faceValue + " and the value is " + this.faceValue;

    }

}

enum SUIT {

    DIAMOND(1), SPADE(2), HEART(3), CLUB(4);

    public int value;

    SUIT(int value) {
        this.value = value;
    }

}




