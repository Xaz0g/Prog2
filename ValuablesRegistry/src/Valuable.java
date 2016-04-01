
public abstract class Valuable 
{
	private String name;
	private double value;
	private final static double VAT = 1.25;
	
	public Valuable(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public void setValue(double value)
	{
		this.value = value*VAT;
	}
	
	public abstract void calculateValue();
	
	@Override
	public abstract String toString();
}