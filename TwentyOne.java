import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.util.Scanner;
public class TwentyOne {

    public static void remove(String[] array, int removeIndex){

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

    public static int draw(String[] deck, int deckSize){

        int index = (int) (Math.random()*deckSize - 1);
        int card = Character.getNumericValue(deck[index].charAt(0));
        remove(deck, index);

        if(deck[index].length() == 2) {
            System.out.println("Your card: " + card + " of " + deck[index].charAt(1));
        } else if(deck[index].length() == 3) {
            System.out.println("Your card: " + card + " of " + deck[index].charAt(2));
        } else if(deck[index].length() == 4){
            if(deck[index].charAt(3) == 'j') {
                System.out.println("Your card: Jack of " + deck[index].charAt(2));
            }
            if(deck[index].charAt(3) == 'q') {
                System.out.println("Your card: Queen of " + deck[index].charAt(2));
            }
            if(deck[index].charAt(3) == 'k') {
                System.out.println("Your card: King of " + deck[index].charAt(2));
            }
        }

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

        String[] deck = {"1♠", "1♦", "1♥", "1♣",
                         "2♠", "2♦", "2♥", "2♣",
                         "3♠", "3♦", "3♥", "3♣",
                         "4♠", "4♦", "4♥", "4♣",
                         "5♠", "5♦", "5♥", "5♣",
                         "6♠", "6♦", "6♥", "6♣",
                         "7♠", "7♦", "7♥", "7♣",
                         "8♠", "8♦", "8♥", "8♣",
                         "9♠", "9♦", "9♥", "9♣",
                         "10♠", "10♦", "10♥", "10♣",
                         "10♠k", "10♦k", "10♥k", "10♣k",
                         "10♠q", "10♦q", "10♥q", "10♣q",
                         "10♠j", "10♦j", "10♥j", "10♣j"};
        // diamond
        // heart
        // club
        // spade

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

        System.out.println("♥♦♣♠" );


    }
}
