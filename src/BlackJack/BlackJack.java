package BlackJack;

import base.Card;
import base.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    static DeckOfCards deckOfCards = new DeckOfCards();

    static Card hit() {

        return deckOfCards.deal();

    }

    public static void main () {

        Scanner scanner = new Scanner(System.in);

        List<Player> players = new ArrayList();

        System.out.println("How many players are playing this game");
        int numberOfPlayers = scanner.nextInt();
        for (int k = 0; k < numberOfPlayers; k++) {
            players.add(new Player(k));
        }

        boolean gameOver = false;

        while (!gameOver) {

            for (Player player : players) {

                System.out.println("Player " + player.getName() + " , Do you want to Hit(1) or Stand(2)?");
                int choice = scanner.nextInt();
                switch (choice) {

                    case 1 :
                        Card cardDealt = hit();
                        player.setCount(player.getCount() + cardDealt.getFace());
                        if (player.getCount() > 21)
                            gameOver = true;
                        break;

                    case 2 :
                        break;

                    default:
                        System.out.println("That was an invalid choice");
                        break;
                }

            }

        }

    }

}

class Player {

    public int count, name;

    Player(int name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}