package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {


    private static DeckOfCards deckOfCards = new DeckOfCards();
    private static List<Player> players = new ArrayList<>();

    private static Card hit() {
        Scanner scanner = new Scanner(System.in);
        Boolean done = false;

        Card cardDealt;
        cardDealt = deckOfCards.deal();
        if (cardDealt.face.name().equals("ACE")) {

            while (!done) {
                System.out.println("Do you want the ACE to have the value of a 1 or 11?");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    cardDealt.face.setValue(1);
                    done = true;
                } else if (answer == 11) {
                    cardDealt.face.setValue(11);
                    done = true;
                } else {
                    System.out.println("That is not a valid answer");
                }
            }
        }

        return cardDealt;

    }

    private static Player determineWinner() {


        int indexOfWinner = 0;
        int highest = 0;

        for (Player player : players) {

            if (player.hand.getHandCount() > highest && player.hand.getHandCount() < 22) {
                indexOfWinner = players.indexOf(player);
                highest = player.hand.getHandCount();
            }

        }

        players.get(indexOfWinner).wins++;
        return players.get(indexOfWinner);

    }

    public static void main (String[] args) {

        boolean stillPlaying = true;

        deckOfCards.shuffle();

        Card cardDealt;

        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = 0;
        int activePlayers;

        while (numberOfPlayers < 2) {
            System.out.println("How many players are playing this game?");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers < 2)
                System.out.println("Number of players have to be greater than 1");
        }

        activePlayers = numberOfPlayers;

        for (int k = 0; k < numberOfPlayers; k++) {
            Player player = new Player(k);
            //Deal 2 cards in the beginning to each Player
            cardDealt = hit();
            player.hand.cards.add(cardDealt);
            cardDealt = hit();
            player.hand.cards.add(cardDealt);
            System.out.println("The hand count for Player " + player.getName() + " is " + player.hand.getHandCount());
            //Add player to game
            players.add(player);
        }

            activePlayers = numberOfPlayers;
            for (Player player : players) {
                player.stillInGame = true;
            }
            while (activePlayers > 0) {

                for (Player player : players) {

                    if (player.isStillInGame()) {

                        System.out.println("Player " + player.getName() + " has " + player.wins + " wins and their count is " + player.hand.getHandCount() + " , Do you want to Hit(1) or Stand(2)?");
                        int choice = scanner.nextInt();

                        //Handles Hit and Stand
                        switch (choice) {

                            case 1:
                                //Deal card (hit)
                                player.hand.cards.add(hit());
                                System.out.println("The hand count for player " + player.getName() + " is now " + player.hand.getHandCount());
                                if (player.hand.getHandCount() > 21) {
                                    System.out.println("Player " + player.getName() + " has busted");
                                    player.stillInGame = false;
                                    activePlayers--;
                                    player.losses--;
                                }
                                break;

                            case 2:
                                //Player chooses to stand
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


            System.out.println("The winner is player " + determineWinner().getName());

    }

}

class Player {

    boolean stillInGame = true;
    public int name;
    int wins = 0 , losses = 0;
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
