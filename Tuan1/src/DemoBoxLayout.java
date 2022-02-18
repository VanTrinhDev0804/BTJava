import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoBoxLayout extends JFrame {
	public DemoBoxLayout() {
		setTitle("BoxLayput");
		setSize(450,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Box bv, bh1, bh2,bv1;
		add(bv = Box.createVerticalBox());
		bv.add(bh1 = Box.createHorizontalBox());
		bv.add(bh2 = Box.createHorizontalBox());
		bv.add(bv1 = Box.createVerticalBox());
		for(int i = 0; i <3 ; i++) {
			bh1.add(Box.createHorizontalGlue());
			bh1.add(new JButton("Button " + i));
		}
		bh1.add(Box.createHorizontalGlue());
		for (int i = 0; i<5 ; i++) {
			bh2.add(new JButton("Button" + i));
		}
		for (int i = 0 ; i <5 ; i++){
			bv1.add(Box.createHorizontalStrut(5));
			bv1.add(new JButton("Button"+i ));
			
		}
	}
	
	public static void main(String[] args) {
		new DemoBoxLayout().setVisible(true);
	}
}
