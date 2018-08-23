package package1;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class Questioncard extends JPanel implements ActionListener{
	
	private JLabel l,l2;
	private JButton[] buttons;
	private JPanel p1,p2;
	private String all, question;
	private String[] rightwrong, btntexts;
 	
	public Questioncard(String wholeline){
		/*
		 * fuction to seperate
		 */
		all = wholeline;
		seperateline();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		p1 = new JPanel();
		p2 = new JPanel();
		l2 = new JLabel(question);
		
		buttons = new JButton[btntexts.length];
		p1.add(l2);
		addbtns();
		for(int k = 0;k<buttons.length; k++){
			buttons[k].addActionListener(this);
		}
		add(p1);
		add(p2);
	}
	
	public void seperateline(){
		System.out.print(all);
		String[] parts = all.split("-qws-");
		question = parts[0];
		
		String temp1 = parts[1];
		String temp2 = parts[2];
		
		rightwrong = temp1.split("-fan-");
		btntexts = temp2.split("-fan-");
		
		System.out.print(question + "\n");
		for(int k = 0; k<rightwrong.length; k++){
			System.out.print(rightwrong[k]);
		}
		System.out.print("\n");
		for(int k = 0; k<btntexts.length; k++){
			System.out.print(btntexts[k]);
		}
	}
	
	public void randomanswer(){
		
	}
	
	public void addbtns(){
		System.out.print("\n" + btntexts.length);
		for(int k = 0; k<btntexts.length; k++){
			
			String temp = btntexts[k];
			buttons[k] = new JButton(temp);
			p2.add(buttons[k]);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		for(int k = 0;k<buttons.length; k++){
			if(e.getSource() == buttons[k]){
				if(rightwrong[k].contains("1")){
					System.out.print("\n CORRECT ");
				}
				else {
					System.out.print("\n WRONG ");
				}
			}
		}
	}

}
