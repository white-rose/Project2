package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    private static void determineWinners() {

        int highest = 0;

        List<Player> playersNotBusted = players.stream()
                .filter(player ->  player.hand.getHandCount() < 22)
                .collect(Collectors.toList());

        for (Player player : players) {
            if (player.hand.getHandCount() > highest) {
                highest = player.hand.getHandCount();
            }
        }

        int indexOfWinner = 0;
        int numberOfWinners = 0;
        for (Player player : playersNotBusted) {
            if (player.hand.getHandCount() == highest) {
                numberOfWinners++;
                indexOfWinner = playersNotBusted.indexOf(player);
            } else {
                player.losses++;
            }
        }

        if (numberOfWinners > 1) {
            System.out.println("There is a tie");
        } else {
            players.get(indexOfWinner).wins++;
            System.out.println("The winner is player " + players.get(indexOfWinner).getName());
        }

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

        for (int i = 0; i < numberOfPlayers; i++ ) {
            players.add(new Player(i + 1));
        }

        while (stillPlaying) {

            activePlayers = numberOfPlayers;

            //Deal the first two cards to each player
            for (Player player : players) {
                player.stillInGame = true;
                player.hand.clearHand();
                cardDealt = hit();
                player.hand.cards.add(cardDealt);
                cardDealt = hit();
                player.hand.cards.add(cardDealt);
                System.out.println("The hand count for Player " + player.getName() + " is " + player.hand.getHandCount());
                //Add player to game
            }

            while (activePlayers > 0) {

                for (Player player : players) {

                    if (player.isStillInGame()) {

                        System.out.println("Player " + player.getName() + " has " + player.wins + " wins, " + player.losses + " losses and their count is " + player.hand.getHandCount() + " , Do you want to Hit(1) or Stand(2)?");
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

            determineWinners();
            System.out.println("Do you want to play another game? Yes(1) No(Any other key)");
            if (!scanner.next().equals("1"))
                stillPlaying = false;
        }

    }

    static class Player {

        boolean stillInGame = true;
        private int name;
        int wins = 0, losses = 0;
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

}


