import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing extends JFrame{

	private void createGUI() {
		JLabel label  = new JLabel("Hello World");
		this.getContentPane().add(label);
		
	}
	public void ShowGUI() {
		createGUI();
		this.setTitle("HelloWorldSwing");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main (String[] args ) {
		HelloWorldSwing f = new HelloWorldSwing();
		f.ShowGUI();
	}
	
}
