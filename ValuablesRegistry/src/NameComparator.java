import java.util.Comparator;

public class NameComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) 
	{
		Valuable v1 = (Valuable) o1;
		Valuable v2 = (Valuable) o2;
		
		return v1.getName().compareTo(v2.getName());
	}
}
