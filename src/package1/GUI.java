package package1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GUI implements ActionListener{

	/**
	 * @param args
	 */
	
	static JFrame frame;
	static JPanel mainPanel, question, answer;
	static JButton testbtn, qqbtn;
	
	
	public static void startframe(){
		frame = new JFrame("Quizzard");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	  
	    JLabel emptyLabel = new JLabel("<html>Welcome to Quizzard!<br/> What mode would you like to play?<html>");
	    testbtn = new JButton("Test");
	    qqbtn = new JButton("QuickQuiz");
	    

	    
	    JPanel paintPanel = new JPanel();
	    JPanel textPanel = new JPanel();
	    
	   // paintPanel.setBackground(Color.black);
	   // textPanel.setBackground(Color.blue);
	    
	    paintPanel.add(emptyLabel, BorderLayout.CENTER);
	    textPanel.add(qqbtn, BorderLayout.WEST);
	    textPanel.add(testbtn, BorderLayout.EAST);
	
	    mainPanel.add(paintPanel, BorderLayout.NORTH);
	    mainPanel.add(textPanel, BorderLayout.SOUTH);
	    frame.getContentPane().add(mainPanel);
	    frame.pack();
	    frame.setSize(600,500);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	
	public static void setupQQ(){
		JPanel question = new JPanel();
		JPanel answers = new JPanel();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == qqbtn){
			System.out.print("clicked");
		}
	}
	
}
