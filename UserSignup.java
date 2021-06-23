//UserSignUp Form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

class UserSignup implements ActionListener
{
	JFrame fr;
	JLabel l1,l2, lclose, l3,l4, lphoto,l5,l6,l7,l8;
	JTextField t1, t2;
	JPasswordField t3;
	JButton b1, b2;
	Dimension dim;
	Image original,scaled;
	String path;
	boolean bn;

	public UserSignup()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();	
	
		fr = new JFrame();
		fr.setSize(800, 450);
		fr.setLocation((dim.width-800)/2,(dim.height-450)/2);
		fr.setContentPane(new JLabel(new ImageIcon("images/Signupimage.png")));		
		
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
		
		l1 = new JLabel("Enter UserName");
		l2 = new JLabel("Enter Email");
		l3 = new JLabel("Enter Password");
		l4 = new JLabel("Upload Picture");
		l1.setBounds(425,150,150,30);
		l2.setBounds(425, 200, 150, 30);
		l3.setBounds(425, 250, 150, 30);
		l4.setBounds(425,300, 150, 30);
		l1.setFont(new Font("verdana", Font.PLAIN, 18));
		l2.setFont(new Font("verdana",Font.PLAIN ,18));
		l3.setFont(new Font("verdana",Font.PLAIN ,18));
		l4.setFont(new Font("verdana", Font.PLAIN, 18));
		l1.setForeground(Color.black );
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(l4);
	
		l7 = new JLabel("<html><u>Login</u></html>");
		l8 = new JLabel("<html><u>Forget Password</u></html>");
		l7.setFont(new Font("verdana",Font.PLAIN,12));
		l8.setFont(new Font("verdana",Font.PLAIN,12));
		l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l7.setBounds(425,320,110,50);
		l8.setBounds(425,350,110,50);
		l7.setForeground(Color.pink);
		l8.setForeground(Color.pink);
		fr.add(l7);
		fr.add(l8);

		l7.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l7.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent me)
			{
				l7.setForeground(Color.pink);
			}
			public void mouseClicked(MouseEvent me)
			{
				new Login();
			}		
		});

		l8.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me)
			{
				l8.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent me)
			{
				l8.setForeground(Color.pink);
			}
			public void mouseClicked(MouseEvent me)
			{
				new PswdRecovery();
			}
		});


		lphoto = new JLabel(new ImageIcon("images/Browseimage.jpg"));
		lphoto.setBounds(630, 300, 70, 70);
		lphoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fr.add(lphoto);	
		lphoto.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				try
				{
					FileDialog fd = new FileDialog(fr,"Select Photo", FileDialog.LOAD);
					fd.setVisible(true);
					path = fd.getDirectory() + fd.getFile();

					if(path.equals("nullnull"))
					{
						bn = false;
					}
					else
					{
						bn = true;
						original = Toolkit.getDefaultToolkit().getImage(path);
						scaled = original.getScaledInstance(70,70,Image.SCALE_DEFAULT);
						lphoto.setIcon(new ImageIcon(scaled));
					}
				}
				catch(Exception e)
				{}	
			}
		
		});
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JPasswordField();
		t1.setBounds(600,150,150,30);
		t2.setBounds(600,200, 150, 30);
		t3.setBounds(600,250,150,30);
		t1.setFont(new Font("verdana", Font.PLAIN, 18));
		t2.setFont(new Font("verdana",Font.PLAIN ,18));
		t3.setFont(new Font("verdana", Font.PLAIN,18));
		t1.setForeground(Color.black);
		t2.setForeground(Color.black);
		t3.setForeground(Color.black);
		fr.add(t1);
		fr.add(t2);
		fr.add(t3);
		
		b1 = new JButton("Submit");
		b2 = new JButton("Reset");
		b1.setFont(new Font("verdana",Font.PLAIN,16));
		b2.setFont(new Font("verdana",Font.PLAIN,16));
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b1.setBounds(550,380,100,30);
		b2.setBounds(680,380,100,30);
		fr.add(b1);
		fr.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		fr.setUndecorated(true);
		fr.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b2)	
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			lphoto.setIcon(new ImageIcon("images/browseimage.jpg"));
			bn=false;
			path =null;
		}
		if(ae.getSource()==b1)
		{
			if(t1.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Please Enter your Username");
				t1.requestFocus();
			}
			else if(t2.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Please Enter your Email");
				t2.requestFocus();
			}
			else if(t3.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Please Enter your Password");
				t3.requestFocus();
			}
			else if(bn == false)
			{
				JOptionPane.showMessageDialog(fr,"Please Browse Photo");
			}
			else
			{
				String stremail = t2.getText();
				String prtemail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";								
				
				Pattern ptrn = Pattern.compile(prtemail);
				Matcher mtch = ptrn.matcher(stremail);
		
				if(mtch.matches()==true)
				{
					try
					{
						//step1 and step2
						Connection con = DAO.createConnection();
			
						//step3
						PreparedStatement ps = con.prepareStatement("insert into shopping_mall values(?,?,?,?)");
						ps.setString(1,t1.getText());
						ps.setString(2,t2.getText());
						ps.setString(3,t3.getText());
						FileInputStream fis = new FileInputStream(path);
						ps.setBinaryStream(4,fis,fis.available());

						//step4
						int z = ps.executeUpdate();
						if(z>0)
						{
							JOptionPane.showMessageDialog(fr,"New User Created Successfully");
						}		
						else
						{
						JOptionPane.showMessageDialog(fr,"Error While Creating New User");
						}

						//step5
						con.close();
		
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(fr, "User alredy Exists");
					}

				}
				else
				{
					JOptionPane.showMessageDialog(fr,"Invalid Email ID\n Example: abc@gmail.com");
				}
			}
		}
	}
	public static void main(String args[])
	{
		new UserSignup();
	}
}