package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet 
{
	int mode = 0;

	public void settings() 
	{
		size(1000, 1000);
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	public void keyPressed()
	{
		mode = key - '0';
		println(mode);
	}

	// float off = 0;

	public void draw() 
	{
		background(0);
		fill(255);

		// switch statement
		// like if case statements
		switch(mode)
		{
			case 0:
				int numCircles = 10; // drawing circles
				// d for diameter is width of the screen dived by the length of the screen
				// int divide by int will get an int
				// prevent this to get a float we initialise it to float
				float d = width / (float)numCircles;
				for (int i = 0; i < numCircles; i++)
				{
					float x = (d * 0.5f) + (d * i); // half the diameter + d * i, gives me x value of where we are putting the circle
					float y = height / 2; // height of the screen / 2
					circle(x, y, d);

					
				}
				break;
			case 1:
				break;
			default:
				break;
		}

	}

	// 	switch (mode) {
	// 		case 0:
	// 			int numCircles = (int) max(1, mouseX / 50.0f);
	// 			float d = width / numCircles;
	// 			for (int j = 0; j < numCircles; j++) {
	// 				for (int i = 0; i < numCircles; i++) {
	// 					float x = (d * 0.5f) + (d * i);
	// 					float y = (d * 0.5f) + (d * j);
	// 					float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
	// 					fill((c + off) % 256, 255, 255);
	// 					circle(x, y, d);
	// 				}
	// 			}
	// 			off += (mouseY / 50.0f);
	// 			break;
	// 		case 1:
	// 			break;
	// 		default:
	// 			break;
	// 	}

	// }
}
