import java.util.Scanner;
public class TwentyOne {

    public static void remove(int[] array, int removeIndex){

        for(int i = removeIndex; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }

    }

    public static boolean hasWon(int playerCardsTotal, int computerCardsTotal){

        if(playerCardsTotal == 21){
            return true;
        }
        if(computerCardsTotal > 21){
            return true;
        }
        if(playerCardsTotal > computerCardsTotal && playerCardsTotal < 21){
            return true;
        }

        return false;

    }

    public static int draw(int[] deck, int deckSze){

        int index = (int) (Math.random()*deckSze);
        int card = deck[index];
        remove(deck, index);

        return card;

    }

    public static void main(String[] args){
        Scanner input = new Scanner (System.in);

        int deckSize = 51;

        System.out.print("Enter your name: ");
        String player1 = input.nextLine();
        //String player2;
        //String player3;

        int[] deck = {1, 1, 1, 1,
                      2, 2, 2, 2,
                      3, 3, 3, 3,
                      4, 4, 4, 4,
                      5, 5, 5, 5,
                      6, 6, 6, 6,
                      7, 7, 7, 7,
                      8, 8, 8, 8,
                      9, 9, 9, 9,
                      10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};



    }
}
