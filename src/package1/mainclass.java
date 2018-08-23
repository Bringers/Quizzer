package package1;

import javax.swing.JFrame;

public class mainclass {

	public static JFrame shown;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shown = new window("Quizzard", "Create","Play","Welcome to quizzard!");
		shown.setVisible(true);
	}

}
