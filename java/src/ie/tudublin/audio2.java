package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 1024);
    }


    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; // buffer
    }

    public void draw()
    {
        background(0);
        stroke (255);
        float half = height / 2;
        for(int i=0; i<ab.size(); i++)
        {
            line(i, half, i, half+ab.get(i) * half);
        }

        println(map(5, 0, 10, 1000, 2000));
    }


    float map(float a, float b, float c, float d, float e)
    {

    }

}