import java.awt.Color;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Main {

	static int  Array[]= new int[97];
	public static ArrayList<String> stringArrayList= new ArrayList<>();
	static BitSet bitset=new BitSet(97);
	private static JTextField textField;
	static JButton btnNewButton = new JButton("New button");
	static JLabel lblNewLabel = new JLabel();
	static ArrayList<JTextField>  textList= new ArrayList<>();
	private static JTextField textField_1;
	private static JTextField textField_2;
	static JLabel lblNewLabel_2 = new JLabel();
	static JLabel lblNewLabel_2_1 = new JLabel();
	public static void main(String[] args) {
			
		
        hash("asd");
        hash("Atü");
        hash("School");
        hash("xd");
        hash("futbol");
        hash("watch");
        hash("cs");
        hash("Computer");
        

		JFrame frame = new JFrame("WINDOW6");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(700,300,937,744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(38, 43, 30, 20);
		frame.getContentPane().add(spinner);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int y=0;
				
				for (int i = 0; i < (int)spinner.getValue(); i++) {
					textList.add(new JTextField());
					textList.get(i).setBounds(10, 77+y, 86, 20);
					frame.getContentPane().add(textList.get(i));
					textList.get(i).setColumns(10);
					y+=44;
					
				}
				frame.repaint();
				
				

				
				
			}
		});
		btnNewButton.setBounds(112, 42, 102, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.setBounds(112, 76, 103, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(407, 45, 106, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Check Normal Query");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(397, 29, 135, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Check");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.nanoTime();
		        
				lblNewLabel_2.setText(String.valueOf(query(textField_1.getText())));
				long endTime = System.nanoTime();

		        long ms = (endTime - startTime) ;
		       
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setBounds(447, 115, 69, 14);
				
				JLabel lblNewLabel_3_1 = new JLabel("time = " + ms + " ms");
				lblNewLabel_3_1.setForeground(Color.WHITE);

				frame.getContentPane().add(lblNewLabel_3_1);
				lblNewLabel_3_1.setBounds(415, 159, 103, 14);
				frame.getContentPane().add(lblNewLabel_2);
				frame.repaint();
				
			}
		});
		btnNewButton_2.setBounds(407, 76, 106, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check Bloom Query");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(556, 29, 132, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(556, 45, 107, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton_2_1 = new JButton("Check Bloom");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.nanoTime();
				lblNewLabel_2_1.setText(String.valueOf(queryBloomFilter(textField_2.getText())));
				long endTime = System.nanoTime();

		        long ms = (endTime - startTime) ;
		        System.out.println("time = " + ms + " ms");
				lblNewLabel_2_1.setForeground(Color.WHITE);
				lblNewLabel_2_1.setBounds(600, 115, 69, 14);
				frame.getContentPane().add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_3 = new JLabel("time = " + ms + " ms");
				lblNewLabel_3.setForeground(Color.WHITE);
				lblNewLabel_3.setBounds(565, 159, 102, 14);
				frame.getContentPane().add(lblNewLabel_3);
				
				
				frame.repaint();
			}
		});
		btnNewButton_2_1.setBounds(556, 76, 106, 36);
		frame.getContentPane().add(btnNewButton_2_1);
		

		
		
		
		JLabel lblNewLabel_4 = new JLabel("---");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(531, 160, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	               
				for (int j = 0; j < (int)spinner.getValue(); j++) {
					
					stringArrayList.add(textList.get(j).toString());
					hash(textList.get(j).getText());
					
				}
				String string=" ";
				for (int i = 0; i < bitset.size(); i++) {
					
					if(bitset.get(i)==false) {
						string+="0";
					}
					else {
						string+="1";
					}
				}
				lblNewLabel.setText(string);
				
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBounds(10, 150, 900, 100);
				frame.getContentPane().add(lblNewLabel);
				
				frame.repaint();
				
			}
		});
		
	
		
		
		frame.setVisible(true);
	}
	
	public static int h1(String a){
		
		
		String aString=a;
		char  ch=' ';
		
		int ascii=ch;
		
		for (int i = 0; i < aString.length(); i++) {
			
			ascii+=aString.charAt(i);
		}
		int ress=ascii-ch;
		ress=ress % 97;
		while (ress<0) {
	    ress+=97;
	    
		}
		return ress;
	}
	public static int h2(String a) {
		
		
		 
		 int result=a.hashCode();
		 result = result % 97;
		while (result<0) {
			
			  
			  result+=97;
		}
		 
		 return result;
		 
		 
		
		
	}
	public static int h3(String a) {
		
		String aString=a;
		
		char  ch=' ';
		
		int ascii=ch;
		
		for (int i = 0; i < aString.length(); i++) {
			
			ascii+=aString.charAt(i);
		}
		int result=ascii-ch;
		result= result*7%97;
		while (result<0) {
		  result+=97;
		}
		
		
		return result;
	}
	
	
	
	public static int[] hash(String a) {
		
		
		stringArrayList.add(a);
		bitset.set(h1(a));
		bitset.set(h2(a));
		bitset.set(h3(a));
		return Array;
	}
	
	public static boolean query(String a) {
		
		for (int i = 0; i < stringArrayList.size(); i++) {
			if(a.equals(stringArrayList.get(i))) {
				
				return true;
			}
		}
		
		
		return false;
	}
	
	public static boolean queryBloomFilter(String a) {
		

		
		
		if(bitset.get(h1(a))&& bitset.get(h2(a)) && bitset.get(h3(a))) {
			
			return true;
		}
		
		return false;
	}
}
