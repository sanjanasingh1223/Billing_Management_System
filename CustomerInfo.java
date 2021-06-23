/ Form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CustomerInfo
{
	JFrame fr;
	JLabel l1,l2, lclose, l3,l4, lphoto,l5,l6, l7,l8,l9,l10;
	JTextField t1, t2,t3,t4,t5,t6,t7,t8,t9;
	JButton b1, b2;
	Dimension dim;

	public CustomerInfo()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();	
	
		fr = new JFrame();
		fr.setSize(800, 450);
		fr.setLocation((dim.width-800)/2,(dim.height-450)/2);
		fr.setContentPane(new JLabel(new ImageIcon("images/CustomerPage.png")));		
		
		lclose = new JLabel(new ImageIcon("images/cl1.png"));
		lclose.setBounds(770,5 ,16,16);
		lclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lclose.setToolTipText("Click to Exit");
		fr.add(lclose);
		
		lclose.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				lclose.setIcon(new ImageIcon("images/cl2.png"));
	
			}
			public void mouseExited(MouseEvent me)
			{
				lclose.setIcon(new ImageIcon("images/cl1.png"));
			}
			public void mouseClicked(MouseEvent me)
			{
				System.exit(0);
			}
		}
		);
		
		l1 = new JLabel("Name");
		l2 = new JLabel("Father's Name");
		l3 = new JLabel("EmailId ");
		l4 = new JLabel("Phone No");
		l5 = new JLabel("DOB");
		l6 = new JLabel("Highest Qualification");
		l7 = new JLabel("Address");
		l8 = new JLabel("Skype Id");
		l9 = new JLabel("Trainer");
		l10 = new JLabel("Student Photo");
		l1.setBounds(50,130,150,20);
		l2.setBounds(380,130,150,20);
		l3.setBounds(50,180,150,20);
		l4.setBounds(380,180,150,20);
		l5.setBounds(50,230,150,20);
		l6.setBounds(380,230,150,20);
		l7.setBounds(50,280,150,20);
		l8.setBounds(380,280,150,20);
		l9.setBounds(50,330,150,20);
		l10.setBounds(380,330,150,20);
		l1.setFont(new Font("verdana", Font.PLAIN, 18));
		l2.setFont(new Font("verdana",Font.PLAIN ,18));
		l3.setFont(new Font("verdana",Font.PLAIN ,18));
		l4.setFont(new Font("verdana", Font.PLAIN, 18));
		l5.setFont(new Font("verdana", Font.PLAIN, 18));
		l6.setFont(new Font("verdana", Font.PLAIN, 18));
		l7.setFont(new Font("verdana", Font.PLAIN, 18));
		l8.setFont(new Font("verdana", Font.PLAIN, 18));
		l9.setFont(new Font("verdana", Font.PLAIN, 18));
		l10.setFont(new Font("verdana", Font.PLAIN, 18));
		l1.setForeground(Color.BLACK );
		l2.setForeground(Color.BLACK );
		l3.setForeground(Color.BLACK );
		l4.setForeground(Color.BLACK );
		l5.setForeground(Color.BLACK );
		l6.setForeground(Color.BLACK );
		l7.setForeground(Color.BLACK );
		l8.setForeground(Color.BLACK );
		l9.setForeground(Color.BLACK );
		l10.setForeground(Color.BLACK );
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
		fr.add(l5);
		fr.add(l6);
		fr.add(l7);
		fr.add(l8);
		fr.add(l9);
		fr.add(l10);
		lphoto = new JLabel(new ImageIcon("images/Browseimage.jpg"));
		lphoto.setBounds(550, 320, 100, 100);
		lphoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lphoto);	
	
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();
		t1.setBounds(150,130,200,30);
		t2.setBounds(550,130,200,30);
		t3.setBounds(150,180,200,30);
		t4.setBounds(550,180,200,30);
		t5.setBounds(150,230,200,30);
		t6.setBounds(550,230,200,30);
		t7.setBounds(150,280,200,30);
		t8.setBounds(550,280,200,30);
		t9.setBounds(150,330,200,30);
		t1.setFont(new Font("verdana", Font.PLAIN, 18));
		t2.setFont(new Font("verdana",Font.PLAIN ,18));
		t3.setFont(new Font("verdana", Font.PLAIN,18));
		t4.setFont(new Font("verdana", Font.PLAIN, 18));
		t5.setFont(new Font("verdana",Font.PLAIN ,18));
		t6.setFont(new Font("verdana", Font.PLAIN,18));
		t7.setFont(new Font("verdana", Font.PLAIN, 18));
		t8.setFont(new Font("verdana",Font.PLAIN ,18));
		t9.setFont(new Font("verdana", Font.PLAIN,18));
		t1.setForeground(Color.black);
		t2.setForeground(Color.black);
		t3.setForeground(Color.black);
		t4.setForeground(Color.black);
		t5.setForeground(Color.black);
		t6.setForeground(Color.black);
		t7.setForeground(Color.black);
		t8.setForeground(Color.black);
		t9.setForeground(Color.black);
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		fr.add(t4);
		fr.add(t5);
		fr.add(t6);
		fr.add(t7);
		fr.add(t8);
		fr.add(t9);
		
		b1 = new JButton("Submit");
		b2 = new JButton("Reset");
		b1.setFont(new Font("verdana",Font.PLAIN,16));
		b2.setFont(new Font("verdana",Font.PLAIN,16));
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b1.setBounds(200,400,100,30);
		b2.setBounds(330,400,100,30);
		fr.add(b1);
		fr.add(b2);
		fr.setUndecorated(true);
		fr.setVisible(true);
	}
	public static void main(String args[])
	{
		new CustomerInfo();
	}
}