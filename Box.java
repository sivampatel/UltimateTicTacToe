package TicTacToe;

/*
Sivam Patel
CS 2336.006
*/

class Box
{
    private String placeholder = DASH;
    private final static String DASH = "-";

    // default constructor
    public Box()
    { }
    boolean setPlaceHolder(String placeHolder)
    {
        if(isAvailable())
        {
            this.placeholder = placeHolder;
            return false;
        }
        else
            return true;
    }
    // get value of box
    public String getPlaceholder()
    {
        return placeholder;
    }
    // check if box is empty
    public boolean isAvailable()
    {
        return this.placeholder.equals(Box.DASH);
    }

    // print placeholder value for box
    public void print()
    {
        System.out.print(placeholder + " ");
    }

}
