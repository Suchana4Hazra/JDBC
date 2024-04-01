import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class form extends JFrame implements ActionListener {
	
	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2,b3,b4,b5,b6;
	private JPanel[] p;
	
	public form() {
		
		super("Application Form");
		l1 = new JLabel("Student_id");
		l2 = new JLabel("Student_name");
		l3 = new JLabel("Student_contact No");
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		
		b1 = new JButton("ADD");
		b2 = new JButton("DELETE");
		b3 = new JButton("UPDATE");
		b4 = new JButton("FIND");
		b5 = new JButton("RESET");
		b6 = new JButton("CANCEL");
		
		p = new JPanel[4];
		for(int i=0;i<4;i++) {
			
			p[i] = new JPanel();
		}
		
		p[0].setLayout(new GridLayout(1,2,20,20));
		p[0].add(l1);
		p[0].add(t1);
		
		p[1].setLayout(new GridLayout(1,2,20,20));
		p[1].add(l2);
		p[1].add(t2);
		
		p[2].setLayout(new GridLayout(1,2,20,20));
		p[2].add(l3);
		p[2].add(t3);
		
		p[3].setLayout(new GridLayout(1,6,20,20));
		p[3].add(b1);
		p[3].add(b2);
	    p[3].add(b3);
		p[3].add(b4);
		p[3].add(b5);
		p[3].add(b6);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,6,20,20));
		for(int i=0;i<4;i++) {
			c.add(p[i]);
		}
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		setBackground(Color.cyan);
		setResizable(false);
		setSize(800,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			
			dml d = new dml();
			String s1 = t1.getText();
			String s2 = t2.getText();
			String s3 = t3.getText(); 
			int v = d.insert(s1,s2,s3);
			if(v == 1) {
				JOptionPane.showMessageDialog(null,"succ");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
			}	
			else
			{
				JOptionPane.showMessageDialog(null,"no succ");
			}
		}
		else if(e.getSource() == b2) {
			
			dml d = new dml();
			String s = t1.getText();
			int v = d.delete(s);
			if(v == 1) {
				JOptionPane.showMessageDialog(null,"succ");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
			}	
			else
			{
				JOptionPane.showMessageDialog(null,"no succ");
			}
		}
		else if(e.getSource() == b3) {
			
			dml d = new dml();
			String s1 = t1.getText();
			String s2 = t2.getText();
			
			int v = d.update(s1,s2);
			if(v == 1) {
				JOptionPane.showMessageDialog(null,"succ");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
			}	
			else
			{
				JOptionPane.showMessageDialog(null,"no succ");
			}
		}
		else if(e.getSource() == b4) {
			
			dml d = new dml();
			String id = t1.getText();
			ArrayList<String> v = d.find(id);
			
			t1.setText(v.get(0));
			t2.setText(v.get(1));
			t3.setText(v.get(2));
		}
		else if(e.getSource() == b5) {
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		else if(e.getSource() == b6) {
			
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		form f = new form();
	}
}