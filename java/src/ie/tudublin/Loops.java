package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(700, 700);
		// fullScreen(SPAN);
	}

	public void setup() {
		// this is to add colours
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	// float for off set, field in the class
	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke(); // dont get a line outside the shapes

		// switch statement
		// like if case statements
		switch(mode)
		{
			case 0:
				// using x coordinates of the mouse to control the no. of circles
				// mouseX means 0 to 500 (too much so we divide it by 10)
				// round to integer anyways
				int numCircles = mouseX / 50; // drawing circles
				// d for diameter is width of the screen dived by the length of the screen
				// int divide by int will get an int
				// to prevent this for us to get a float we initialise it to float
				// if you dont initialise it to float it wont exactly fit equal on the screen
				float d = width / (float)numCircles;

				// column loop
				for(int j=0; j < numCircles; j++)
				{
					// only prints out one row of circles
					for (int i = 0; i < numCircles; i++)
					{
						// rows and columns across the screen
						float x = (d * 0.5f) + (d * i); // half the diameter + d * i, gives me x value of where we are putting the circle
						// we want to multiple y the same as x to get a full screen of circles
						float y = (d * 0.5f) + (d * j);
						// to calculate the fill, i and j will start at 0 and go all the way up to 9
						// colour named c must be in between 0 - 255
						// suming i and j, dividing it by the total number of rows and columns
						// i and j will go from 0 to 9
						// add the two of them = 18 = numCircles + 2 = 20
						// 18 / 20 for the bottom corner
						float c = (i + j) / ((numCircles - 1)+ 2.0f) * 255.0f;
						// c + offset will go over 255, will slowly go to colour red
						// to prevent this we modulus it with 256 ot restrict it between 0 to 255
						fill((c + off) % 256, 255, 255); // 255 saturation, then next 255 fill
						circle(x, y, d); // drawing our circles
					}
				}
				// off++;

				// this will control how fast the colours changing when moving up and down the y axis
				off+= mouseY / 50;
				break;
			case 1:
				break;
			default:
				break;
		}

	}
}
