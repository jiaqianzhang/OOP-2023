package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;
	float bugX, bugY, bugWidth;

	int score = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();

		// we do it here rather the start is because we need 
		// to make this call from settings has executed first
		// so we know the width of the screen

		// playerX = width *;


	}
	
	public void draw()
	{	

	}

	public void drawPlayer(float x, float y, float w)
	{
		
	}

}
