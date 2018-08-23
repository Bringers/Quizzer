package package1;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Playwindow extends JFrame implements ActionListener{

	private int num;
	private JPanel[] questions;
	private JTextArea loadtext;
	private JPanel mainshow, p1;
	private JButton b1,b2,backbtn;
	private JScrollPane s3;
	private String[] thelines;
	
	public Playwindow(){
		/*
		 * Load function, randomize function (for cards and answers)
		 * load button, load text
		 * field for question card
		 * array of cards
		 * 
		 */
		//probably place this in load
		b2 = new JButton("Load");
		p1 = new JPanel();
		mainshow = new JPanel();
		questions = new JPanel[num];
		backbtn = new JButton("<-Back");
		
		backbtn.addActionListener(this);
		b2.addActionListener(this);
		
		loadtext = new JTextArea("write load name here",2,15);
		s3 = new JScrollPane(loadtext);
		
		s3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		p1.add(b2, BorderLayout.NORTH);
		p1.add(s3, BorderLayout.NORTH);
		p1.add(backbtn, BorderLayout.NORTH);
		
		add(p1, BorderLayout.NORTH);
		add(mainshow, BorderLayout.CENTER);
		setTitle("Quizzard - Play");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void load(){
		System.out.print(loadtext.getText()+".txt");
		try {BufferedReader br = new BufferedReader(new FileReader(loadtext.getText()+".txt"));
			try{num = Integer.parseInt(br.readLine());
			System.out.print("this is number: "+num);
			}
			catch(IOException e){
				System.out.print("\n "+"ioexception first");
			}
		thelines = new String[num];
		for(int k = 0; k<num; k++){
			try{thelines[k] = (String)(br.readLine());
			System.out.print(thelines[k] + "\n");
			}
			catch(IOException e){
				System.out.print("\n"+"ioexception second");
			}
		}
		
		}
		catch(FileNotFoundException ex){
			System.out.print("File not found error");
		}
		
	}
	
	
	public void randomcard(){
		
	}
	
	
	public void update(){
		repaint();
		validate();
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b2){
			load();
			//System.out.print(temp+ "\n");
			JPanel qcard = new Questioncard(thelines[0]);
			mainshow.add(qcard);
			update();
		}
		if(e.getSource() == backbtn){
			dispose();
			JFrame show = new window("Quizzard", "Create","Play","Welcome to quizzard!");
			show.setVisible(true);
		}
	}
	
}
