import java.util.ArrayList;
import java.util.Collections;

public class ValuableRegistry 
{
	private ArrayList<Valuable> valuables;
	
	public ValuableRegistry()
	{
		valuables = new ArrayList<>();
	}
	
	public void addJewelry(String name, int gemstones, boolean isGold)
	{
		valuables.add(new Jewelry(name, gemstones, isGold));
	}
	
	public void addShare(String name, int number, double price)
	{
		valuables.add(new Share(name, number, price));
	}
	
	public void addDevice(String name, double purchasePrice, int wear)
	{
		valuables.add(new Device(name, purchasePrice, wear));
	}
	
	public void sortByName()
	{
		Collections.sort(valuables, new NameComparator());
	}
	
	public void sortByValue()
	{
		Collections.sort(valuables, new ValueComparator());
	}
	
	public void setSharePrice(double newPrice)
	{
		for(Valuable v : valuables)
		{
			if(v instanceof Share)
			{
				((Share) v).setPrice(newPrice);
			}
		}
	}
	
	public String[] getValuableList()
	{
		String[] list = new String[valuables.size()];
		
		for(int i = 0; i < list.length; i++)
		{
			list[i] = valuables.get(i).toString();
		}
		
		return list;
	}
}
