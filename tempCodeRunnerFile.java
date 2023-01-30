package ie.tudublin;

public class Cat
{
	String name;
	private int numLives;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void kill(int numLives)
	{
		if (numLives > 0)
		{
			numLives = numLives - 1;
			System.out.println("Ouch!");
		}
		if (numLives == 0)
		{
			System.out.println("Dead");
		}
	}
}