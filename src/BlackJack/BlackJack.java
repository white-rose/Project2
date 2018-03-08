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

            if (player.getCount() > highest)
                winner = player;

        }

        return winner;

    }

    public static void main (String[] args ) {

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
            players.add(new Player(k));
        }

        boolean gameOver = false;

        while (activePlayers > 1) {

            for (Player player : players) {

                if (!gameOver && player.isStillInGame()) {

                    System.out.println("Player " + player.getName() + " , Do you want to Hit(1) or Stand(2)?");
                    int choice = scanner.nextInt();

                    switch (choice) {

                        case 1:
                            Card cardDealt = hit();
                            player.setCount(player.getCount() + cardDealt.getFace());
                            System.out.println(player.getCount());
                            if (player.getCount() > 21) {
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

    public boolean isStillInGame() {
        return stillInGame;
    }

    public void setStillInGame(boolean stillInGame) {
        this.stillInGame = stillInGame;
    }
}
