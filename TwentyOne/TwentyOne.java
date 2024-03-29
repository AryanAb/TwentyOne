import java.sql.Time;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.sql.Timestamp;
public class TwentyOne {
  
  /** Removes an element (card) from an array (deck)
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
  public static int draw(int[] deckNum, int deckSize, String name, int computerTotal){
    
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
      
      if (name.compareTo("Computer")==0){
        if(computerTotal>10){
          return 1;
        }else{
          return 11;
        }
      }else{
      System.out.println("Do you want the value to be 1 or 11?");
      return input.nextInt();
      }
      
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
  
  
  
  public static void main(String[] args)throws IOException{
    Scanner input = new Scanner (System.in);
    
    String winner = "";
    char inPlay = 'y';
    
    int numPlayer = 3; 
    String path = "TwentyOne.txt";  
    File myFile = new File(path); 
    if(!myFile.isFile()){
      PrintWriter writer = new PrintWriter(path, "UTF-8");
    }
    
    while (inPlay == 'y'){
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
      
      
      // put the code to draw first to cards here and then put the code to the code for the game n the while loop
      
      System.out.println("1. Play");
      System.out.println("2. How To Play");
      
      int option = input.nextInt();
      
      if(option == 2) {
        
        System.out.println("Get 21 points on first two cards.");
        System.out.println("If the sum is less than 21, player can decide to draw one more card or skip(pass)");
        System.out.println("Reach a final score higher than the dealer (computer) without exceeding 21");
        System.out.println("Let the dealer draw additional cards until their hand exceeds 21");
        System.out.println("Press Enter to play");
        input.nextLine();
        
      }
      
      input.nextLine();
      System.out.print("Player 1 name: ");
      String player1 = input.nextLine();
      System.out.print("Player 2 name: ");
      String player2 = input.nextLine();
      System.out.print("Player 3 name: ");
      String player3 = input.nextLine();
      
      player1Total += draw(deckValue, deckSize, player1,computerTotal);
      deckSize--;
      player2Total += draw(deckValue, deckSize, player2,computerTotal);
      deckSize--;
      player3Total += draw(deckValue, deckSize, player3,computerTotal);
      deckSize--;
      computerTotal += draw( deckValue, deckSize, "Computer", computerTotal);
      deckSize--;
      player1Total += draw(deckValue, deckSize, player1,computerTotal);
      deckSize--;
      player2Total += draw(deckValue, deckSize, player2,computerTotal);
      deckSize--;
      player3Total += draw(deckValue, deckSize, player3,computerTotal);
      deckSize--;
      computerTotal += draw(deckValue, deckSize, "Computer", computerTotal);
      deckSize--;
      
      System.out.println(player1 + "'s total: " + player1Total);
      System.out.println(player2 + "'s total: " + player2Total);
      System.out.println(player3 + "'s total: " + player3Total);
      System.out.println("Computer's total: " + computerTotal);
      
      if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 0){
        System.out.println("Draw");
        isRunning = false;
        winner = "Draw";
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 1){
        System.out.println(player1 + " has won!");
        isRunning = false;
        winner = player1;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 2){
        System.out.println(player2 + " has won!");
        isRunning = false;
        winner = player2;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 3){
        System.out.println(player3 + " has won!");
        isRunning = false;
        winner = player3;
      } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 4){
        System.out.println("Computer has won!");
        isRunning = false;
        winner = "Computer";
      }
      
      while(isRunning){
        
        int count = 0;
        
        if(player1Playing) {
          
          System.out.println(player1 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          
          if (option == 2) {
            player1Total += draw(deckValue, deckSize, player1, computerTotal);
            deckSize--;
          } else{
            count++;
          }
          
        }
        
        if(player2Playing) {
          
          System.out.println(player2 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          
          if (option == 2) {
            player2Total += draw(deckValue, deckSize, player2, computerTotal);
            deckSize--;
          } else{
            count++;
          }
          
        }
        
        if(player3Playing) {
          
          System.out.println(player3 + "'s Turn");
          System.out.println("Press 1 to skip. Press 2 to draw");
          
          option = input.nextInt();
          
          if (option == 2) {
            player3Total += draw(deckValue, deckSize, player3,computerTotal);
            deckSize--;
          } else{
            count++;
          }
          
        }
        
        if(computerPlaying) {
          
          System.out.println("Computer's Turn");
          
          computerTotal += draw(deckValue, deckSize, "Computer",computerTotal);
          deckSize--;
          
        }
        
        System.out.println("Press Enter to continue...");
        input.nextLine();
        
        
        if(player1Total > 21){
          player1Playing = false;
          numPlayer--;
          System.out.println(player1 + " is eliminated");
        }
        if(player2Total > 21){
          player2Playing = false;
          numPlayer--;
          System.out.println(player2 + " is eliminated");
        }
        if(player3Total > 21){
          player3Playing = false;
          numPlayer--;
          System.out.println(player3 + " is eliminated");
        }
        if(computerTotal > 21){
          computerPlaying = false;
          System.out.println("Computer is eliminated");
        }
        
        
        System.out.println(player1 + "'s total: " + player1Total);
        System.out.println(player2 + "'s total: " + player2Total);
        System.out.println(player3 + "'s total: " + player3Total);
        System.out.println("Computer's total: " + computerTotal);
        
        if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 0){
          System.out.println("Draw");
          isRunning = false;
          winner = "Draw";
        } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 1){
          System.out.println(player1 + " has won!");
          isRunning = false;
          winner = player1;
        } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 2){
          System.out.println(player2 + " has won!");
          isRunning = false;
          winner = player2;
        } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 3){
          System.out.println(player3 + " has won!");
          isRunning = false;
          winner = player3;
        } else if(hasWon(player1Total, player2Total, player3Total, computerTotal) == 4){
          System.out.println("Computer has won!");
          isRunning = false;
          winner = "Computer";
        }
        
        if(player1Playing && !player2Playing && !player3Playing && !computerPlaying){
          System.out.println(player1 + " wins! because others were eliminated");
          isRunning = false;
          winner = player1;
        } else if(player2Playing && !player1Playing && !player3Playing && !computerPlaying){
          System.out.println(player2 + " wins! because others were eliminated");
          isRunning = false;
          winner = player2;
        } else if(player3Playing && !player1Playing && !player2Playing && !computerPlaying) {
          System.out.println(player3 + " wins! because others were eliminated");
          isRunning = false;
          winner = player3;
        } else if(computerPlaying && !player1Playing && !player2Playing && !player3Playing) {
          System.out.println("Computer wins! because others were eliminated");
          isRunning = false;
          winner = "Computer";
        } else if(!computerPlaying && !player1Playing && !player2Playing && !player3Playing){
          System.out.println("Draw! Everyone were eliminated");
          isRunning = false;
          winner = "Draw";
        }
        
        if(deckSize == 0){
          System.out.println("No cards left");
          if(player1Total < 22 && player1Total > player2Total && player1Total > player3Total && player1Total > computerTotal){
            System.out.println(player1 + " wins!");
            isRunning = false;
          } else if(player2Total < 22 && player2Total > player1Total && player2Total > player3Total && player2Total > computerTotal){
            System.out.println(player2 + " wins!");
            isRunning = false;
          } else if(player3Total < 22 && player3Total > player1Total && player3Total > player2Total && player3Total > computerTotal){
            System.out.println(player3 + " wins!");
            isRunning = false;
          } else if(computerTotal < 22 && computerTotal > player1Total && computerTotal > player2Total && computerTotal > player3Total){
            System.out.println("Computer wins!");
            isRunning = false;
          } else {
            System.out.println("Draw");
            isRunning = false;
          }
        }//end if deckSize is 0
        
      }
      System.out.println("Congratulations! " + winner + " Would you like to play again? (yes/no)");
      inPlay = Character.toLowerCase(input.next().charAt(0));
      while (inPlay !='y' && inPlay !='n'){
        System.out.println("Please answer again by responding in y or n"); //Ask the user to input their will to play or not correctly
        inPlay = Character.toLowerCase(input.next().charAt(0));
      }//while inplay is invalid
      
      if (inPlay == 'n'){
        System.out.println("Thanks for playing");
      }
      
      Date date = new Date();
      
      long time = date.getTime();
      
      Timestamp ts = new Timestamp(time);
      
      FileWriter fw = new FileWriter(myFile, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out  = new PrintWriter(bw);
      
      out.println("Played at: " + ts);
      out.println("Players in this round: " + player1 + " " + player2 + " " + player3 + " computer");
      out.println("Winner of this round: " + winner);
      out.println("_________________________________________________________________________________");
      out.close();
      
      
    }
    
  }
}

