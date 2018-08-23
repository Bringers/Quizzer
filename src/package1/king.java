package package1;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class king extends JFrame implements ActionListener{
	private JLabel welcomemsg;
	private JTextField name;
	private JButton quiz;
	private JButton test;
	private String storeName = "";
	
public king(){
	/*
	 *skapa main fönster
	 *
	 */
	setTitle("Quizzard");
	setLayout(null);
	setSize(300,250);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	welcomemsg = new JLabel("<html>Welcome to Quizzard! <br/> What mode would you like to play? <html>");
	quiz = new JButton("Quizz");
	test = new JButton("Test");
	//name = new JTextField();
	welcomemsg.setBounds(100, 100, 120, 100);
	//name.setBounds(80, 60, 130, 30);
	quiz.setBounds(100, 190, 80, 30);
	test.setBounds(100, 190, 80, 30);
	quiz.addActionListener(this);
	add(quiz);
	add(test);
	add(welcomemsg);
	setLocationRelativeTo(null);
}

public void actionPerformed(ActionEvent e){
	if(e.getSource() == quiz){
	//	storeName = name.getText();
		//JOptionPane.showMessageDialog(null, "Hello " + storeName);
		//System.exit(0);
		dispose();
		JFrame l = new queen();
		l.setVisible(true);
	}
	if(e.getSource() == test){
		
	}
	
}

}

