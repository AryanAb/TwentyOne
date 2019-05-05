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

    public static int draw(int[] deckNum, int deckSize, String name){

        int index = (int) (Math.random()*deckSize - 1);
        int card = deckNum[index];
        remove(deckNum, index);

        if(index % 4 == 0){
            System.out.println(name + "'s card: " + card + " of clubs");
        } else if(index % 4 == 1){
            System.out.println(name + "'s card: " + card + " of diamonds");
        } else if(index % 4 == 2){
            System.out.println(name + "'s card: " + card + " of hearts");
        } else{
            System.out.println(name + "'s card: " + card + " of spades");
        }

        return card;

    }

    public static void main(String[] args){
        Scanner input = new Scanner (System.in);

        int deckSize = 51;
        int player1Total = 0;
        int player2Total = 0;
        int player3Total = 0;
        int computerTotal = 0;
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

            System.out.println("If your first two cards add to 21 you win, congrats!");
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

        while(isRunning){

            System.out.println(player1 + "'s total: " + player1Total);
            System.out.println(player2 + "'s total: " + player2Total);
            System.out.println(player3 + "'s total: " + player3Total);
            System.out.println("Computer's total: " + computerTotal);

            if (hasWon(player1Total, computerTotal) == 1){
                System.out.println("Player won");
                isRunning = false;
            } else if(hasWon(player1Total, computerTotal) == -1){
                System.out.println("Computer won");
                isRunning = false;
            }

            System.out.println("Press Enter to continue...");
            input.nextLine();

        }

    }
}
