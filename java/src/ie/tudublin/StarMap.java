// Jia Qian Zhang 
// C21408862
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

// naming the sketch StarMap
public class StarMap extends PApplet 
{
    // global array list of star objects
    ArrayList<Star> stars = new ArrayList<Star>();
    
    public float border;

    // code to draw purple gridlines with label
    void drawGrid()
    {
        stroke(255, 0, 255); // setting the lines to purple
        textAlign(CENTER, CENTER);
        textSize(200); // setting text size to 20
        // making sure gridlines goes from -5 to 5 parsecs on the x and y axis
        for(int i=-5; i<=5; i++)
        {
            // gridlines going from -5 spaces to 5 parsecs on the x and y axis
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border); // draw line from -5 to 5 vertically to make a grid
            line(border, x, width - border, x); // draw line horizontally from -5 to 5
            fill(255);
            text(i, x, border * 0.5f); // drawing number -5 to 5 on the x axis on the top of the grid
            text(i, border * 0.5f, x); // printing number -5 to 5 on the y axis on the side of the grid
        }
    }

    // prints the contents of the array list after it has been loaded
    // should make a toString method on the star class to help you do this and call this from setup after loading the data to make sure it gets loaded correctly
    void printStars()
    {
        for(Star s:stars)
        {
            System.out.println(s);
        }
    }

    // load the file into an array list of star objects
    // load data from the file and populates the arraylist
    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header"); // loading data from file
        for(TableRow r:table.rows()) //populates the array list
        {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() 
    {
        size(800, 800); // set the drawing window to be 800 x 800
    }

    Star first = null; // first star
    Star second = null; // second star

    public void mouseClicked()
    {
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }

    public void setup() 
    {
        colorMode(RGB);
        loadStars(); // calling func loadStars
        printStars(); // call func printStars

        border = width * 0.1f; // setting the border to start from 0.1 on the axis, this leaves space to outlook the entire map
    }

    public void drawStars()
    {
        // iliterate and draw the stars in the array
        for(Star s:stars)
        {
            s.render(this);
        }
    }

    // drawing the whole star map out
    public void draw() 
    {
        background(0); // setting background to black
        drawGrid(); // call function drawGrid
        drawStars(); // call function drawStars

        if (first != null)
        {
            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }
}