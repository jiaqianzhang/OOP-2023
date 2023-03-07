package ie.tudublin;

import javax.lang.model.util.ElementScanner14;

import processing.core.PApplet;

public class LifeBoard 
{
    boolean[][] board; // 2d array
    boolean[][] next;

    private int size;
    PApplet p;
    float cellWidth; // width of the applet

    public boolean getCell(int row, int col)
    {
        if(row>=0 && row<size && col>=0 && col<size)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }
    }

    public int countCells(int row, int col)
    {
        int count = 0;
        for(int i=-1; i<=1; i++)
        {
            for(int j=0; j<=1; j++)
            {
                if (!(i==0) && (j==0))
                {
                    if(getCell(i, j))
                    {
                        count++;
                    }

                }
            }
        }
        return count;
    }

    public void applyRules()
    {
        // int neighbour =0;
        // if(neighbour < 2 && neighbour >3)
        // {
            
        // }
        // else
        // {

        // }
        for(int row=0; row<size; row++)
        {
            for(int col=0; col<size; col++)
            {
                int count = countCells(row, col);
                if(board[row][col])
                {
                    if(count ==2 && count ==3)
                    {
                        next[row][col] = true; // live
                    }
                    else
                    {
                        next[row][col] = false; // dies
                    }
                }
                else
                {
                    if(count == 3)
                    {
                        next[row][col] = true; // live
                    }
                    else
                    {
                        next[row][col] = false; // dies
                    }
                }
            }
        }
        // swapping the board
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public LifeBoard(int size, PApplet p) // pass papplet to parameter
    {
        this.size = size; // assign field to private field
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float) size;
    }

    // generate random numbers in a library
    public void randomise()
    {
        for(int row=0; row<size; row++)
        {
            for(int col=0; col<size; col++)
            {
                float dice = p.random(0, 1); // generating a random number
                // concverting int to float is ok, but converting float to int is not ok
                board[row][col] = (dice <= 0.5f); // assign 50% to be true

            }
        }
    }

    // iterate over and draw board
    public void render()
    {
        for(int row=0; row<size; row++)
        {
            for(int col=0; col<size; col++)
            {
                float x = col * cellWidth;
                float y = row * cellWidth;

                if (board[row][col]) // if board is true
                {
                    p.fill(0, 255, 0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);
            }
        }
    }


    public int getSize() // getter
    {
        return size;
    }

    public void setSize(int size) // setter
    {
        this.size = size; //size of the board
    }

    
}
