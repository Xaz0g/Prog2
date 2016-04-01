
public class Device extends Valuable
{
	private double purchasePrice;
	private int wear;
	
	public Device(String name, double purchasePrice, int wear) 
	{
		super(name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
		
		calculateValue();
	}

	@Override
	public void calculateValue() 
	{	
		setValue(purchasePrice*((double) wear/10));
	}

	@Override
	public String toString() 
	{
		return "Apparat: " + getName() + " Värde: " + getValue() + " Pris: " + purchasePrice + " Slitage: " + wear;
	}

}
