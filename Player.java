package TicTacToe;

/*
Sivam Patel
CS 2336.006
*/

class Player
{
    private String name;
    private String mark;

    // constructor for player class
    public Player(String name, String mark)
    {
        this.setName(name);
        this.setMark(mark);
    }
    // public getter methods
    public String getName()
    {
        return name;
    }
    public String getMark()
    {
        return mark;
    }

    // setter methods for initialization
    private void setName(String name)
    {
        this.name = name;
    }
    private void setMark(String mark)
    {
        this.mark = mark;
    }

    // returns random number from 0 - 8 for choosing box number
    public int randomNumber()
    {
        return (int) (Math.random() * 9);
    }

}
