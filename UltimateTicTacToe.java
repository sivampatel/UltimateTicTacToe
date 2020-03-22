package TicTacToe;

/*
Sivam Patel
CS 2336.006
*/

import java.util.Scanner;

public class UltimateTicTacToe
{
    private TicTacToe[] uBoard;
    private int boxNum = -1;
    private int boardNum = -1;
    private String[] marks = {"X", "O"};
    private Player[] players = new Player[2];
    private int currentPlayerIndex = -1;

    UltimateTicTacToe()
    {
        uBoard = new TicTacToe[9];
        setPlayers();
        setuBoard();
        start();
    }
     //create players for game
     private void setPlayers()
    {
        for(int i = 0; i < players.length; i++)
        {
            Player p = new Player("player " + i, marks[i]);
            players[i] = p;
        }
    }
    private void setuBoard()
    {
        for(int x = 0; x < 9; x++)
        {
            uBoard[x] = new TicTacToe();
        }
    }

    private void start()
    {
        System.out.println("Rules of the game: \n1) The user (you) will always play first and so you will be X on the board\n" +
                "3)Each player can only make a move in the board corresponding to the other players previous move. So if you make a " +
                "move in board 1, box 3, the computer can only make a move on board 3. ");
        System.out.println("Game is starting...");
        Scanner s = new Scanner(System.in);
        do
        {
            // set current player
            switchPlayer();
            Player cPlayer = players[this.currentPlayerIndex];
            // look for open box and put player mark in box
            if(this.currentPlayerIndex == 0) // if user's turn
            {
                printBoard(); // print entire board
                if(boardNum == -1)
                {
                    // print all boxes with available moves
                    for(int x = 0; x < 9; x++)
                    {
                        if(!uBoard[x].isFull())
                            printAvailableMoves(x);
                    }
                    do {
                        System.out.println(" You may place a mark in any available board. Enter the board number you wish to place a mark in: ");
                        boardNum = s.nextInt();
                        System.out.println("Enter the box number you wish to place a mark in: ");
                        boxNum = s.nextInt();

                    } while(!isValidMove(boardNum, boxNum) || !uBoard[boardNum].makeMove(cPlayer, boxNum));
                }
                else
                {
                    printAvailableMoves(boardNum);
                    do {
                        System.out.println("You must place a mark in board " + boardNum + ". Enter the box you wish to place a mark in: ");
                        boxNum = s.nextInt();
                    } while(!isValidMove(boardNum, boxNum) || !uBoard[boardNum].makeMove(cPlayer, boxNum));
                }

                //// CODE TO TEST, USES RANDOM MOVES FOR USER FOR FASTER TESTING
//                do {
//                    if(boardNum == -1 || uBoard[boardNum].isFull())
//                    {
//                        boardNum = cPlayer.randomNumber();
//                    }
//                    boxNum = cPlayer.randomNumber();
//                    printAvailableMoves(boardNum);
//                } while(!uBoard[boardNum].makeMove(cPlayer, boxNum));
            }
            else
            {
                do {
                    if(boardNum == -1 || uBoard[boardNum].isFull())
                    {
                        boardNum = cPlayer.randomNumber();
                    }
                    boxNum = cPlayer.randomNumber();
                } while(!uBoard[boardNum].makeMove(cPlayer, boxNum));
            }
            System.out.println(cPlayer.getMark() + " placed a mark in board " + boardNum + ", box " + boxNum);
            uBoard[boardNum].findWinner(currentPlayerIndex);
            boardNum = boxNum;

            if(uBoard[boardNum].isFull())
                boardNum = -1;
        } while(!gameOver());
        printWinners();
    }
    // check for winner ( win 3 games in any direction )
    private boolean gameOver()
    {
        return isWinner() || isFull();
    }

    // switch players based on whose turn it is
    private void switchPlayer()
    {
        // if player 1 or game start, set player to 0
        if(this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1)
            this.currentPlayerIndex = 0;
        else this.currentPlayerIndex = 1;
    }

    // check if all boards are full
    private boolean isFull()
    {
        for(int x = 0; x < 9; x++)
        {
            if(!uBoard[x].isFull()) // check all boards to look if there is a winner
                return false;
        }
        System.out.println("You tied with the computer.");
        return true;
    }
    // check for all game over cases
    private boolean isWinner()
    {
        if(checkRows())
            return true;
        else if(checkCols())
            return true;
        else if(checkTLBR())
            return true;
        else return checkBLTR();
    }
    // check for 3 wins in a row in any row
    private boolean checkRows()
    {
        for(int x = 0; x < 9; x += 3)
        {
            if(uBoard[x].getWinner() == uBoard[x + 1].getWinner() && uBoard[x + 1].getWinner() == uBoard[x + 2].getWinner() && uBoard[x].getWinner() != -1)
            {
                if(uBoard[x].getWinner() == 0)
                        System.out.println("You win!");
                    else
                        System.out.println("Computer wins.");
                    return true;
            }
        }
        return false;
    }
    // check for 3 wins for any player in any column
    private boolean checkCols()
    {
        for(int x = 0; x < 3; x++)
        {
            if(uBoard[x].getWinner() == uBoard[x + 3].getWinner() && uBoard[x + 3].getWinner() == uBoard[x + 6].getWinner())
            {
                if(uBoard[x].getWinner() != -1)
                {
                    if(uBoard[x + 3].getWinner() == 0)
                        System.out.println("You win!");
                    else
                        System.out.println("Computer wins.");
                    return true;
                }
            }
        }
        return false;
    }
    // checks for 3 in a row from top right to bottom left
    private boolean checkTLBR()
    {
        if(uBoard[0].getWinner() == uBoard[4].getWinner() && uBoard[4].getWinner() == uBoard[8].getWinner())
            if(uBoard[0].getWinner() != -1)
            {
                if(uBoard[0].getWinner() == 0)
                    System.out.println("You win!");
                else
                    System.out.println("Computer wins.");
                return true;
            }
        return false;
    }
    // checks for 3 in a row from bottom left to top right
    private boolean checkBLTR()
    {
        if(uBoard[6].getWinner() == uBoard[4].getWinner() && uBoard[4].getWinner() == uBoard[2].getWinner())
            if(uBoard[6].getWinner() != -1)
            {
                if(uBoard[0].getWinner() == 0)
                    System.out.println("You win!");
                else
                    System.out.println("Computer wins.");
                return true;
            }
        return false;
    }
    // print entire ultimate tic tac toe board (prints all 9) w/ corresponding numbers
    private void printBoard()
    {
        int a = 0;
        int b = 1;
        int c = 2;
        System.out.println("\n   CURRENT BOARD STATE                            BOARD NUMBERS     " );
        System.out.println("_________________________                  _________________________");
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {

                uBoard[a].print(y);
                uBoard[b].print(y);
                uBoard[c].print(y);
                if(y == 1)
                    System.out.print("|                  " + "|   " + a + "   |   " + b + "   |   " + c + "   ");
                else System.out.print("|                  |       |       |       ");
                System.out.println("|");
            }
            System.out.println("_________________________                  _________________________\n");
            a += 3;
            b += 3;
            c += 3;
        }
    }
    // prints winners of each board, used for testing
    private void printWinners()
    {
        int a = 0;
        int b = 1;
        int c = 2;
        System.out.println(" _________________________");
        for(int x = 0; x < 3; x++)
        {
                System.out.print(uBoard[a].getWinner() + " | ");
                System.out.print(uBoard[b].getWinner() + " | ");
                System.out.print(uBoard[c].getWinner() + " | ");
                System.out.println("");
            System.out.println(" _________________________");
            a += 3;
            b += 3;
            c += 3;
        }
    }
    // prints all available moves
    private void printAvailableMoves(int board)
    {
        System.out.print("Your available moves in board " + board + " are: ");
        uBoard[board].printMoves();
        System.out.println();
    }
    // checks if current move is valid
    private boolean isValidMove(int board, int box)
    {
        // check if the users inputted move is within the board (does not check if box is empty)
        if(board > 8)
            return false;
        else if(box > 8)
            return false;
        else if (board < 0)
            return false;
        else return box >= 0;
    }
}
