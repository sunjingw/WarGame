/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CS
 */
public class War extends Game {

    private ArrayList<Card> deal1;
    private ArrayList<Card> deal2;
   
    private int count;
    private int warCount;
    private int p1Wins;
    private int p2Wins;
    private int p1WarWins;
    private int p2WarWins;
        
    public War(String name) {
        super(name);
    }
    
    @Override
    public void declareWinner() {
        
    }
    
    @Override
    public void play(ArrayList<Card> list1, ArrayList<Card> list2) {

        this.deal1 = list1;
        this.deal2 = list2;
        boolean round = true;
        int count = 0;
        String p1 = super.getPlayers().get(0).getPlayerID();
        String p2 = super.getPlayers().get(1).getPlayerID();
        int warCount = 0;
        int p1Wins = 0;
        int p2Wins = 0;
        int p1WarWins = 0;
        int p2WarWins = 0;

       do {

            if (deal1.size() > 0 && deal2.size() > 0) {

                System.out.println("=======================");
                System.out.println("Round " + (count + 1));
                System.out.println("=======================");
                System.out.println("Player " + super.getPlayers().get(0).getPlayerID() + " " + deal1.get(0));
                System.out.println("Player " + super.getPlayers().get(1).getPlayerID() + " " + deal2.get(0));

                if (deal1.get(0).getCard() > deal2.get(0).getCard()) {

                    System.out.println(super.getPlayers().get(0).getPlayerID() + " won\n");
                    deal1.add(deal1.get(0));
                    deal1.add(deal2.get(0));
                    deal1.remove(0);
                    deal2.remove(0);
                    System.out.println(super.getPlayers().get(0).getPlayerID() + " has " + deal1.size() + " cards");
                    System.out.println(super.getPlayers().get(1).getPlayerID() + " has " + deal2.size() + " cards");

                    p1Wins++;

                } else if (deal1.get(0).getCard() == deal2.get(0).getCard()) {

                    warCount++;

                    if (deal1.size() > 4 && deal2.size() > 4) {

                        System.out.println("Commence WAR... Placing three cards face down from each player");
                        System.out.println("Revealing the fourth card...");
                        System.out.println(p1 + ": " + deal1.get(4).toString());
                        System.out.println(p2 + ": " + deal2.get(4).toString());

                        if (deal1.get(4).getCard() > deal2.get(4).getCard()) {

                            System.out.println(p1 + " won\n");

                            for (int i = 0; i < 5; i++) {
                                deal1.add(deal2.get(i));
                                deal1.add(deal1.get(i));
                                deal2.remove(i);
                                deal1.remove(i);
                            }
                            p1WarWins++;

                            System.out.println(p1 + " has " + deal1.size() + " cards");
                            System.out.println(p2 + " has " + deal2.size() + " cards");

                        } else if (deal2.get(4).getCard() > deal1.get(4).getCard()) {

                            System.out.println(p2 + " won\n");

                            for (int i = 0; i < 5; i++) {
                                deal2.add(deal2.get(i));
                                deal2.add(deal1.get(i));
                                deal2.remove(i);
                                deal1.remove(i);
                            }
                            p2WarWins++;

                            System.out.println(p1 + " has " + deal1.size() + " cards");
                            System.out.println(p2 + " has " + deal2.size() + " cards");

                        } else if (deal1.get(4).getCard() == deal2.get(4).getCard()) {

                            warCount++;

                            if (deal1.size() > 8 && deal2.size() > 8) {

                                System.out.println("WAR AGAIN!");
                                System.out.println("Place three new cards face down from each player...");
                                System.out.println("Revealing the face up card");
                                System.out.println(p1 + ": " + deal1.get(9).toString());
                                System.out.println(p2 + ": " + deal2.get(9).toString());

                                if (deal1.get(9).getCard() > deal2.get(9).getCard()) {
                                    System.out.println(p1 + " won all 10 cards");

                                    for (int i = 0; i < 10; i++) {
                                        deal1.add(deal2.get(i));
                                        deal1.add(deal1.get(i));
                                        deal2.remove(i);
                                        deal1.remove(i);
                                    }
                                    p1WarWins++;

                                } else if (deal2.get(9).getCard() > deal1.get(9).getCard()) {
                                    System.out.println(p2 + " won all 10 cards");

                                    for (int i = 0; i < 10; i++) {
                                        deal2.add(deal2.get(i));
                                        deal2.add(deal1.get(i));
                                        deal2.remove(i);
                                        deal1.remove(i);
                                    }
                                    p2WarWins++;

                                } else {
                                    System.out.println("What are the odds...");
                                    System.exit(0); //third war not happening
                                }

                            } else if (deal1.size() < 9 || deal2.size() < 9) {
                                System.out.println("GAME OVER");
                                if (deal1.size() < 9) {
                                    System.out.println("Not enough cards left for " + p1);
                                    System.out.println(p2 + " WINS");
                                    round = false;

                                } else if (deal2.size() < 9) {
                                    System.out.println("Not enough cards left for " + p2);
                                    System.out.println(p1 + " WINS");
                                    round = false;
                                }
                            }

                        }
                    } else if (deal1.size() < 5 || deal2.size() < 5) {
                        System.out.println("GAME OVER");

                        if (deal1.size() < 5) {
                            System.out.println(p1 + " ran out of cards!");
                            System.out.println(p2 + " WINNER");
                            round = false;
                        } else if (deal2.size() < 5) {
                            System.out.println(p2 + " ran out of cards!");
                            System.out.println(p1 + " WINNER");
                            round = false;
                        }
                    }
                    
                    } else {
                        System.out.println(super.getPlayers().get(1).getPlayerID() + " won\n");
                        deal2.add(deal1.get(0));
                        deal2.add(deal2.get(0));
                        deal2.remove(0);
                        deal1.remove(0);
                        p2Wins++;

                        System.out.println(super.getPlayers().get(0).getPlayerID() + " has " + deal1.size() + " cards");
                        System.out.println(super.getPlayers().get(1).getPlayerID() + " has " + deal2.size() + " cards");
                    }

                } else {
                    System.out.println("GAME OVER");

                    if (deal1.size() == 0) {
                        System.out.println(p1 + " ran out of cards!");
                        System.out.println(super.getPlayers().get(1).getPlayerID() + " WINNER");
                        round = false;
                    } else if (deal2.size() == 0) {
                        System.out.println(p2 + " ran out of cards!");
                        System.out.println(super.getPlayers().get(0).getPlayerID() + " WINNER");
                        round = false;
                    }
                }
                count++;
            } while(round == true);
       

            //Results
            System.out.println("Player " + p1 + " won: " + p1Wins + " times | Player " + p2 + " won: " + p2Wins + " times");
            System.out.println("War happened: " + warCount + " times");
            System.out.println("Player " + p1 + " won: " + p1WarWins + " wars | Player " + p2 + " won: " + p2WarWins + " wars");
        }

    

    public static void main(String[] args) {

        //create a new game called War
        Game war = new War("War");
        //create a new deck of cards
        GroupOfCards cards = new GroupOfCards();
        //create a list of players
        ArrayList<Player> playerList = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        //input player names
        System.out.println("Enter first player's name: ");
        String player1 = input.nextLine();
        Player p1 = new Player(player1);
        System.out.println("Enter second player's name: ");
        String player2 = input.nextLine();
        Player p2 = new Player(player2);

        //add players to the playerList
        playerList.add(p1);
        playerList.add(p2);
        System.out.println(player1 + " vs " + player2);

        //pass the playerList to the Game class
        war.setPlayers(playerList);

        //shuffle and deal the cards
        System.out.println("Shuffling and dealing cards...");
        cards.generateHand(); //create 52 unique cards
        cards.shuffle(); //shuffle
        cards.dealHand(); //deal 26 cards to each player

        //display each player's drawn cards
        System.out.println("Player " + p1.getPlayerID() + " dealt: \n" + cards.playerOneCards());
        System.out.println("Player " + p2.getPlayerID() + " dealt: \n" + cards.playerTwoCards());

        //play the game with two dealt hands
        war.play(cards.playerOneCards(), cards.playerTwoCards());

        
    }

}
