
public class Jewelry extends Valuable
{
	private int gemstones;
	private boolean isGold;

	public Jewelry(String name, int gemstones, boolean isGold) 
	{
		super(name);
		this.gemstones = gemstones;
		this.isGold = isGold;
		
		calculateValue();
	}

	@Override
	public void calculateValue() 
	{
		setValue((isGold ? 2000 : 700) + (gemstones*500));
	}
	
	@Override
	public String toString()
	{
		return "Smycke: " + getName() + " Värde: " + getValue() + " Stenar: " + gemstones + " " + (isGold ? "Guld" : "Silver");
	}
}
