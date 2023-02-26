package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

// creating a class called Star to encapsulate the columns of interest from a single row from the file
public class Star
{
    private boolean hab;
    private String displayName;
    private float distance;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;

    // making a toString method to help to print the contents of the array
    // this should be called from setup after you load the data
    @Override
    public String toString() 
    {
        return "Star [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    // constructor that takes table row as a parameter
    // assigns the fields in the class from the columns in tr
    // tb represent a single row of data values srtoed in columns from a table
    public Star(TableRow tr)
    {
        this(
            tr.getInt("Hab?") == 1, 
            tr.getString("Display Name"), 
            tr.getFloat("Distance"),
            tr.getFloat("Xg"),
            tr.getFloat("Yg"),
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }
    
    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) 
    {
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    public boolean isHab() 
    {
        return hab;
    }

    public void setHab(boolean hab) 
    {
        this.hab = hab;
    }

    public String getDisplayName() 
    {
        return displayName;
    }

    public void setDisplayName(String displayName) 
    {
        this.displayName = displayName;
    }

    public float getDistance() 
    {
        return distance;
    }

    public void setDistance(float distance) 
    {
        this.distance = distance;
    }

    public float getxG() 
    {
        return xG;
    }

    public void setxG(float xG) 
    {
        this.xG = xG;
    }

    public float getyG() 
    {
        return yG;
    }

    public void setyG(float yG)
    {
        this.yG = yG;
    }

    public float getzG() 
    {
        return zG;
    }

    public void setzG(float zG) 
    {
        this.zG = zG;
    }

    public float getAbsMag() 
    {
        return absMag;
    }

    public void setAbsMag(float absMag) 
    {
        this.absMag = absMag;
    }

    // plotting the stars onto the grid
    public void render(StarMap p)
    {
        // final method is when a variable cannot be changed
        // static method is a variable that can be called without creating a object within a class
        float border = p.width * 0.1f;
        float x = PApplet.map(xG, -5, 5, border, p.width - border); // use Xg value
        float y = PApplet.map(yG, -5, 5, border, p.height - border); // use Yg value

        // for line
        p.stroke(255, 255, 0); // yellow
        p.line(x, y-5, x, y+5);
        p.line(x-5, y, x+5, y);
        // for circle
        p.stroke(255, 0, 0); // red
        p.circle(x, y, absMag);
        p.fill(255);
        p.textAlign(PApplet.LEFT, PApplet.CENTER);
        p.textSize(16);
        p.text(displayName, x+20, y);
        p.noFill();
    }
}