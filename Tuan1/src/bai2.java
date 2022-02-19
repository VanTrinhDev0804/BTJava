import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class bai2 extends JFrame {

	
	private JTextField txtN;
	private JButton btnGenerate;
	private JTextArea taPrime;
	
	
	public bai2() {
		setTitle("^_^");
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		createGUI();
	}


	private void createGUI() {
		// TODO Auto-generated method stub
		setLayout(null);
		add(txtN = new JTextField());
		txtN.setBounds(50, 30, 200, 30);
		txtN.setToolTipText("Nhập số nguyên");
		
		add(btnGenerate = new JButton("Generate"));
		btnGenerate.setBounds(250, 30,100, 30);
		
		JScrollPane  scroll;
		add(scroll = new JScrollPane(taPrime = new JTextArea()));
		scroll.setBounds(50, 70, 300, 170);
		
		taPrime.setToolTipText("Danh sánh các số nguyên tố");
		taPrime.setEditable(false);
		
		
		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taPrime.setText("");
				try {
						int n = Integer.parseInt(txtN.getText());
						if(n> 0) {
							for (int i =2 ;i <Integer.MAX_VALUE; i++) {
								if(isPrime(i)) {
									n--;
									taPrime.append(i+"\n");
									
								}
								if(n==0)
									break;
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Nhập số nguyên dương");
						}
				}catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Lỗi nhập liệu ");
				}
				focus();
			}

			private void focus() {
				// TODO Auto-generated method stub
				txtN.selectAll();
				txtN.requestFocus();
				return;
			}

			private boolean isPrime(int n) {
				// TODO Auto-generated method stub
				for (int i =2; i<n ; i++) {
					if(n%i ==0)
						return false;
				}
				return true;
			}
			
		});
		
	}
	public static void main(String[] args) {
		new bai2().setVisible(true);
	}
}
