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
		colorMode(HSB);
		background(0);

		smooth();
		
	}

	public void drawGrid()
	{
		stroke(255);
		float boarder = 50.0f;

		int count = 10;
		float gap = (width - (boarder * 2.0f)) / (float)count;
		for(int i = -5; i<=5; i++)
		{
			float x = boarder + (gap * i+5);
			line(x, boarder, x, height - boarder);
			line(boarder, x, width - boarder, x);

		}

	}

	public void draw()
	{	
		strokeWeight(2);
		
		drawGrid();
	}
}
