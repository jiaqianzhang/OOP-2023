// Jia Qian Zhang 
// C21408862
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet 
{
    // global array list of star objects
    // you pass a type star as a parameter, can only hold star elements
    // array list is implemented as an array
    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    public void settings() 
    {
        size(800, 800); // set the drawing window to be 800 x 800
    }

    public void setup() 
    {
        colorMode(RGB);
        background(0);

        smooth();
        loadStars(); // calling func loadStars
        printStars(); // call func printStars

        // border = width * 0.1f; // setting the border to start from 0.1 on the axis, this leaves space to outlook the entire map
    }

    // prints the contents of the array list after it has been loaded
    // should make a toString method on the star class to help you do this and call this from setup after loading the data to make sure it gets loaded correctly
    void printStars()
    {
        // for each loop
        for (int i = 0; i<stars.size(); i++)
        {
            // stars.get = brackets when dealing with array lists
            // java doesn't feature operating overloading so this special feature is needed
            println(stars.get(i)); // return star at position i
        }

        // for(Star s:stars)
        // {
        //     System.out.println(s);
        // }
    }

    public void displayStars()
    {
        // for each loop
        for (int i = 0; i<stars.size(); i++)
        {
            stars.get(i).render(this);; // this is a pointer in the rapplet itself
        }

        // iliterate and draw the stars in the array
        // for(Star s:stars)
        // {
        //     s.render(this);
        // }
    }

    // code to call all the constructor chaining from Star
    // load the file into an array list of star objects
    // load data from the file and populates the arraylist
    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "");
        for(TableRow r:table.rows())
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void drawGrid()
	{
		stroke(0, 255, 255); // setting the colour aquamerine
		float boarder = width * 0.1f; // the size of the border will scale depending on the size of the screen (calculatig either the side)

		for(int i = -5; i<=5; i++)
		{
			float x = map(i, -5, 5, border, width -border);
			line(x, boarder, x, height - boarder);
			line(boarder, x, width - boarder, x);

            textAlign(CENTER,CENTER); // sets the horizontal and vertical line for text
            text(i, x, border*0.5f);// 1 parameter is what you want to print
            text(i, border * 0.5f, x);
		}
        // float f = map(5, 0, 10, 100, 200); // takes number 5, minus half way between 0 and 10 and puts the output number halfway between 100 and 200 => 150
        // float f1 = map1(5, 0, 10, 100, 200);
    }

    // build in function
    float map1(float a, float b, float c, float d, float e)
    {
        float r1 = c-b;
        float r2 = e-d;
        float distance = a-b;

        return d +((distance / r1) * r2);
    }

	public void draw()
	{	
		strokeWeight(1);
		
		drawGrid();
        displayStars();
	}


    // Star first = null; // first star
    // Star second = null; // second star

    // public void mouseClicked()
    // {
    //     for(Star s:stars)
    //     {
    //         float x = map(s.getxG(), -5, 5, border, width - border);
    //         float y = map(s.getyG(), -5, 5, border, height - border);

    //         if (dist(mouseX, mouseY, x, y) < 20)
    //         {
    //             if (first == null)
    //             {
    //                 first = s;
    //                 break;
    //             }
    //             else if (second == null)
    //             {
    //                 second = s;
    //                 break;
    //             } 
    //             else
    //             {
    //                 first = s;
    //                 second = null;
    //                 break;
    //             }
    //         }
    //     }
    // }



    // drawing the whole star map out
    // public void draw() 
    // {
    //     background(0); // setting background to black
    //     drawGrid(); // call function drawGrid
    //     drawStars(); // call function drawStars

    //     if (first != null)
    //     {
    //         float x = map(first.getxG(), -5, 5, border, width - border);
    //         float y = map(first.getyG(), -5, 5, border, height - border);

    //         if (second != null)
    //         {
    //             float x2 = map(second.getxG(), -5, 5, border, width - border);
    //             float y2 = map(second.getyG(), -5, 5, border, height - border);

    //             stroke(255, 255, 0);
    //             line(x, y, x2, y2);

    //             float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

    //             fill(255);
    //             textAlign(CENTER, CENTER);
    //             text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
    //         }
    //         else
    //         {
    //             stroke(255, 255, 0);
    //             line(x, y, mouseX, mouseY);
    //         }
    //     }
}