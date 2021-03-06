import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class bai3 extends JFrame implements ActionListener {

	private JTextField txtA, txtB, txtKQ;
	private JButton btnGiai, btnXoa, btnThoat;
	private JRadioButton radCong,radTru, radNhan, radChia;
	public bai3() {
		setTitle("Cộng-Trừ-Nhân-Chia");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		createGUI();
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		
		JPanel panelTop = new JPanel();
		
		JLabel title = new JLabel("Cộng Trừ Nhân Chia");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("arial",Font.BOLD,25));
		panelTop.add(title);
		this.add(panelTop, BorderLayout.NORTH);
		
		
		JPanel pannelRight = new JPanel();
		pannelRight.setLayout(new GridLayout(6,1,10,10));
		
		pannelRight.setSize(30, 200);
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
	
		
		pannelRight.add(btnGiai);
		pannelRight.add(btnXoa);
		pannelRight.add(btnThoat);
		pannelRight.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		this.add(pannelRight, BorderLayout.WEST);
		
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		
		
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		
		int x = 20, y = 40 , width = 80 , height = 20;
		
		JLabel lblA, lblB, lblKQ;
	
		
		
		pnCenter.add( lblA= new JLabel("Nhập a:"));
		lblA.setBounds(x, y, width, height);
		
		pnCenter.add( lblB= new JLabel("Nhập b:"));
		y+=40;
		lblB.setBounds(x, y, width, height);

		
		
		radCong = new JRadioButton("Cộng");
		y+=40;
		radCong.setBounds(100, y, 80, 20);
		radCong.setSelected(true);
		
		radTru = new JRadioButton("Trừ");
		radTru.setBounds(200, y, 80, 20);
		radNhan = new JRadioButton("Nhân");
		y+=40;
		radNhan.setBounds(100, y, 80, 20);
		radChia = new JRadioButton("Chia");
		radChia.setBounds(200, y, 80, 20);
		
		ButtonGroup groupButton = new ButtonGroup();
		groupButton.add(radCong);
		groupButton.add(radTru);
		groupButton.add(radNhan);
		groupButton.add(radChia);
		
		pnCenter.add(radCong);
		pnCenter.add(radTru);
		pnCenter.add(radNhan);
		pnCenter.add(radChia);
		
	
		pnCenter.add( lblKQ= new JLabel("Kết Quả:"));
		y+=40;
		lblKQ.setBounds(x, y, width, height);
		
//		nhập
		x+= 80; y = 40;width = 250;
		pnCenter.add(txtA = new JTextField());
		txtA.setBounds(x, y, width, height);
		
		pnCenter.add(txtB = new JTextField());
		y +=40;
		txtB.setBounds(x, y, width, height);
		
		pnCenter.add(txtKQ = new JTextField());
		y +=120;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);
		this.add(pnCenter, BorderLayout.CENTER);
		
		
	}
	

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		}
		catch(NumberFormatException ex) {
			result =  false;
		}
		
		return result;
	}
	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
		text.selectAll();
		text.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();
		if(o.equals(btnGiai)) {
			if(!isInt(txtA)) {
				focus(txtA);
			}
			else if(!isInt(txtB)) {
				focus(txtB);
			}else {
				int result;
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				
				if(radCong.isSelected()) {
					result= a +b;
					txtKQ.setText(String.valueOf(result));
				}else if(radTru.isSelected()) {
					result= a -b;
					txtKQ.setText(String.valueOf(result));
				}
				else if(radNhan.isSelected()) {
					result= a *b;
					txtKQ.setText(String.valueOf(result));
				}
				else if(radChia.isSelected()&& b!=0) {
					result= a /b;
					txtKQ.setText(String.valueOf(result));
				}
		
			}
			
		}
		if(o.equals(btnXoa))
		{
			txtA.setText("");
			txtA.requestFocus();
			txtB.setText("");
			txtKQ.setText("");
			radCong.setSelected(true);
			
		}
		if(o.equals(btnThoat)) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new bai3().setVisible(true);
	}
}
