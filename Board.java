package TicTacToe;

/*
Sivam Patel
CS 2336.006
*/

class Board
{
    private int BOARD_ROW;
    private int BOARD_COL;
    private Box[] boxes;
    private String name;

    // default constructor
    public Board()
    {
        this(3, 3, "3 * 3 board");
    }
    // overloaded constructor
    public Board(int row, int col, String n)
    {
        this.setName(n);
        this.setSize(row, col);
    }
    private void setName(String n)
    {
        this.name = n;
    }
    private void setSize(int row, int col)
    {
        // check for input validation
        if(row < 3 || col < 3)
            System.out.println("Min board size is 3");
        else
        {
            this.BOARD_COL = col;
            this.BOARD_ROW = row;
            this.init();
        }
    }
    // initialize board
    private void init()
    {
        this.boxes = new Box[BOARD_ROW * BOARD_COL];
        // loop through array of boxes
        for(int i = 0; i < this.boxes.length; i++)
        {
            // create boxes and add them to array
            Box b = new Box();
            this.boxes[i] = b;
        }
    }
    // print row in board
    public void printRow(int r)
    {
        System.out.print("| ");
            for(int x = 0; x < 3; x++)
            {
                if(boxes[(r * 3) + x].getPlaceholder().equals("-"))
                    System.out.print(((r * 3) + x) + " ");
                else System.out.print(boxes[(r * 3) + x].getPlaceholder() + " ");
            }
    }
    // print all available moves
    public void printAvailableMoves()
    {
        int r = 0;
        while(r < 3)
        {
            for (int x = 0; x < 3; x++)
            {
                if (boxes[(r * 3) + x].getPlaceholder().equals("-"))
                    System.out.print(((r * 3) + x) + " ");
            }
            r++;
        }
    }

    // check if board is full
    public boolean isFull()
    {
        // loop through boxes and check if all boxes have marks in them
        for(Box b : boxes)
            if(b.isAvailable())
                return false;
        return true;
    }
    // set mark of box
    public boolean boxToMark(String s, int b)
    {
        return boxes[b].setPlaceHolder(s);
    }

    // get mark of box
    public String getMark(int b)
    {
        return boxes[b].getPlaceholder();
    }
}
