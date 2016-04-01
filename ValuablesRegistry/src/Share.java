
public class Share extends Valuable
{
	private int number;
	private double price;

	public Share(String name, int number, double price) 
	{
		super(name);
		this.number = number;
		this.price = price;
		
		calculateValue();
	}
	
	public void setPrice(double price)
	{
		this.price = price;
		calculateValue();
	}

	@Override
	public void calculateValue() 
	{
		setValue(number*price);
	}
	
	@Override
	public String toString()
	{
		return "Aktie: " + getName() + " Värde: " + getValue() + " Antal: " + number + " Kurs: " + price;
	}

}
