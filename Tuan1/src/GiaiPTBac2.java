import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPTBac2 extends JFrame implements ActionListener{
	  private JTextField textFieldA,textFieldB,textFieldC,textFieldKQ ;

	  private JButton btnKQ,btnXoa,btnThoat;
	  
	public GiaiPTBac2() {
		init();
	}
	private void init() {
		setTitle("^_^");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(500,400);
		setResizable(false);
		
		
		JLabel Title = new JLabel("Giai phuong trinh bac 2", JLabel.CENTER);


        
        btnKQ = new JButton("Giải");
        btnXoa = new JButton("Xóa rỗng");
        btnThoat = new JButton("Thoát");
       
        btnKQ.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);
       
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        
        int x = 20, y = 40, width = 100, height =30;
        
        JLabel lblA,lblB,lblC,lblKQ;
        panelCenter.add(lblA= new JLabel("Nhập a:"));
        lblA.setBounds(x, y, width, height);
        
        panelCenter.add(lblB= new JLabel("Nhập b:"));
        y += 50;
        lblB.setBounds(x, y, width, height);
        
        panelCenter.add(lblC= new JLabel("Nhập c:"));
        y += 50;
        lblC.setBounds(x, y, width, height);
        
        panelCenter.add(lblKQ= new JLabel("Kết quả:"));
        y += 50;
        lblKQ.setBounds(x, y, width, height);
        
       
//       Nhập
        x+=100; y =40; width= 300;
        panelCenter.add(textFieldA = new JTextField());
        textFieldA.setBounds(x, y, width, height);
        
        panelCenter.add(textFieldB = new JTextField());
        y += 50;
        textFieldB.setBounds(x, y, width, height);
        
        panelCenter.add(textFieldC = new JTextField());
        y += 50;
        textFieldC.setBounds(x, y, width, height);
        
        panelCenter.add(textFieldKQ = new JTextField());
        y += 50;
        textFieldKQ.setBounds(x, y, width, height);
        textFieldKQ.setEditable(false);

		JPanel control = new JPanel(); 
		control.add(btnKQ);
		control.add(btnXoa);
		control.add(btnThoat);
		control.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
		this.add(Title, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
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
		String kq=null;
		float a,b,c;
		if(o == btnKQ) {
			if(!isInt(textFieldA)) {
				focus(textFieldA);
			}
			else if(!isInt(textFieldB)) {
				focus(textFieldB);
			}
			else if(!isInt(textFieldC)) {
				focus(textFieldC);
			}
			else {
				a = Float.parseFloat(textFieldA.getText());
				b = Float.parseFloat(textFieldB.getText());
				c = Float.parseFloat(textFieldC.getText());

				kq = tinhGiaiPTBac2(a,b,c);
				textFieldKQ.setText(kq);
			}
		}
		if(o == btnXoa) {
			textFieldKQ.setText("");
			textFieldA.setText("");
			textFieldB.setText("");
			textFieldC.setText("");
		}
		if(o== btnThoat) {
			System.exit(0);
		}
	}
	private static String tinhGiaiPTBac2(float a, float b, float c) {
        String ketqua = null;
         
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                ketqua = "Phương trình vô nghiệm!";
            } else {
                ketqua = "Phương trình có một nghiệm: " + "x = " + (-c / b);
            }
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            ketqua = "Phương trình có 2 nghiệm là: " + "x1 = " + x1 
                    + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            ketqua = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
        } else {
            ketqua = "Phương trình vô nghiệm!";
        }
         
        return ketqua;
    }
	public static void main(String[] args) {
		new GiaiPTBac2().setVisible(true);
	}
}
