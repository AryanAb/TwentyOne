/**
 * TwentyOne.java
 * Aryan Abed-Esfahani and Joon Kim
 * May 6th 2019
 * Game of 21 (Get 21 points on first two cards)
 */
import java.util.Scanner;
public class TwentyOne {
  
  /* Removes an element (card) from an array (deck)
   * @param array         Array that an element is being removed from
   * @param removeIndex   Index of the element that is going to be removed
   */
  
  public static void remove(int[] array, int removeIndex){
    
    // Removes the element with removeIndex and copies the rest of the array by using for loop
    for(int i = removeIndex; i < array.length - 1; i++){
      array[i] = array[i + 1];
    }
    
  }
  
  /*returns 1 if player won. returns -1 if computer won. returns 0 if none won.
   * @param player1Score          Score of player1
   * @param player2Score          Score of player2
   * @param player3Score          Score of player3
   * @param computerScore         Score of computer
   * @return player's number      index (identity) of the winner
   */
  public static int hasWon(int player1Score, int player2Score, int player3Score, int computerScore){
    
    //initialize count to 0
    int count = 0;
    
    if(player1Score == 21){
      count++;
    }
    if(player2Score == 21){
      count++;
    }
    if(player3Score == 21){
      count++;
    }
    if(computerScore == 21){
      count++;
    }
    
    if(count > 1){
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
    
    // if the card is an Ace, print the Ace with corresponding suits
    if(index <= 3) { 
      
      if (index % 4 == 0) {
        System.out.println(name + "'s card: Ace of clubs");
      } else if (index % 4 == 1) {
        System.out.println(name + "'s card: Ace of diamonds");
      } else if (index % 4 == 2) {
        System.out.println(name + "'s card: Ace of hearts");
      } else {
        System.out.println(name + "'s card: Ace of spades");
      }
      
      System.out.println(name + ", do you want ace to be 1 or 11?");
      int aceValue = input.nextInt();
      while (aceValue != 1 && aceValue !=11){
        System.out.println("Please input 1 or 11");
        aceValue = input.nextInt();
      }
      return aceValue;
      
    }
    // else if the card is a non-face card, print the card number and suit
    else if(index < 40) { 
      
      if (index % 4 == 0) {
        System.out.println(name + "'s card: " + card + " of clubs");
      } else if (index % 4 == 1) {
        System.out.println(name + "'s card: " + card + " of diamonds");
      } else if (index % 4 == 2) {
        System.out.println(name + "'s card: " + card + " of hearts");
      } else {
        System.out.println(name + "'s card: " + card + " of spades");
      }
      
    } 
    // else if the card is a King card, print King and suit
    else if(index >= 40 && index <= 43){ 
      
      if (index % 4 == 0) {
        System.out.println(name + "'s card: King of clubs");
      } else if (index % 4 == 1) {
        System.out.println(name + "'s card: King of diamonds");
      } else if (index % 4 == 2) {
        System.out.println(name + "'s card: King of hearts");
      } else {
        System.out.println(name + "'s card: King of spades");
      }
      
    } 
    // else if the card is a Queen card, print Queen and suit
    else if(index >= 44 && index <= 47){ 
      
      if (index % 4 == 0) {
        System.out.println(name + "'s card: Queen of clubs");
      } else if (index % 4 == 1) {
        System.out.println(name + "'s card: Queen of diamonds");
      } else if (index % 4 == 2) {
        System.out.println(name + "'s card: Queen of hearts");
      } else {
        System.out.println(name + "'s card: Queen of spades");
      }
      
    } 
    // else the card is a Jack card, print Jack and suit
    else {
      
      if (index % 4 == 0) {
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
  
  public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    
    //Variables
    int deckSize = 51;
    int player1Total = 0;
    int player2Total = 0;
    int player3Total = 0;
    int computerTotal = 0;
    boolean player1Playing = true;
    boolean player2Playing = true;
    boolean player3Playing = true;
    boolean computerPlaying = true;
    boolean isRunning = true;
    char inPlay = 'y';
    
    while (inPlay == 'y'){
      int[] deckValue =   {1, 1, 1, 1,
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
      
      
      //Greet the player and give them and option to play or read the instruction first
      System.out.println("Welcome to game of TwentyOne!");
      System.out.println("1. Play");
      System.out.println("2. How To Play");
      
      int option = input.nextInt();
      
      //If the player chooses "how to play" print the rules of the game
      while (option !=1 && option!=2){
        System.out.println("Invalid input. Please enter 1 or 2");
        option= input.nextInt();
      }  
      if (option == 1){
        System.out.println("Let's begin!");
      }
      else if(option == 2) {
        
        System.out.println("Get 21 points on first two cards.");
        System.out.println("If the sum is less than 21, player can decide to draw one more card or skip(pass)");
        System.out.println("Reach a final score higher than the dealer (computer) without exceeding 21");
        System.out.println("Let the dealer draw additional cards until their hand exceeds 21");
        System.out.println("Press Enter to play");
        input.nextLine();
        
      }
      
      input.nextLine();
      
      //Ask the players to input their names
      System.out.print("Player 1 name: ");
      String player1 = input.nextLine();
      System.out.print("Player 2 name: ");
      String player2 = input.nextLine();
      System.out.print("Player 3 name: ");
      String player3 = input.nextLine();
      
      //Draw two cards for each player and calculate the total
      player1Total += draw(deckValue, deckSize, player1);
      deckSize--;
      player2Total += draw(deckValue, deckSize, player2);
      deckSize--;
      player3Total += draw(deckValue, deckSize, player3);
      deckSize--;
      computerTotal += draw( deckValue, deckSize, "Computer");
      deckSize--;
      player1Total += draw(deckValue, deckSize, player1);
      deckSize--;
      player2Total += draw(deckValue, deckSize, player2);
      deckSize--;
      player3Total += draw(deckValue, deckSize, player3);
      deckSize--;
      computerTotal += draw(deckValue, deckSize, "Computer");
      deckSize--;
      
      //Display the total score of first two cards
      System.out.println();
      System.out.println("Total");
      System.out.println(player1 + "'s total: " + player1Total);
      System.out.println(player2 + "'s total: " + player2Total);
      System.out.println(player3 + "'s total: " + player3Total);
      System.out.println("Computer's total: " + computerTotal);
      
      //Display the winner if any player got 21 in their first two cards
      if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 0){
        System.out.println("Draw");
        isRunning = false;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 1){
        System.out.println(player1 + " has won!");
        isRunning = false;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 2){
        System.out.println(player2 + " has won!");
        isRunning = false;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 3){
        System.out.println(player3 + " has won!");
        isRunning = false;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 4){
        System.out.println("Computer has won!");
        isRunning = false;
      }
      
      //While there is no winner in first two cards
      while(isRunning){
        
        //If player1 is still in the game, give player 1 to skip or draw
        if(player1Playing) {
          
          System.out.println(player1 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          
          if (option == 1 ){
            System.out.println("Skipped!");
          }
          //If player 1 chooses to draw, one more card given to player 1
          else if (option == 2) {
            player1Total += draw(deckValue, deckSize, player1);
            deckSize--;
          }
          
        }
        
        //If player2 is still in the game, give player2 to skip or draw
        if(player2Playing) {
          
          System.out.println(player2 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          if (option == 1 ){
            System.out.println("Skipped!");
          }       
          //If player2 chooses to draw, one more card given to player 2
          if (option == 2) {
            player2Total += draw(deckValue, deckSize, player2);
            deckSize--;
          }
          
        }
        
        //If player3 is still in the game, give player 3 to skip or draw
        if(player3Playing) {
          
          System.out.println(player3 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          if (option == 1 ){
            System.out.println("Skipped!");
          }       
          //If player 3 chooses to draw, one more card given to player 3
          if (option == 2) {
            player3Total += draw(deckValue, deckSize, player3);
            deckSize--;
          }
          
        }
        
        //If computer is still in game, computer draws one more card
        if(computerPlaying) {
          
          System.out.println("Computer's Turn");
          
          computerTotal += draw(deckValue, deckSize, "Computer");
          deckSize--;
          
        }
        
        System.out.println("Press Enter to continue...");
        input.nextLine();
        
        //If players' total scores are greater than 21, eliminate them
        if(player1Total > 21){
          player1Playing = false;
          System.out.println(player1 + " is eliminated");
        }
        if(player2Total > 21){
          player2Playing = false;
          System.out.println(player2 + " is eliminated");
        }
        if(player3Total > 21){
          player3Playing = false;
          System.out.println(player3 + " is eliminated");
        }
        if(computerTotal > 21){
          computerPlaying = false;
          System.out.println("Computer is eliminated");
        }
        
        //Print total score of players after each player's turns are completed
        System.out.println(player1 + "'s total: " + player1Total);
        System.out.println(player2 + "'s total: " + player2Total);
        System.out.println(player3 + "'s total: " + player3Total);
        System.out.println("Computer's total: " + computerTotal);
        
        //if there are multiple winners, print draw
        if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 0){
          System.out.println("Draw");
          isRunning = false;
        } 
        //else if player1 wins by getting 21, print player 1 has won
        else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 1){
          System.out.println(player1 + " has won!");
          isRunning = false;
        }
        //else if player2 wins by getting 21, print player 2 has won
        else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 2){
          System.out.println(player2 + " has won!");
          isRunning = false;
        } 
        //else if player3 wins by getting 21, print player 3 has won
        else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 3){
          System.out.println(player3 + " has won!");
          isRunning = false;
        } 
        //else if computer wins by getting 21, print computer has won
        else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 4){
          System.out.println("Computer has won!");
          isRunning = false;
        }
        
        //If everyone but one player is eliminated, print surviving player has won since everyone else is eliminated
        if(player1Playing && !player2Playing && !player3Playing && !computerPlaying){
          System.out.println(player1 + " has won! because others were eliminated");
          isRunning = false;
        } else if(player2Playing && !player1Playing && !player3Playing && !computerPlaying){
          System.out.println(player2 + " has won! because others were eliminated");
          isRunning = false;
        } else if(player3Playing && !player1Playing && !player2Playing && !computerPlaying) {
          System.out.println(player3 + " has won! because others were eliminated");
          isRunning = false;
        } else if(computerPlaying && !player1Playing && !player2Playing && !player3Playing) {
          System.out.println("Computer has won! because others were eliminated");
          isRunning = false;
        }
        
        //If there are no cards left, print the player with highest score as a winner
        if(deckSize == 0){
          System.out.println("No cards left");
          if(player1Total > player2Total && player1Total > player3Total && player1Total > computerTotal){
            System.out.println(player1 + " has won!");
            isRunning = false;
          } else if(player2Total > player1Total && player2Total > player3Total && player2Total > computerTotal){
            System.out.println(player2 + " has won!");
            isRunning = false;
          } else if(player3Total > player1Total && player3Total > player2Total && player3Total > computerTotal){
            System.out.println(player3 + " has won!");
            isRunning = false;
          } else if(computerTotal > player1Total && computerTotal > player2Total && computerTotal > player3Total){
            System.out.println("Computer has won!");
            isRunning = false;
          } else {
            System.out.println("Draw");
            isRunning = false;
          }
        }
        
      }// end of while
      System.out.println("Do you want to continue? (y/n)");
      inPlay = Character.toLowerCase(input.next().charAt(0));
      while (inPlay !='y' && inPlay !='n'){
        System.out.println("Please answer again by responding in y or n"); //Ask the user to input their will to play or not correctly
        inPlay = Character.toLowerCase(input.next().charAt(0));
      }
    }
    
    //Thank the user for playing
    System.out.println("Thanks for playing");
    
  }
}