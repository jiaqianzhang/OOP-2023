package ie.tudublin;

public class Cat
{
	// field class names
	String name;
	private int numLives = 9;

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumlives() 
	{
		return numLives;
	}
	
	public void kill()
	{
		if (numLives > 0)
		{
			numLives--;
			System.out.println("Ouch!");
		}
		else if (numLives == 0)
		{
			System.out.println("Dead!");
		}
	}
}