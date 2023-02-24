package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup()
	{
		colorMode(RGB);
		background(0);

		smooth();
		
	}

	public void drawGrid()
	{
		stroke(0, 255, 255); // setting the colour aquamerine
		float boarder = width * 0.1f; // the size of the border will scale depending on the size of the screen (calculatig either the side)

		int count = 10;
		float gap = (width - (boarder * 2.0f)) / (float)count;
		for(int i = -5; i<=5; i++)
		{
			float x = boarder + (gap * i+5);
			line(x, boarder, x, height - boarder);
			line(boarder, x, width - boarder, x);
            textAlign(CENTER,CENTER); // sets the horizontal and vertical line for text
            text(i,x+(gap *0.5f), gap*0.5f);// 1 parameter is what you want to print
		}
        float f = map(5, 0, 10, 100, 200); // takes number 5, minus half way between 0 and 10 and puts the output number halfway between 100 and 200 => 150
        float f1 = map1(5, 0, 10, 100, 200);
    }

    // build in function
    float map1(float a, float b, float c, float d, float e)
    {
        float r1 = c - b;
        float r2 = e - d;
        float distance = a - b;

        return d +((distance / r1) * r2);
    }

	public void draw()
	{	
		strokeWeight(2);
		
		drawGrid();
	}
}
