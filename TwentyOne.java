/**
 * TwentyOne.java
 * Created by: Joon Kim, Aryan Abed
 * May 9, 2019
 * This is a game of twenty one which can be played with 3 players
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class TwentyOne {

    /** Removes an element (card) from an array (deck)
     * Created by Aryan, Joon
     * @param array         Array that an element is being removed from
     * @param removeIndex   Index of the element that is going to be removed
     */
    public static void remove(int[] array, int removeIndex){

        // Removes the element with removeIndex and copies the rest of the array by using for loop
        for(int i = removeIndex; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }

    }

    /** returns 1 if player won. returns -1 if computer won. returns 0 if none won.
     * Created by Aryan, Joon
     * @param player1Score          Score of player1
     * @param player2Score          Score of player2
     * @param player3Score          Score of player3
     * @param computerScore         Score of computer
     * @return player's number      index (identity) of the winner
     */
    public static int hasWon(int player1Score, int player2Score, int player3Score, int computerScore){

        //initialize skip to 0
        int skip = 0;

        if(player1Score == 21){
            skip++;
        }
        if(player2Score == 21){
            skip++;
        }
        if(player3Score == 21){
            skip++;
        }
        if(computerScore == 21){
            skip++;
        }

        if(skip > 1){
            return 0;
        } else {

            if(player1Score == 21){
                return 1;
            }
            else if(player2Score == 21){
                return 2;
            }
            else if(player3Score == 21) {
                return 3;
            }
            else  if(computerScore == 21){
                return 4;
            }

        }

        return -1;

    }

    /** This method chooses(draws) an element(card) form an array(deck)
     * Created by Aryan, Joon
     * @param deckNum is the array that an element is being chosen from.
     * @param deckSize is the size of the array
     * @param name is the name of the player who is drawing
     * @return the element(value of the card chosen)
     */
    public static int draw(int[] deckNum, int deckSize, String name){

        Scanner input = new Scanner(System.in);

        // generate a random number
        int index = (int) (Math.random()*deckSize - 1);
        // get the value of the card drawn
        int card = deckNum[index];

        // remove the element(card) chosen from the array(deck)
        remove(deckNum, index);

        if(index <= 3) { // if the card is an Ace

            if (index % 4 == 0) {
                System.out.println(name + "'s card: Ace of clubs");
            } else if (index % 4 == 1) {
                System.out.println(name + "'s card: Ace of diamonds");
            } else if (index % 4 == 2) {
                System.out.println(name + "'s card: Ace of hearts");
            } else {
                System.out.println(name + "'s card: Ace of spades");
            }

            System.out.println("Do you want the value to be 1 or 11?");

            return input.nextInt();

        }else if(index < 40) { // if it is a non-face card

            if (index % 4 == 0) {
                System.out.println(name + "'s card: " + card + " of clubs");
            } else if (index % 4 == 1) {
                System.out.println(name + "'s card: " + card + " of diamonds");
            } else if (index % 4 == 2) {
                System.out.println(name + "'s card: " + card + " of hearts");
            } else {
                System.out.println(name + "'s card: " + card + " of spades");
            }

        } else if(index >= 40 && index <= 43){ // if it is a King

            if (index % 4 == 0) {
                System.out.println(name + "'s card: King of clubs");
            } else if (index % 4 == 1) {
                System.out.println(name + "'s card: King of diamonds");
            } else if (index % 4 == 2) {
                System.out.println(name + "'s card: King of hearts");
            } else {
                System.out.println(name + "'s card: King of spades");
            }

        } else if(index >= 44 && index <= 47){ // if it is a Queen

            if (index % 4 == 0) {
                System.out.println(name + "'s card: Queen of clubs");
            } else if (index % 4 == 1) {
                System.out.println(name + "'s card: Queen of diamonds");
            } else if (index % 4 == 2) {
                System.out.println(name + "'s card: Queen of hearts");
            } else {
                System.out.println(name + "'s card: Queen of spades");
            }

        } else {

            if (index % 4 == 0) { // if it is Jack
                System.out.println(name + "'s card: Jack of clubs");
            } else if (index % 4 == 1) {
                System.out.println(name + "'s card: Jack of diamonds");
            } else if (index % 4 == 2) {
                System.out.println(name + "'s card: Jack of hearts");
            } else {
                System.out.println(name + "'s card: Jack of spades");
            }

        }

        // return the value of the card
        return card;

    }

    /**
     * this method draws a card for the computer from the deck
     * Created by Joon, Aryan
     * @param deckNum is the array the card is being chosen from
     * @param deckSize size of the deck of cards
     * @return the value of the card chosen
     */
    public static int computerDraw(int[] deckNum, int deckSize){

        // generate a random number
        int index = (int) (Math.random()*deckSize - 1);
        // get the value of the card drawn
        int card = deckNum[index];

        // remove the element(card) chosen from the array(deck)
        remove(deckNum, index);

        if(index <= 3) { // if the card is an Ace

            if (index % 4 == 0) {
                System.out.println("Computer's card: Ace of clubs");
            } else if (index % 4 == 1) {
                System.out.println("Computer's card: Ace of diamonds");
            } else if (index % 4 == 2) {
                System.out.println("Computer's card: Ace of hearts");
            } else {
                System.out.println("Computer's card: Ace of spades");
            }

        }else if(index < 40) { // if it is a non-face card

            if (index % 4 == 0) {
                System.out.println("Computer's card: " + card + " of clubs");
            } else if (index % 4 == 1) {
                System.out.println("Computer's card: " + card + " of diamonds");
            } else if (index % 4 == 2) {
                System.out.println("Computer's card: " + card + " of hearts");
            } else {
                System.out.println("Computer's card: " + card + " of spades");
            }

        } else if(index >= 40 && index <= 43){ // if it is a King

            if (index % 4 == 0) {
                System.out.println("Computer's card: King of clubs");
            } else if (index % 4 == 1) {
                System.out.println("Computer's card: King of diamonds");
            } else if (index % 4 == 2) {
                System.out.println("Computer's card: King of hearts");
            } else {
                System.out.println("Computer's card: King of spades");
            }

        } else if(index >= 44 && index <= 47){ // if it is a Queen

            if (index % 4 == 0) {
                System.out.println("Computer's card: Queen of clubs");
            } else if (index % 4 == 1) {
                System.out.println("Computer's card: Queen of diamonds");
            } else if (index % 4 == 2) {
                System.out.println("Computer's card: Queen of hearts");
            } else {
                System.out.println("Computer's card: Queen of spades");
            }

        } else {

            if (index % 4 == 0) { // if it is Jack
                System.out.println("Computer's card: Jack of clubs");
            } else if (index % 4 == 1) {
                System.out.println("Computer's card: Jack of diamonds");
            } else if (index % 4 == 2) {
                System.out.println("Computer's card: Jack of hearts");
            } else {
                System.out.println("Computer's card: Jack of spades");
            }

        }

        // return the value of the card
        return card;

    }

    /**
     * this method makes the decisions for the computer
     * Created by Joon, Aryan
     * @param array the array the card is being chosen from
     * @param deckSize the size of the deck of cards
     * @param total sum of the cards of the computer
     * @return the value of the card drawn
     */
    public static int computerThink(int[] array, int deckSize, int total){

        if(total <= 14){
            int card = computerDraw(array, deckSize);
            if(card == 1){
                if(total <= 10){
                    return 11;
                }else {
                    return 1;
                }
            }else {
                return card;
            }
        }
        return 0;
    }

    public static void main(String[] args)throws IOException{

        Scanner input = new Scanner (System.in); // initialize Scanner object

        char inPlay = 'y';

        String path = "TwentyOne.txt"; // path of winners text file
        String rulesPath = "GameRule.txt"; // path of game rules text file

        File myFile = new File(path); // crate File object
        File ruleFile = new File(rulesPath);

        if(!myFile.isFile()){ // if file doesn't exist, create it
            PrintWriter writer = new PrintWriter(path, "UTF-8");
        }

        FileReader fr = new FileReader(path);
        LineNumberReader lr = new LineNumberReader(fr); // initialize LineNumberReader to determine number of lines in a text file



        while (inPlay == 'y') {

            int deckSize = 51; // initial size of the deck

            // players card total
            int player1Total = 0;
            int player2Total = 0;
            int player3Total = 0;
            int computerTotal = 0;

            // is the player playing
            boolean player1Playing = true;
            boolean player2Playing = true;
            boolean player3Playing = true;
            boolean computerPlaying = true;

            // is the game itself running
            boolean isRunning = true;

            // name of the winner
            String winner = "N/A";

            // number of players not eliminated
            int numPlayer = 3;

            // initialize the deck of cards
            int[] deckValue = {1, 1, 1, 1,
                    2, 2, 2, 2,
                    3, 3, 3, 3,
                    4, 4, 4, 4,
                    5, 5, 5, 5,
                    6, 6, 6, 6,
                    7, 7, 7, 7,
                    8, 8, 8, 8,
                    9, 9, 9, 9,
                    10, 10, 10, 10,
                    10, 10, 10, 10,
                    10, 10, 10, 10,
                    10, 10, 10, 10};

            // ask what the user wants to do
            System.out.println("1. Play");
            System.out.println("2. How To Play");
            System.out.println("3. Previous Winners");

            int option = input.nextInt();

            if (option == 2) { // display rules
                Scanner reader = new Scanner(ruleFile);
                while(reader.hasNext()){
                    System.out.println(reader.nextLine());
                }
                input.nextLine();

            } else if(option == 3) {

                if(myFile.length() == 0){ // if file is empty
                    System.out.println("No scores recorded");
                } else{
                    while(lr.skip(Long.MAX_VALUE) > 0){
                        // loop to go through all the lines
                    }
                    int numLines = lr.getLineNumber(); // number of lines

                    System.out.println("NOTE: N/A means that round was not finished.");
                    for(int i = 2; i <= numLines; i+=4){ // lines where the name of the winner is
                        System.out.println(Files.readAllLines(Paths.get(path)).get(i).substring(22)); // ouput the number of winner
                    }
                }

                System.out.println("Press Enter to play");
                input.nextLine();

            }

            // ask for player names
            input.nextLine();
            System.out.print("Player 1 name: ");
            String player1 = input.nextLine();
            System.out.print("Player 2 name: ");
            String player2 = input.nextLine();
            System.out.print("Player 3 name: ");
            String player3 = input.nextLine();

            // draw the first two cards
            player1Total += draw(deckValue, deckSize, player1);
            deckSize--;
            player2Total += draw(deckValue, deckSize, player2);
            deckSize--;
            player3Total += draw(deckValue, deckSize, player3);
            deckSize--;
            computerTotal += computerThink(deckValue, deckSize, computerTotal);
            deckSize--;
            player1Total += draw(deckValue, deckSize, player1);
            deckSize--;
            player2Total += draw(deckValue, deckSize, player2);
            deckSize--;
            player3Total += draw(deckValue, deckSize, player3);
            deckSize--;
            computerTotal += computerThink(deckValue, deckSize, computerTotal);
            deckSize--;

            // display players' total score
            System.out.println(player1 + "'s total: " + player1Total);
            System.out.println(player2 + "'s total: " + player2Total);
            System.out.println(player3 + "'s total: " + player3Total);
            System.out.println("Computer's total: " + computerTotal);

            // check if the total of the first two cards are 21
            if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 0) {
                System.out.println("Draw");
                winner = "Draw";
                isRunning = false;
            } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 1) {
                System.out.println(player1 + " has won!");
                winner = player1;
                isRunning = false;
            } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 2) {
                System.out.println(player2 + " has won!");
                winner = player2;
                isRunning = false;
            } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 3) {
                System.out.println(player3 + " has won!");
                winner = player3;
                isRunning = false;
            } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 4) {
                System.out.println("Computer has won!");
                winner = "Computer";
                isRunning = false;
            }

            while (isRunning) { // while round is being played

                int skip = 0; // number of skips

                if (player1Playing) {

                    System.out.println(player1 + "'s Turn");
                    System.out.println("Press 1 to skip. Press 2 to draw");

                    option = input.nextInt();

                    if (option == 2) {
                        player1Total += draw(deckValue, deckSize, player1);
                        deckSize--;
                    } else {
                        skip++;
                    }

                }

                if (player2Playing) {

                    System.out.println(player2 + "'s Turn");
                    System.out.println("Press 1 to skip. Press 2 to draw");

                    option = input.nextInt();

                    if (option == 2) {
                        player2Total += draw(deckValue, deckSize, player2);
                        deckSize--;
                    } else {
                        skip++;
                    }

                }

                if (player3Playing) {

                    System.out.println(player3 + "'s Turn");
                    System.out.println("Press 1 to skip. Press 2 to draw");

                    option = input.nextInt();

                    if (option == 2) {
                        player3Total += draw(deckValue, deckSize, player3);
                        deckSize--;
                    } else {
                        skip++;
                    }

                }

                if (computerPlaying) {

                    System.out.println("Computer's Turn");

                    computerTotal += computerThink(deckValue, deckSize, computerTotal);
                    deckSize--;

                }

                System.out.println("Press Enter to continue...");
                input.nextLine();


                // if players exceed 21, eliminate them
                if (player1Total > 21) {
                    player1Playing = false;
                    numPlayer--;
                    player1Total = 0;
                    System.out.println(player1 + " is eliminated");
                }
                if (player2Total > 21) {
                    player2Playing = false;
                    numPlayer--;
                    player2Total = 0;
                    System.out.println(player2 + " is eliminated");
                }
                if (player3Total > 21) {
                    player3Playing = false;
                    numPlayer--;
                    player3Total = 0;
                    System.out.println(player3 + " is eliminated");
                }
                if (computerTotal > 21) {
                    computerPlaying = false;
                    computerTotal = 0;
                    System.out.println("Computer is eliminated");
                }


                // display players' total sore
                System.out.println(player1 + "'s total: " + player1Total);
                System.out.println(player2 + "'s total: " + player2Total);
                System.out.println(player3 + "'s total: " + player3Total);
                System.out.println("Computer's total: " + computerTotal);

                if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 0) {
                    System.out.println("Draw");
                    isRunning = false;
                    winner = "Draw";
                } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 1) {
                    System.out.println(player1 + " has won!");
                    isRunning = false;
                    winner = player1;
                } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 2) {
                    System.out.println(player2 + " has won!");
                    isRunning = false;
                    winner = player2;
                } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 3) {
                    System.out.println(player3 + " has won!");
                    isRunning = false;
                    winner = player3;
                } else if (hasWon(player1Total, player2Total, player3Total, computerTotal) == 4) {
                    System.out.println("Computer has won!");
                    isRunning = false;
                    winner = "Computer";
                }

                // if everyone but one player is eliminated, declare him/her the winner
                if (player1Playing && !player2Playing && !player3Playing && !computerPlaying) {
                    System.out.println(player1 + " wins! because others were eliminated");
                    isRunning = false;
                    winner = player1;
                } else if (player2Playing && !player1Playing && !player3Playing && !computerPlaying) {
                    System.out.println(player2 + " wins! because others were eliminated");
                    isRunning = false;
                    winner = player2;
                } else if (player3Playing && !player1Playing && !player2Playing && !computerPlaying) {
                    System.out.println(player3 + " wins! because others were eliminated");
                    isRunning = false;
                    winner = player3;
                } else if (computerPlaying && !player1Playing && !player2Playing && !player3Playing) {
                    System.out.println("Computer wins! because others were eliminated");
                    isRunning = false;
                    winner = "Computer";
                } else if (!computerPlaying && !player1Playing && !player2Playing && !player3Playing) {
                    System.out.println("Draw! Everyone were eliminated");
                    isRunning = false;
                    winner = "Draw";
                }

                // if all the cards are played or everyone choose to skip declare the player with highest score wins
                if (deckSize == 0 || skip == numPlayer) {
                    if (player1Total < 22 && player1Total > player2Total && player1Total > player3Total && player1Total > computerTotal) {
                        System.out.println(player1 + " wins!");
                        winner = player1;
                        isRunning = false;
                    } else if (player2Total < 22 && player2Total > player1Total && player2Total > player3Total && player2Total > computerTotal) {
                        System.out.println(player2 + " wins!");
                        winner = player2;
                        isRunning = false;
                    } else if (player3Total < 22 && player3Total > player1Total && player3Total > player2Total && player3Total > computerTotal) {
                        System.out.println(player3 + " wins!");
                        winner = player3;
                        isRunning = false;
                    } else if (computerTotal < 22 && computerTotal > player1Total && computerTotal > player2Total && computerTotal > player3Total) {
                        System.out.println("Computer wins!");
                        winner = "Computer";
                        isRunning = false;
                    } else {
                        System.out.println("Draw");
                        winner = "Draw";
                        isRunning = false;
                    }
                }

            } // end of isRunning loop

            // Congratulations message
            System.out.println("Congratulations " + winner + "! Would you like to play again? (yes/no)");
            inPlay = Character.toLowerCase(input.next().charAt(0));
            while (inPlay !='y' && inPlay !='n'){ // ask if the user wants to play more
                System.out.println("Please answer again by responding in y or n"); //Ask the user to input their will to play or not correctly
                inPlay = Character.toLowerCase(input.next().charAt(0));
            }//while inplay is invalid

            if (inPlay == 'n'){ // display a goodbye message
                System.out.println("Thanks for playing");
            }


            // get the time of the round played
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            FileWriter fw = new FileWriter(myFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            // write the name of the players, the winner and the time played in a text file
            out.println("Played at: " + ts);
            out.println("Players in this round: " + player1 + " " + player2 + " " + player3 + " computer");
            out.println("Winner of this round: " + winner);
            out.println("_________________________________________________________________________________");
            out.close();

        } // end of inPlay loop

    } // end of main
}