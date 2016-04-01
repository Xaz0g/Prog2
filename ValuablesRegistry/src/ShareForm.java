import javax.swing.*;

public class ShareForm extends ValuableForm
{
	private JTextField numberField = new JTextField(10);
	private JTextField priceField = new JTextField(10);
	
	public ShareForm()
	{
		super();
		
		JPanel row2 = new JPanel();
		row2.add(new JLabel("Antal:"));
		row2.add(numberField);
		add(row2);
		
		JPanel row3 = new JPanel();
		row3.add(new JLabel("Kurs:"));
		row3.add(priceField);
		add(row3);
	}
	
	public int getNumber()
	{
		return Integer.parseInt(numberField.getText());
	}
	
	public double getPrice()
	{
		return Double.parseDouble(priceField.getText());
	}

	@Override
	public boolean checkInput() {
		// TODO Auto-generated method stub
		return false;
	}
}
