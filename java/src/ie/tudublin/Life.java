package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	LifeBoard lifeBoard;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(RGB);
		background(0);

		lifeBoard = new LifeBoard(50, this);
		lifeBoard.randomise();
	}

	public void draw()
	{	
		background(0);
		lifeBoard.render();
		lifeBoard.applyRules();
	}
}
