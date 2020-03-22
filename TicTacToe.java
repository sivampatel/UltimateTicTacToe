package TicTacToe;

/*
Sivam Patel
CS 2336.006
*/

public class TicTacToe
{
    private Board board;
    private int winner = -1; // used to keep track of who won this game, 0 for user, 1 for computer
    private int rows = 3;
    private int cols = 3;

    // default constructor
    public TicTacToe()
    {
        setBoard();
    }

    // makes moves, tries to make move in board
    public boolean makeMove(Player p, int box)
    {
        return !board.boxToMark(p.getMark(), box); // returns false if placeholder is set
    }
    // returns winner of board
    public int getWinner()
    {
        return winner;
    }

    // create board for game
    private void setBoard()
    {
        this.board = new Board(rows, cols, "TicTacToeGame");
    }

    // look for win conditions
    public void findWinner(int x)
    {
        if(winner == -1)
        {
            if(checkCol())
                setWinner(x);
            else if(checkRow())
                setWinner(x);
            else if(checkDiaTLBR())
                setWinner(x);
            else if (checkDiaBLTR())
                setWinner(x);
        }
    }
    // check rows for winner
    private boolean checkRow() {
        for(int x = 0; x < 9; x += 3)
        {
            if(board.getMark(x).equals(board.getMark(x + 1)) && board.getMark(x + 1).equals(board.getMark(x + 2)) && !board.getMark(x).equals("-"))
            {
                return true;
            }
        }
        return false;
    }

    // check for 3 in a row in columns
    private boolean checkCol() {
        // loop through columns
        for(int c = 0; c < cols; c++)
        {
            if(board.getMark(c).equals(board.getMark(c + 3)) && board.getMark(c + 3).equals(board.getMark(c + 6)) && !board.getMark(c).equals("-"))
                return true;
        }
        return false;
    }

    //check top left to bottom right for winner
    private boolean checkDiaTLBR() {
        // check if one of the values is a dash
        if(board.getMark(0).equals("-"))
            return false;
        // check the diagonal marks
        if(board.getMark(0).equals(board.getMark(4)) && board.getMark(4).equals(board.getMark(8)))
        {
            return true;
        }
        return false;
    }

    //check  bottom left to top right for winner
    private boolean checkDiaBLTR() {
        // check if one of the values is a dash
        if(board.getMark(6).equals("-"))
            return false;
        // check the diagonal marks
        if(board.getMark(6).equals(board.getMark(4)) && board.getMark(4).equals(board.getMark(2)))
        {
            return true;
        }
        return false;
    }

    // print row of board
    public void print(int row)
    {
        board.printRow(row);
    }

    // print all available moves
    public void printMoves()
    {
        board.printAvailableMoves();
    }

    // check if board is full
    public boolean isFull()
    {
        return board.isFull();
    }

    // set winner of board
    private void setWinner(int x)
    {
        winner = x;
    }

}
