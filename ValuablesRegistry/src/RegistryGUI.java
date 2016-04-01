import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistryGUI extends JFrame
{
	private ValuableRegistry registry = new ValuableRegistry();
	
	private JTextArea ValuableListArea;
	private JRadioButton sortByName, sortByValue;
	private JComboBox newValuable;
	private JButton showButton;
	private JButton crashSharePriceButton;
	
	public static void main(String[] args)
	{
		new RegistryGUI();
	}
	
	public RegistryGUI()
	{
		super("Sakregister");
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		
		JLabel headLabel = new JLabel("Värdesaker");
		northPanel.add(headLabel);
		
		ValuableListArea = new JTextArea(15, 20);
		ValuableListArea.setEditable(false);
		JScrollPane ValuableScrollbar = new JScrollPane(ValuableListArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JLabel sortLabel = new JLabel("Sortering:");
		eastPanel.add(sortLabel);
		
		sortByName = new JRadioButton("Namn");
		sortByValue = new JRadioButton("Värde");
		
		ButtonGroup sortOptions = new ButtonGroup();
		sortOptions.add(sortByName);
		sortOptions.add(sortByValue);
		
		eastPanel.add(sortByName);
		eastPanel.add(sortByValue);
		
		sortByName.setSelected(true);
		
		JLabel newValuableLabel = new JLabel("Nytt");
		southPanel.add(newValuableLabel);
		
		String[] valuableTypes = {"Smycke", "Aktie", "Apparat"};
		newValuable = new JComboBox(valuableTypes);
		newValuable.addActionListener(new ListenForNewValuable());
		southPanel.add(newValuable);
		
		showButton = new JButton("Visa");
		ListenForShowButton showListener = new ListenForShowButton();
		showButton.addActionListener(showListener);
		southPanel.add(showButton);
		
		crashSharePriceButton = new JButton("Börskrash");
		ListenForCrashShareButton crashPriceListener = new ListenForCrashShareButton();
		crashSharePriceButton.addActionListener(crashPriceListener);
		southPanel.add(crashSharePriceButton);
		
		add(northPanel, BorderLayout.NORTH);
		add(ValuableScrollbar, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ListenForShowButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
				listValuables();
		}
	}
	
	private class ListenForCrashShareButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
				registry.setSharePrice(0);
		}
	}
	
	private class ListenForNewValuable implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String valuableSelection = (String) newValuable.getSelectedItem();
			
			if(valuableSelection.equals("Smycke"))
			{
				JewelForm j = new JewelForm();
				int end = JOptionPane.showConfirmDialog(RegistryGUI.this, j, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
				
				if(end == JOptionPane.OK_OPTION)
				{
					if(j.checkInput())
					{
						registry.addJewelry(j.getName(), j.getGemstones(), j.getGold());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Fel inmatning","Fel", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if(valuableSelection.equals("Aktie"))
			{
				ShareForm s = new ShareForm();
				int end = JOptionPane.showConfirmDialog(RegistryGUI.this, s, "Ny Aktie", JOptionPane.OK_CANCEL_OPTION);
				
				if(end == JOptionPane.OK_OPTION)
				{
					registry.addShare(s.getName(), s.getNumber(), s.getPrice());
				}
			}
			else
			{
				DeviceForm d = new DeviceForm();
				int end = JOptionPane.showConfirmDialog(RegistryGUI.this, d, "Ny apparat", JOptionPane.OK_CANCEL_OPTION);
				
				if(end == JOptionPane.OK_OPTION)
				{
					registry.addDevice(d.getName(), d.getPrice(), d.getWear());
				}
			}
		}
	}
	
	private void listValuables()
	{
		if(sortByName.isSelected())
		{
			registry.sortByName();
		}
		else
		{
			registry.sortByValue();
		}
		
		String[] valuables = registry.getValuableList();
		ValuableListArea.setText(null);
		
		for(String s : valuables)
		{
			ValuableListArea.append(s + "\n");
		}
	}
}
