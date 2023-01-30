package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 0, 0);
		
	}
	
	public void draw()
	{
		fill(51, 204, 255);
		triangle(50, 400, 250, 50, 450,400);
		fill(255, 255, 0);
		circle(250, 270, 220); //cx, cy, d
		fill(255);
		// oval
		ellipse(250, 270, 200, 100);
		fill(0, 0, 0);
		circle(250, 270, 100);

		noStroke();
		//cue, saturation, brightness
		fill(mouseX, 0, mouseY); 
		// fill(mouseX, 255, 255);
		// circle(mouseX, mouseY, mouseY);
		circle(random(0, width), random(0, width), random(0, width));
	}
}
