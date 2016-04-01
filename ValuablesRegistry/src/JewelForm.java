import javax.swing.*;

public class JewelForm extends ValuableForm
{
	private JTextField gemstoneField = new JTextField(10);
	private JCheckBox isGoldBox = new JCheckBox("Av guld");
	
	public JewelForm()
	{
		super();
		
		JPanel row2 = new JPanel();
		row2.add(new JLabel("Stenar:"));
		row2.add(gemstoneField);
		add(row2);
		
		JPanel row3 = new JPanel();
		row3.add(isGoldBox);
		add(row3);
	}
	
	public int getGemstones()
	{
		return Integer.parseInt(gemstoneField.getText());
	}
	
	public boolean getGold()
	{
		if(isGoldBox.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean checkInput() 
	{
		if(getName().length() == 0 || gemstoneField.getText().length() == 0)
		{
			return false;
		}
		else
		{
			try
			{
				Integer.parseInt(gemstoneField.getText());
			}
			catch(NumberFormatException e)
			{
				return false;
			}
		}
		
		return true;
	}
}
