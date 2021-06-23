//Splash

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Splash
{	
	JFrame fr;
	JLabel line;
	Dimension dim;
	
	public Splash()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame();
		fr.setSize(500,300);
		fr.setLocation((dim.width-500)/2 , (dim.height-300)/2);
		fr.setContentPane(new JLabel(new ImageIcon("Images/splash.jpg")));
		fr.setUndecorated(true);
		fr.setVisible(true);
	
		line = new JLabel(new ImageIcon("Images/line.png"));
		line.setLocation(30,245);
		fr.add(line);

		try
		{
			for(int i=1; i<=442; i++)
			{
				line.setSize(i,4);
				Thread.sleep(20);
			}
			
				new Login();
		}
		catch(Exception e)
		{
		}
	}
	public static void main(String args[])
	{
		new Splash();
	}
}