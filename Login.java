//Login Form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Login implements ActionListener
{
	JFrame fr;
	JLabel l1,l2, lclose, l3, l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	Dimension dim;

	public Login()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();	
	
		fr = new JFrame();
		fr.setSize(800, 450);
		fr.setLocation((dim.width-800)/2,(dim.height-450)/2);
		fr.setContentPane(new JLabel(new ImageIcon("images/loginimage.png")));		
		
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
		});
		
		l1 = new JLabel("Enter Username");
		l2 = new JLabel("Enter Password");
		l1.setBounds(425,200,150,30);
		l2.setBounds(425, 250, 150, 30);
		l1.setFont(new Font("verdana", Font.PLAIN, 16));
		l2.setFont(new Font("verdana",Font.PLAIN ,16));
		l1.setForeground(Color.black );
		l2.setForeground(Color.black );
		fr.add(l1);
		fr.add(l2);

		t1 = new JTextField();
		t2 = new JPasswordField();
		t1.setBounds(625,200,150,30);
		t2.setBounds(625,250, 150, 30);
		t1.setFont(new Font("verdana", Font.PLAIN, 16));
		t2.setFont(new Font("verdana",Font.PLAIN ,16));
		t1.setForeground(Color.black);
		t2.setForeground(Color.black);
		fr.add(t1);
		fr.add(t2);
		
		l3 = new JLabel("<html><u>New User Signup</u></html>");
		l4 = new JLabel("<html><u>Forget Password</u></html>");
		l3.setFont(new Font("verdana",Font.PLAIN,12));
		l4.setFont(new Font("verdana",Font.PLAIN,12));
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l3.setBounds(425,330,110,50);
		l4.setBounds(425,360,110,50);
		l3.setForeground(Color.pink);
		l4.setForeground(Color.pink);
		fr.add(l3);
		fr.add(l4);

		l3.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l3.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent me)
			{
				l3.setForeground(Color.pink);
			}
			public void mouseClicked(MouseEvent me)
			{
				new UserSignup();
			}		
		});

		l4.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l4.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent me)
			{
				l4.setForeground(Color.pink);
			}
			public void mouseClicked(MouseEvent me)
			{
				new PswdRecovery();
			}
		});

		
		b1 = new JButton("Login");
		b1.setFont(new Font("verdana",Font.PLAIN,16));
		b1.setForeground(Color.blue);
		b1.setBounds(500,300,100,30);
		b1.addActionListener(this);
		fr.add(b1);
		
		b2 = new JButton("Reset");
		b2.setFont(new Font("verdana",Font.PLAIN,16));
		b2.setForeground(Color.blue);
		b2.setBounds(650,300,100,30);
		b2.addActionListener(this);
		fr.add(b2);
		fr.setUndecorated(true);
		fr.setVisible(true);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
			}
			else
			{
				try
				{	
				//step1 and step2
				Connection con = DAO.createConnection();
		
				//step3
				PreparedStatement ps = con.prepareStatement("SELECT * from SHOPPING_MALL  where username=? and password=?");
				ps.setString(1,t1.getText()); 
				ps.setString(2,t2.getText()); 

				//step4
				ResultSet rs = ps.executeQuery();

				if(rs.next()==true)
				{
					JOptionPane.showMessageDialog(fr,"Welcome , "+t1.getText().toUpperCase());
					new MainForm();
				fr.dispose();
				}
				else
				{
				JOptionPane.showMessageDialog(fr,"Sorry! Invalid Username or Password");
				}
		
				//step5
				con.close();
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(fr,""+e);
			}
		}
	
	}
	public static void main(String args[])
	{
		new Login();
	}
}