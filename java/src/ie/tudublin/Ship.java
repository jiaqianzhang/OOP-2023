package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship 
{
    private PVector pos;
    private PVector forward; // direction of the forward
    PApplet p;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        pos = new PVector(x, y);
        forward = new PVector(x, y);
        this.size = size;
        this.halfSize = size/2;
        this.c = c;
        this.p = p;
    }

    public PVector getPos() 
    {
        return pos;
    }

    public void setPos(PVector pos) 
    {
        this.pos = pos;
    }

    public PApplet getP() 
    {
        return p;
    }

    public void setP(PApplet p) 
    {
        this.p = p;
    }

    public float getSize() 
    {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }
    
    public float getRot() 
    {
        return rot;
    }

    public void setRot(float rot) 
    {
        this.rot = rot;
    }

    public int getC() 
    {
        return c;
    }

    public void setC(int c) 
    {
        this.c = c;
    }


    private float rot;
    private int c;
    private float size;
    private float halfSize;

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);

        // keypress is boolean
        if(p.keyPressed)
        {
            if(p.keyCode == PApplet.LEFT)
            {
                rot-= 0.1f; // changing moving left to rotating left
            }
            if(p.keyCode == PApplet.RIGHT)
            {
                rot+= 0.1f; // changing moving right to rotating right
            }
            if(p.keyCode == PApplet.UP)
            {
                // code to move ship upwards in the direction it rotated
                pos.x += forward.x;
                pos.y += forward.y;
            }
            if(p.keyCode == PApplet.DOWN)
            {
                // code to move ship downwards in the direction it rotated
                pos.x -= forward.x;
                pos.y -= forward.y;
            }
        }
    }

    public void render()
    {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rot); // rotate
        // drawing the ship
        p.stroke(c, 255, 255);
        p.line(-halfSize, +halfSize, 0, -halfSize);
        p.line(0, -halfSize, +halfSize, +halfSize);
        p.line(halfSize, +halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
        p.popMatrix();
    }
}
