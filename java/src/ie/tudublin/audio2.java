package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }


    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; // buffer

        lerpedbuffer = new float[width];
        fft = new FFT(width, 44100);

    }

    float[] lerpedbuffer;

    public void draw()
    {
        background(0);
        colorMode(HSB); // help add colour
        stroke (255);
        float half = height / 2;
        for(int i=0; i<ab.size(); i++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255); // help add colour
            lerpedbuffer[i] = lerp(lerpedbuffer[i], ab.get(i), 0.05f);
            float f = abs(lerpedbuffer[i] * half);
            line(i, half + f, i, half - f * half);
        }

        fft.forward(ab); // second array
        stroke(255);

        int highestIndex = 0;

        for(int i=0; i<fft.specSize() / 2; i++)
        {
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);
            if (fft.getBand(i)  > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(0, 255, 255);
        textSize(20);
        text("Freq " + freq, 50, 100);

        float y = map(freq, 1000.0f, 2500.0f, height, 0);

        lerpedY = lerp(lerpedY, y, 0.1f);
        circle(200, y, 50);
        circle(300, lerpedY, 50);

        // println(map1(5, 2, 10, 1000, 2000));
    }


    float map1(float a, float b, float c, float d, float e)
    {
        float r1 = c - b;
        float r2 = e - d;
        float distance = a - b;

        return d + (distance / r1) * r2;

    }

}