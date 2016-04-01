import javax.swing.*;

public abstract class ValuableForm extends JPanel
{
	private JTextField nameField = new JTextField(10);
	
	public ValuableForm()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel row1 = new JPanel();
		row1.add(new JLabel("Namn:"));
		row1.add(nameField);
		add(row1);
	}
	
	public String getName()
	{
		return nameField.getText();
	}
	
	public abstract boolean checkInput();
}
