package ie.tudublin;

import ddf.minim.Minim;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim; // making it as a field to connect audio
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    // public void keyPressed() 
    // {
	// 	if (key >= '0' && key <= '9') {
	// 		mode = key - '0';
	// 	}
	// 	if (keyCode == ' ') {
    //         if (ap.isPlaying()) {
    //             ap.pause();
    //         } else {
    //             ap.rewind();
    //             ap.play();
    //         }
    //     }
	// }

    public void settings()
    {
        size(1024, 500);
        //fullScreen(P3D, SPAN);
    }

    int frameSize = 1024;

    public void setup()
    {
        colorMode(HSB);
        background(0);

        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; // ab is a buffer that encapulates array list of 1 frame

        smooth();

        // And comment the next two lines out
        // ap = minim.loadFile("heroplanet.mp3", 1024);
        // ap.play();
        // ab = ap.mix;

        // y = height / 2;
        // smoothedY = y;
    }

    // float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);

        float half = height / 2;
        // maths way to add colours
        float cgap = 255 / (float)ab.size();

        // float average = 0;
        // float sum = 0;
        // off += 1;

        // for loop to microphone sound
        for(int i=0; i<ab.size(); i++)
        {
            // change stroke colours using maths way
            stroke(cgap * i, 255, 255);
            line(i, half, i, half + ab.get(i) * half); // making audio wave bigger by *
            // sum += abs(ab.get(i));
        }
        // average= sum / (float) ab.size();

        // smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        // float cx = width / 2;
        // float cy = height / 2;

        // switch (mode) {
		// 	case 0:
        //         background(0);
        //         for(int i = 0 ; i < ab.size() ; i ++)
        //         {
        //             //float c = map(ab.get(i), -1, 1, 0, 255);
        //             float c = map(i, 0, ab.size(), 0, 255);
        //             stroke(c, 255, 255);
        //             float f = ab.get(i) * halfH;
        //             line(i, halfH + f, i, halfH - f);                    
        //         }
        //         break;
        // case 1:
        //     background(0);            
        //     break;

        // }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
