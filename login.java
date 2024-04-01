import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class login extends JFrame implements ActionListener{
	
       private JTextField t1;
       private JPasswordField t2;
       private JLabel l1,l2;
       private JButton b1,b2;
       private JPanel[] p;
       
       public login() {
       	
       	super("Login Page");
       	l1 = new JLabel("Enter Username: ");
       	l2 = new JLabel("Enter Password: ");
       	t1 = new JTextField(20);
       	t2 = new JPasswordField(20);
       	b1 = new JButton("Submit");
       	b2 = new JButton("Cancel");
       	p = new JPanel[3];
       	
       	for(int i=0;i<3;i++) {
       		p[i] = new JPanel();
     	}
     	p[0].setLayout(new GridLayout(1,2,20,20));
     	p[0].add(l1);
     	p[0].add(t1);
     	
     	p[1].setLayout(new GridLayout(1,2,20,20));
     	p[1].add(l2);
     	p[1].add(t2);
     	
     	p[2].setLayout(new GridLayout(1,1,20,20));
     	p[2].add(b1);
     	p[2].add(b2);
     	
     	Container c = getContentPane();
     	c.setLayout(new GridLayout(3,2,20,20));
     	for(int i=0;i<3;i++) {
     		c.add(p[i]);
     	}
     	b1.addActionListener(this);
     	b2.addActionListener(this);
     	setResizable(false);
     	setSize(400,200);
     	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b1) {
    		String s1 = t1.getText();
    		String s2 = t2.getText();
    		dml d = new dml();
    		int flag = 0;
    		
    		ArrayList<ArrayList<String>> v = d.list();
    		for(int i=0;i<v.get(0).size();i++) {
    			
    			if(s1.equals(v.get(0).get(i)) && s2.equals(v.get(1).get(i))) {
    				
    				flag = 1;
    				JOptionPane.showMessageDialog(null,"Login successful");
    				setVisible(false);
    				form f = new form();
    			}
    		}
    		if(flag == 0) {
    			
    			JOptionPane.showMessageDialog(null,"invalid username or password");
    		}
    	} else if(e.getSource() == b2) {
    		
    		System.exit(0);
    	}
    }
    public static void main(String[] args) {
    	login obj = new login();
    }
}