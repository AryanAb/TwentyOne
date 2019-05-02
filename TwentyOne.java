import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;
public class TwentyOne {

    public static void remove(int[] array, int removeIndex){

        for(int i = removeIndex; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }

    }

    // returns 1 if player won. returns -1 if computer won. returns 0 if none won.
    public static int hasWon(int playerCardsTotal, int computerCardsTotal){

        if(playerCardsTotal == 21){
            return 1;
        }
        if(computerCardsTotal == 21){
            return -1;
        }
        if(computerCardsTotal > 21){
            return 1;
        }
        if(playerCardsTotal > 21){
            return -1;
        }
        //if(playerCardsTotal > computerCardsTotal && playerCardsTotal < 21){
          //  return true;
        //}

        return 0;

    }

    public static int draw(int[] deck, int deckSize){

        int index = (int) (Math.random()*deckSize - 1);
        int card = deck[index];
        remove(deck, index);

        return card;

    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner (System.in);

        int deckSize = 51;
        int playerTotal = 0;
        int computerTotal = 0;
        boolean isRunning = true;

       // System.out.print("Enter your name: ");
        //String player1 = input.nextLine();
        //String player2;
        //String player3;

        int[] deck = {11, 11, 11, 11,
                      2, 2, 2, 2,
                      3, 3, 3, 3,
                      4, 4, 4, 4,
                      5, 5, 5, 5,
                      6, 6, 6, 6,
                      7, 7, 7, 7,
                      8, 8, 8, 8,
                      9, 9, 9, 9,
                      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        // put the code to draw first to cards here and then put the code to the code for the game n the while loop


        while(isRunning){

            playerTotal += draw(deck, deckSize);
            deckSize--;
            playerTotal += draw(deck, deckSize);
            deckSize--;
            computerTotal += draw(deck, deckSize);
            deckSize--;
            computerTotal += draw(deck, deckSize);
            deckSize--;

            System.out.println("Your total: " + playerTotal);
            System.out.println("Dealer's total: " + computerTotal);

            if (hasWon(playerTotal, computerTotal) == 1){
                System.out.println("Player won");
                isRunning = false;
            } else if(hasWon(playerTotal, computerTotal) == -1){
                System.out.println("Dealer won");
                isRunning = false;
            }

            System.out.println("Press Enter to continue...");
            input.nextLine();

        }


    }
}
