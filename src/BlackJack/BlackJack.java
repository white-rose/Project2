package BlackJack;

import base.Card;
import base.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    static DeckOfCards deckOfCards = new DeckOfCards();
    static int numberOfPlayers = 0;
    static int activePlayers = 0;
    static Player winner, loser;
    static List<Player> players = new ArrayList();

    static Card hit() {

        return deckOfCards.deal();

    }

    static Player determineWinner() {

        Player winner = null;
        int highest = 0;

        for (Player player : players) {

            if (player.hand.getHandCount() > highest)
                winner = player;

        }

        return winner;

    }

    public static void main (String[] args ) {

        boolean gameOver = false;

        deckOfCards.shuffle();

        Scanner scanner = new Scanner(System.in);

        while (numberOfPlayers < 2) {
            System.out.println("How many players are playing this game?");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers < 2)
                System.out.println("Number of players have to be greater than 1");
        }

        activePlayers = numberOfPlayers;

        for (int k = 0; k < numberOfPlayers; k++) {
            Card cardDealt = hit();
            Player player = new Player(k);
            //Deal 2 cards in the beginning to each Player
            player.hand.cards.add(cardDealt);
            player.hand.cards.add(cardDealt);
            System.out.println("The hand count for Player " + player.getName() + " is " + player.hand.getHandCount());
            //Add player to game
            players.add(player);
        }

        while (activePlayers > 1) {

            for (Player player : players) {

                if (!gameOver && player.isStillInGame()) {

                    System.out.println("Player " + player.getName() + " , Do you want to Hit(1) or Stand(2)?");
                    int choice = scanner.nextInt();

                    switch (choice) {

                        case 1:
                            //Deal card
                            player.hand.cards.add(hit());
                            System.out.println(player.hand.getHandCount());
                            if (player.hand.getHandCount() > 21) {
                                loser = player;
                                gameOver = true;
                            }
                            break;

                        case 2:
                            player.stillInGame = false;
                            activePlayers--;
                            break;

                        default:
                            System.out.println("That was an invalid choice");
                            break;
                    }
                }
            }
        }


        System.out.println("The game is over. \nThe winner is player " + determineWinner().getName());

    }

}

class Player {

    boolean stillInGame = true;
    public int name;
    Hand hand;

    Player(int name) {
        this.hand = new Hand();
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean isStillInGame() {
        return stillInGame;
    }

    public void setStillInGame(boolean stillInGame) {
        this.stillInGame = stillInGame;
    }

}
