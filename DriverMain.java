package TicTacToe;

/*
Sivam Patel
CS 2336.006

Analysis:
We need to create an ultimate tic tac toe game. The challenge of this will be creating a new class the aggregates the current
Tic Tac Toe class. It will need to need to be able to hold 9 tic tac toe games in it. Even using the code we wrote in class for
our previous tic tac toe games, changes will still need to be made. For one, we need a class that runs everything above the tic tac toe
class that will look for winners, switch players, and allow users to make moves.

Design:
To start, I used the code we had written in class before the Interface and board wrapper as I found it easier to understand.
So, we have a box class which hsa a String in it for the value of that box. Next, we have a board class which holds an array
of 9 boxes. Next, we have the TicTacToe class which has a board in it. It is responsible for actually going through and making
the moves and getting a lot of the information needed from any board. Lastly, we have and UltimateTicTacToe class which holds
an a array of 9 Tic Tac Toe games. This is the main driver of the game. This class handles moves, printing the boards, checking
for an overall winner, etc. Each class has its own functions to handle its own data. 

Test:
Testing my code was mostly done using random inputs. I would use random moves for both players so I could get more tests
done. When doing this, I would also use other methods to check if my program was working. So, I would not only have the
method I have now but other ones to keep track of which boards already had winners at each move and I would print that out
in order to make sure my program was finding the winner of the game properly. This helped me catch quite a few errors I had
in my code that would result in the winner not being found after they had won 3 boards in a row. After I had worked out those
errors, I made sure to play a few games manually to check for any errors using user input.

 */

import java.util.Scanner;

public class DriverMain
{
    public static void main(String[] args)
    {
        String str;
        Scanner s = new Scanner(System.in);
        do
        {
            // create new game
            UltimateTicTacToe u = new UltimateTicTacToe();
            System.out.println("Would you like to play again? Enter Y to play again. Enter anything else to exit. ");
            str = s.nextLine();
        } while(str.equals("Y") || str.equals("y"));
        System.out.println("Thank you for playing.");
    }
}