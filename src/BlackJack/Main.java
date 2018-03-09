package BlackJack;

public class Main {

    public static void main (String[] args) {

        Hand hand = new Hand();
        hand.cards.add(new Card());
        hand.cards.add(new Card());
        hand.cards.add(new Card());

        System.out.println(hand.toString());

    }

}
