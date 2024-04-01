import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class showAll extends JFrame {
	
	private JTable tb;
	
	public showAll() {
		
		super("List");
	    dml d = new dml();
		ArrayList<String> v = d.list();
		String[] head = {"Id","Name","Contact_no"};
		int row = v.size();
		String[][] y = new String[row][3];
		int z = 0;
		
		try {
		
		for(int i=0;i<row;i++) {
			
			for(int j=0;j<3;j++) {
				
				y[i][j] = (String)v.get(z);
				z++;
			}
		}
	} catch(Exception e) {
			
		}
		
		tb = new JTable(y,head);
		JScrollPane jp = new JScrollPane(tb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jp);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		showAll obj = new showAll();
	}
}