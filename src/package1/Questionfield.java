package package1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Questionfield extends JPanel implements ActionListener{
	private JPanel p1,p2,p3,p4,p5;
	private int i, c;
	private JButton b1,b2;
	private JButton[] buttons;
	private JCheckBox[] checks;
	private JPanel[] planes;
	private JScrollPane s1;
	private JLabel l,l2;
	private JTextField ans;
	private int[] rightwrong; // 1 for right, 0 for wrong
	
	public Questionfield(int num, String quest){
		/*
		 * Fält för svar, knappar och bock för det korrekta svaret:
		 * knappar, bock, increasing field
		 * textfält för att redigera knapp
		 * 
		 * Fält för frågan:
		 * bild fält? text 
		 * 
		 */
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		planes = new JPanel[6];
		buttons = new JButton[6];
		checks = new JCheckBox[6];
		rightwrong = new int[6];
		l = new JLabel("Question " + num + ". ");
		l2 = new JLabel(quest);
		ans = new JTextField(8);
		s1 = new JScrollPane(p1);
		b2 = new JButton("Add answer");
		
		s1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		b2.addActionListener(this);
		p3.setLayout(new GridLayout(0,3));
		p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
		p1.setPreferredSize(new Dimension(0,100));
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		
		p1.add(l, BorderLayout.WEST);
		p1.add(l2, BorderLayout.EAST);
		p2.add(b2);
		p2.add(ans);
		p4.add(p1, BorderLayout.NORTH);
		p4.add(p2, BorderLayout.CENTER);
		p4.add(p3, BorderLayout.SOUTH);
		add(p4,BorderLayout.NORTH);
		add(s1);
	}
	
	public void addPlane(){
		planes[i] = new JPanel();
		planes[i].setBackground(Color.WHITE);
	}
	
	public void addButton(){
		c++;
		buttons[i] = new JButton(ans.getText());
		planes[i].add(buttons[i]);
	}
	
	public void addCheckbox(){
		checks[i] = new JCheckBox();
		checks[i].setBackground(Color.WHITE);
		planes[i].add(checks[i]);
	}
	
	public void update(){
		repaint();
		validate();
	}
	
	public String getLabel(){
		return l2.getText();
	}
	
	public String getRightWrong(){
		String a =  "";
		for(int k = 0; k<c; k++){
			a = a + rightwrong[k] + "-fan-";
		}
		return a;
	}
	
	public String getBtns(){
		String a = "";
		for(int k = 0; k<c; k++){
			a = a + buttons[k].getText() + "-fan-";
		}
		return a;
	}
	
	public void AtoB(){
		for(int k = 0; k<c; k++){
			if(checks[k].isSelected()){
				rightwrong[k] = 1;
			}
			else{
				rightwrong[k] = 0;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(ans.getText().equals("")){}
		else{
			if(i <= 5){
				addPlane();
				addCheckbox();
				addButton();
				p3.add(planes[i]);
				i++;
				}
			}
		ans.setText("");
		update();
	}
}
