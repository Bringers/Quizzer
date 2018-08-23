package package1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class Createwindow extends JFrame implements ActionListener{
	private JPanel p1,p2,errorPanel;
	private JLabel errorText;
	private JButton b1,b2,backbtn;
	private JScrollPane s1,s2,s3;
	private int num = 1;
	private JTextArea questtext, savetext;
	private Object[] quests;
	private Questionfield quest;
	
	public Createwindow(){
		b1 = new JButton("Add question");
		b2 = new JButton("Save");
		backbtn = new JButton("<-Back");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		backbtn.addActionListener(this);
		
		errorPanel = new JPanel(); // error stuff
		errorText = new JLabel();
		
		p2 = new JPanel();
		p1 = new JPanel();
		questtext = new JTextArea("write your question here",2,25);
		savetext = new JTextArea("write save name here",2,15);
		p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));
		s1 = new JScrollPane(p2);
		s2 = new JScrollPane(questtext);
		s3 = new JScrollPane(savetext);
		quests = new Questionfield[0];
		
		s3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		s2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		s1.setBounds(10,60,560,400);
		
		p1.add(b2, BorderLayout.NORTH);
		p1.add(s3, BorderLayout.NORTH);
		p1.add(b1,BorderLayout.NORTH);
		p1.add(s2,BorderLayout.NORTH);
		p1.add(backbtn, BorderLayout.NORTH);
		add(s1, BorderLayout.CENTER);
		add(p1,BorderLayout.NORTH);
		//add(errorPanel, BorderLayout.SOUTH); for error prompt?
		setTitle("Quizzard - Create");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public Object[] addto(Object[] arr, Object e){
		Object[] temp = new Object[arr.length+1];
		for(int k = 0; k < arr.length; k++){
			temp[k] = arr[k];
		}
		temp[arr.length] = e;
		return temp;
	}
	
	public void addQuestionfield(){
		JPanel filler = new JPanel();
		filler.setPreferredSize(new Dimension(0,20));
		filler.setBackground(Color.BLACK);
		quest = new Questionfield(num, questtext.getText());
		quest.setPreferredSize(new Dimension(0,250));
		quest.setBackground(Color.WHITE);
		quests = addto(quests, quest);
		p2.add(quest);
		p2.add(filler);
		questtext.setText("");
		num++;
	}
	
	public void saving(){
		String[] all = new String[num];
		for(int k = 0; k<num-1; k++){
			((Questionfield)quests[k]).AtoB();
			all[k] = ((Questionfield)quests[k]).getLabel() + "-qws-" + ((Questionfield)quests[k]).getRightWrong()+ "-qws-" + ((Questionfield)quests[k]).getBtns();
			System.out.print(all[k]);
		}
		//writes to file
		try(PrintWriter out = new PrintWriter(savetext.getText()+ ".txt")){
			out.println((num-1));
			for(int k = 0; k<all.length; k++){
				out.println(all[k] + "\n");
			}
			out.close();
		}
		catch(IOException e){
			System.out.print("file didnt open");
		}
	}
	
	public void update(){
		repaint();
		validate();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			if(questtext.getText().equals("")){}
			else{
				System.out.print("1");
				addQuestionfield();
				update();
			}
		}
		if(e.getSource() == b2){
			if(savetext.getText().equals("")){}
			else{
				saving();
			}
		}
		if(e.getSource() == backbtn){
			dispose();
			JFrame show = new window("Quizzard", "Create","Play","Welcome to quizzard!");
			show.setVisible(true);
		}
	}
}
