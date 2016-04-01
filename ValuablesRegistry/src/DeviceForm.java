import javax.swing.*;

public class DeviceForm extends ValuableForm
{
	private JTextField priceField = new JTextField(10);
	private JTextField wearField = new JTextField(10);
	
	public DeviceForm()
	{
		super();
		
		JPanel row2 = new JPanel();
		row2.add(new JLabel("Inköpspris:"));
		row2.add(priceField);
		add(row2);
		
		JPanel row3 = new JPanel();
		row3.add(new JLabel("Slitage:"));
		row3.add(wearField);
		add(row3);
	}
	
	public double getPrice()
	{
		return Double.parseDouble(priceField.getText());
	}
	
	public int getWear()
	{
		return Integer.parseInt(wearField.getText());
	}

	@Override
	public boolean checkInput() {
		// TODO Auto-generated method stub
		return false;
	}
}
