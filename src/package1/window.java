package package1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class window extends JFrame implements ActionListener {
	private JPanel p1,p2;
	private JButton b1,b2;
	private JLabel l;
	public window(String title, String b1text, String b2text, String ltext){
		setTitle(title);
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1 = new JButton(b1text);
		b2 = new JButton(b2text);
		l = new JLabel(ltext);
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p1.add(l);
		p2.add(b1);
		p2.add(b2);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
	}
	
//	public void update(String a, String b, String c){
//		b1.setText(a);
//		b2.setText(b);
//		l.setText(c);
//		validate();
//	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			//if(b1.getText().equals("Create"))
				System.out.print("1");
				dispose();
				JFrame createw = new Createwindow();
				createw.setVisible(true);
				//JFrame next = new window("Quizzard - Create","New","Open","Create new or open from file?");
				//next.setVisible(true);
		}
		if(e.getSource() == b2){
			System.out.print("2");
			dispose();
			JFrame playw = new Playwindow();
			playw.setVisible(true);
		}
	}
}
