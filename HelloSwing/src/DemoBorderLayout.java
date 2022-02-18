import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



public class DemoBorderLayout extends JFrame{
	private JButton
	 	bn = new JButton("North"),
		bs = new JButton("South"),
		be = new JButton("East"),
		bw = new JButton("West"),
		bc = new JButton("Center");
	
	public DemoBorderLayout() {
		setTitle("Border Layout");
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		add(BorderLayout.NORTH, bn);
		add(BorderLayout.SOUTH, bs);
		add(BorderLayout.EAST, be);
		add(BorderLayout.WEST, bw);
		add(BorderLayout.CENTER, bc);

	}
	public static void main(String[] args) {
		new DemoBorderLayout().setVisible(true);
	}
}
