package package1;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class createquiz extends JFrame implements ActionListener {
	
	private JLabel introtext;
	private JButton addbtn, savebtn;
	private JTextField question, answer;
	
	public createquiz(){
		setTitle("Quizz Creator");
		setLayout(null);
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		introtext = new JLabel("Create a new quizz or open from file?");
		addbtn = new JButton("Add Answer");
		savebtn = new JButton("Save");
		introtext.setBounds(100, 100, 120, 100);
		addbtn.setBounds(100, 190, 80, 30);
		savebtn.setBounds(100, 190, 80, 30);
		addbtn.addActionListener(this);
		add(introtext);
		add(addbtn);
		add(savebtn);
		setLocationRelativeTo(null);	
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addbtn){
		}
		if(e.getSource() == savebtn){
		}
	}
}
