package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;
	float bugX, bugY, bugWidth;

	float halfPlayer, halfBug;

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

		playerX = width * 0.5f; // we want playerX to be half way along the width of the screen, 0.5f convert into a floating constant (4 bits) instead of 0.5 which takes as a double constant with 8 bits
		playerY = height - 100; // playerY at the bottom of the screen, -100 pixels
		playerWidth = 50;
		halfPlayer = playerWidth * 0.5f;

		resetBug();
	}

	void resetBug()
	{
		bugY = 50;
		bugWidth = 50;
		halfBug = bugWidth * 0.5f;
		bugX = random(halfBug, width - halfBug); // random value starting from the left hand side of the screen to the right hand side, we want the bug not drawn off the screen so width is taken away from halfBug, it constrains the bug from moving the screen
	}

	void drawPlayer(float x, float y, float w)
	{
		noFill();
		stroke(255);
		rectMode(CENTER);
		rect(x, y, w, w); // width and height the same
		// y - halfPlayer brings the y coordinate up the top of the rectanglde
		// y - halfPlayer * 2 makes everythign go to scale
		line(x, y - halfPlayer, x, y - halfPlayer * 2);
		
	}

	// public makes the method visible outside the class
	// function to move the player, gets called automatically by the superclass when a key is pressed
	// keypress function is on the superclass and we are overwriting it known as dynamic binding of a function
	// this is polymorphism meaning the thing can change, such as a cat can change to a dog through code
	// because we have dynamic binding, if you overwrite a method from a superclass because of polymorphism it will call the one in the subclass int he instances of the subclass
	// techtical polymorphism is the types of the superclass but the instances of a subclass
	public void keyPressed()
	{
		// moving the player
		if (keyCode == LEFT) // keycode is for the left and right key
		{
			playerX--;
		}

		if (keyCode == RIGHT)
		{
			playerX++;
		}

		// shooting in the game
		if (key == ' ')
		{
			line(playerX, playerY - halfPlayer, playerX, 0); // 0 makes it go all the way up to the screen
		}

	}
	
	public void draw()
	{
		background(0); // clear the background to prevent the keycode ...
		drawPlayer(playerX, playerY, playerWidth);	

	}

}
