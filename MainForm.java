//MainForm Form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainForm implements ActionListener, ItemListener
{
	String ProgrammingLanguage[] = {"C/C++","C#","Java","JavaAdvance","Python",".NET"};
	String WebDevelopment[] = {"HTML","CSS","JavaScript","Bootstrap","MEAN","MERN"};
	String Database[] = {"SQL","Oracle","MongoDB","Express","Telly","NoSQL"};
	String Graphics[] = {"photoshop","Illustrator","Dreamweaver","Canva" ,"TuxPaint"};
	
	int PLprice[] = {5000,4000,7000,9000,1200,8000}; 
	int WebDprice[] = {3000,4000,6000,4500,15000,12000};	
	int Databaseprice[] = {5400,8900,2800,7500,6700,2000};
	int Graphicsprice[] = {5200,2300,1200,1500,2000};

	JFrame fr;
	JLabel l1,l2, lclose, l3,l4, lphoto,l5,l6,l7,l8,l9,l10;
	JTextField t1, t2, t3, t4, t5,t6;
	JComboBox cb;
	JCheckBox ck;
	JButton b1, b2,b3,b4;
	JList ls1, ls2, ls3, ls4,ls5;
	Dimension dim;
	DefaultListModel modelcart, modelqty, modelprice, modeltotprice, modelProgrammingLanguage , modelWebDevelopment , modelDatabase , modelGraphics;
	double total, dis, nettotal;
	public MainForm()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();	
	
		fr = new JFrame();
		fr.setSize(1366, 768);
		fr.setLocation((dim.width-1366)/2,(dim.height-768)/2);
		fr.setContentPane(new JLabel(new ImageIcon("images/Dashboard.png")));		
		
		lclose = new JLabel(new ImageIcon("images/cl1.png"));
		lclose.setBounds(1320,25 ,16,16);
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
		
		l1 = new JLabel("Select Course");
		l1.setFont(new Font("verdana", Font.BOLD,14));
		l1.setForeground(Color.red);
		l1.setBounds(50,200,150,30);
		fr.add(l1);

		l2 = new JLabel("Choose Course");
		l2.setFont(new Font("verdana", Font.BOLD,14));
		l2.setForeground(Color.red);
		l2.setBounds(250,200,150,30);
		fr.add(l2);
		
		l3 = new JLabel("Add Quantity");
		l3.setFont(new Font("verdana", Font.BOLD,14));
		l3.setForeground(Color.red);
		l3.setBounds(450,200,150,30);
		fr.add(l3);
		
		l4 = new JLabel("Your Cart");
		l4.setFont(new Font("verdana", Font.BOLD,14));
		l4.setForeground(Color.red);
		l4.setBounds(650,200,150,30);
		fr.add(l4);
	
		l5 = new JLabel("Quantity");
		l5.setFont(new Font("verdana", Font.BOLD,14));
		l5.setForeground(Color.red);
		l5.setBounds(850,200,150,30);
		fr.add(l5);
		
		l6 = new JLabel("Price");
		l6.setFont(new Font("verdana", Font.BOLD,14));
		l6.setForeground(Color.red);
		l6.setBounds(950,200,150,30);
		fr.add(l6);
	
		l7 = new JLabel("Total");
		l7.setFont(new Font("verdana", Font.BOLD,14));
		l7.setForeground(Color.red);
		l7.setBounds(1050,200,150,30);
		fr.add(l7);
		
		
		l9 = new JLabel("Enter payment mode");
		l9.setFont(new Font("verdana", Font.BOLD,14));
		l9.setForeground(Color.red);
		l9.setBounds(50,550,200,30);
		fr.add(l9);

		
		l10 = new JLabel("Enter payment mode");
		l10.setFont(new Font("verdana", Font.BOLD,14));
		l10.setForeground(Color.red);
		l10.setBounds(50,600,200,30);
		fr.add(l10);
		
		t5 = new JTextField("");
		t5.setFont(new Font("verdana", Font.BOLD,14));
		t5.setForeground(Color.black);
		t5.setBounds(250,550,150,30);
		fr.add(t5);
		
		t6 = new JTextField("");
		t6.setFont(new Font("verdana", Font.BOLD,14));
		t6.setForeground(Color.black);
		t6.setBounds(250,600,150,30);
		fr.add(t6);

		t1 = new JTextField("1");
		t1.setFont(new Font("verdana", Font.BOLD,14));
		t1.setForeground(Color.black);
		t1.setBounds(450,250,150,30);
		fr.add(t1);
		
		t2 = new JTextField("");
		t2.setFont(new Font("verdana", Font.BOLD,14));
		t2.setForeground(Color.black);
		t2.setBounds(950,500,150,30);
		fr.add(t2);
	
		t3 = new JTextField("");
		t3.setFont(new Font("verdana", Font.BOLD,14));
		t3.setForeground(Color.black);
		t3.setBounds(950,550,150,30);
		fr.add(t3);
		
		t4 = new JTextField("");
		t4.setFont(new Font("verdana", Font.BOLD,14));
		t4.setForeground(Color.black);
		t4.setBounds(950,600,150,30);
		fr.add(t4);

		b1 = new JButton("Add to Cart");
		b1.setFont(new Font("verdana", Font.BOLD,14));
		b1.setForeground(Color.black);	
		b1.setBounds(450,300,150,20);
		b1.addActionListener(this);
		fr.add(b1);
	
		b2 = new JButton("Remove Item");
		b2.setFont(new Font("verdana", Font.BOLD,14));
		b2.setForeground(Color.black);	
		b2.setBounds(1200,250,150,20);
		b2.addActionListener(this);
		fr.add(b2);
	
		b3 = new JButton("Clear Cart");
		b3.setFont(new Font("verdana", Font.BOLD,14));
		b3.setForeground(Color.black);	
		b3.setBounds(1200,300,150,20);
		b3.addActionListener(this);
		fr.add(b3);
	
		b4 = new JButton("Total Item");
		b4.setFont(new Font("verdana", Font.BOLD,14));
		b4.setForeground(Color.black);	
		b4.setBounds(750,500,150,20);
		b4.addActionListener(this);
		fr.add(b4);
	
		cb = new JComboBox();
		cb.addItem("ProgrammingLanguage");
		cb.addItem("WebDevelopment");
		cb.addItem("Database");
		cb.addItem("Graphics");
		cb.setFont(new Font("verdana", Font.BOLD,14));
		cb.setForeground(Color.black);
		cb.setBounds(50,250,150,20);
		fr.add(cb);
		cb.addActionListener(this);

		ck = new JCheckBox("Discount 10%");
		ck.setFont(new Font("verdana", Font.BOLD, 15));
		ck.setForeground(Color.red);
		ck.setBounds(750, 550,200,20);
		ck.setOpaque(false);
		ck.addItemListener(this);
		fr.add(ck);
	
		l8 = new JLabel("Net Total");
		l8.setFont(new Font("verdana" , Font.BOLD , 16));
		l8.setForeground(Color.black);
		l8.setBounds(750,600,150,20);
		fr.add(l8);

		modelProgrammingLanguage= new DefaultListModel();
		for(int i=0; i<ProgrammingLanguage.length;i++)
		{
			modelProgrammingLanguage.add(i,ProgrammingLanguage[i]);
		}
		
		modelWebDevelopment= new DefaultListModel();
		for(int i=0; i<WebDevelopment.length;i++)
		{ 
			modelWebDevelopment.add(i,WebDevelopment[i]);
		}
		
		modelDatabase= new DefaultListModel();
		for(int i=0; i<Database.length;i++)
		{
			modelDatabase.add(i,Database[i]);
		}

		modelGraphics= new DefaultListModel();
		for(int i=0; i<Graphics.length;i++)
		{
			modelGraphics.add(i,Graphics[i]);
		}

		ls1 = new JList(modelProgrammingLanguage);
		ls1.setFont(new Font("verdana" , Font.BOLD,14));
		ls1.setForeground(Color.blue);
		ls1.setBounds(250,250,150,220);
		fr.add(ls1);
		
		modelcart = new DefaultListModel();
		modelqty = new DefaultListModel();
		modelprice = new DefaultListModel();
		modeltotprice = new DefaultListModel();

		ls2 = new JList();
		ls2.setModel(modelcart);
		ls2.setFont(new Font("verdana" , Font.BOLD,14));
		ls2.setForeground(Color.blue);
		ls2.setBounds(650,250,200,220);
		fr.add(ls2);
		
		ls3 = new JList();
		ls3.setModel(modelqty);
		ls3.setFont(new Font("verdana" , Font.BOLD,14));
		ls3.setForeground(Color.blue);
		ls3.setBounds(850,250,50,220);
		fr.add(ls3);
		
		ls4 = new JList();
		ls4.setModel(modelprice);
		ls4.setFont(new Font("verdana" , Font.BOLD,14));
		ls4.setForeground(Color.blue);
		ls4.setBounds(950,250,150,220);
		fr.add(ls4);
	
		ls5 = new JList();
		ls5.setModel(modeltotprice);
		ls5.setFont(new Font("verdana" , Font.BOLD,14));
		ls5.setForeground(Color.blue);
		ls5.setBounds(1050,250,150,220);
		fr.add(ls5);
		
		fr.setUndecorated(true);
		fr.setVisible(true);

	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(t2.getText().length()!=0)
		{
			if(ck.isSelected()==true)
			{
				dis = total*10/100;
				nettotal = total-dis;
				t3.setText(""+dis);
				t4.setText(""+nettotal);
			}
			else
			{
				nettotal= total;
				dis =0;
				t3.setText("");
				t4.setText(""+nettotal);
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
 			if (ls1.getSelectedIndex()!=-1)
			{ 
				if(!t1.getText().equals("0"))
				{
					int qty = Integer.parseInt(t1.getText());
					int indx = ls1.getSelectedIndex();
					int price =0;
					String item="";			
					if(cb.getSelectedItem().toString().equals("ProgrammingLanguage"))
					{
						item = (String)modelProgrammingLanguage.get(indx);
						price = PLprice[indx];
					}
					else if(cb.getSelectedItem().toString().equals("WebDevelopment"))
					{
						item = (String)modelProgrammingLanguage.get(indx);
						price = WebDprice[indx];
					}
					else if(cb.getSelectedItem().toString().equals("Database"))
					{
						item = (String)modelProgrammingLanguage.get(indx);
						price = Databaseprice[indx];
					}
					else if(cb.getSelectedItem().toString().equals("Graphics"))
					{
						item = (String)modelProgrammingLanguage.get(indx);
						price = Graphicsprice[indx];
					}
					
					modelcart.addElement(item);
					modelqty.addElement(qty);
					modelprice.addElement(price);
					modeltotprice.addElement(price*qty);
				}
				else
				{
					JOptionPane.showMessageDialog(fr,"Quantity can't be 0");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(fr,"Please choose item to add in Cart");
			}
		}

		else if(ae.getSource()==b2)	
		{

			if(modelcart.isEmpty()==false)
			{
				if(ls2.getSelectedIndex()!=-1)
				{
					int indx = ls2.getSelectedIndex();
					int totprice = (Integer)modeltotprice.get(indx);
					if(t2.getText().length()!=0 || ls2.getSelectedIndex()!=1)
					{
						total= total- totprice;
						nettotal = total;
						if(ck.isSelected()==true)
						{
							dis = total*10/100;
							nettotal = total-dis;
							t3.setText(""+dis);
						}
						t2.setText(""+total);
						t4.setText(""+nettotal);
						
						modelcart.remove(indx);
						modelqty.remove(indx);
						modelprice.remove(indx);
						modeltotprice.remove(indx);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(fr, "please Select Item from your Cart");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(fr, "Sorry! there is no item in the cart");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				ck.setSelected(false);
			}
		}

		else if(ae.getSource()==b3)
		{
			if(modelcart.isEmpty()==false)
			{
				modelcart.clear();
				modelqty.clear();
				modelprice.clear();
				modeltotprice.clear();
				t2.setText("");
				t3.setText("");
				t4.setText("");
				ck.setSelected(false);
			
			}	
			else
			{
				JOptionPane.showMessageDialog(fr, "Your Cart is already empty");
			}	
		}
		else if(ae.getSource()==b4)
		{
			if(modelcart.isEmpty()==false)
			{
				total = 0;
				for(int i=0; i<modeltotprice.size() ; i++)
				{
					total = total +(Integer)modeltotprice.get(i);
				}
				t2.setText(""+total);
				nettotal = total -dis;
				if(ck.isSelected()==true)
				{
					dis = total*10/100;
					nettotal = total-dis;
					t3.setText(""+dis);
				}
				t4.setText(""+nettotal);
			}
			else
			{
				JOptionPane.showMessageDialog(fr,"Your Cart is empty, Total is not Possible");
			}
		}
		else
		{
			String item = cb.getSelectedItem().toString();
			if(item.equals("ProgrammingLanguage"))
			{
				ls1.setModel(modelProgrammingLanguage);
			}
			else if(item.equals("WebDevelopment"))
			{
				ls1.setModel(modelWebDevelopment);
			}
			else if(item.equals("Database"))
			{
				ls1.setModel(modelDatabase);
			}
			else if(item.equals("Graphics"))
			{
				ls1.setModel(modelGraphics);
			}
		}
	}

	public static void main(String args[])
	{
		new MainForm();
	}
}