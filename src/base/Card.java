package base;

import java.util.Random;

public class Card {

    public static int ACE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, EIGHT = 8, NINE = 9, TEN = 10, JACK = 11, QUEEN = 12, KING = 13,
                CLUBS, DIAMONDS , SPADES, HEARTS;

    int faceValue;
    SUIT suit;

    int[] values  = new int[] {
            ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };

    SUIT[] faces = new SUIT[] {
            SUIT.DIAMOND, SUIT.CLUB, SUIT.HEART, SUIT.SPADE
    };

    Card() {

        Random random = new Random();
        this.suit = faces[random.nextInt(4)];
        this.faceValue = values[random.nextInt(12)];

    }

    Card(int faceValue, SUIT suitValue) {

        this.faceValue = faceValue;
        this.suit = suitValue;

    }

    public int getFace() {
        return this.faceValue;
    }

    public String getFaceName() {
        return this.suit.name();
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




