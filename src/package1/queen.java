package package1;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class queen extends JFrame implements ActionListener{

	private JLabel introtext;
	private JButton openbtn, newbtn;
	private JPanel upper,lower;
	
	public queen(){
		
	setTitle("QuickQuizz");
	setLayout(null);
	setSize(300,250);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	introtext = new JLabel("Create a new quizz or open from file?");
	upper = new JPanel();
	lower = new JPanel();
	openbtn = new JButton("Open");
	newbtn = new JButton("New");
	//introtext.setBounds(100, 100, 120, 100);
	BoxLayout l = new BoxLayout(upper, BoxLayout.Y_AXIS);
	//upper.setLayout(l);
	//upper.setBorder(new EmptyBorder(new Insets(150, 200,150,200)));
	//openbtn.addActionListener(this);
	add(openbtn);
//	lower.add(openbtn);
//	lower.add(newbtn);
	//add(upper);
	//add(lower);
	setLocationRelativeTo(null);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == openbtn){
			JOptionPane.showMessageDialog(null, "Hello ");
			//System.exit(0);
			dispose();
			JFrame l = new king();
			l.setVisible(true);
		}
		if(e.getSource() == newbtn){
			dispose();
			JFrame a = new createquiz();
			a.setVisible(true);
		}
		
	}
}
