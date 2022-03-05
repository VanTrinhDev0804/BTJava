package df;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThongtinNV extends JFrame {

	private JTextField txtManv,txtHo,txtTen,txtTuoi,txtTl, txtTk;
	private JRadioButton radNam, radNu;
	private DefaultTableModel model;
	private JTable table;
	private JPanel pnCenter, pnNorth, pnChucNang;
	private JButton btnThem, btnSua, btnXoa, btnXoaTrang, btnLuu, btnTk;
	
	/**
	 * 
	 */
	
	public ThongtinNV() {
		setTitle("Thông tin nhân viên");
		setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		createGUI();
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
//		tieu de
		
		pnNorth = new JPanel();
		JLabel lbTitle = new JLabel("Thông tin nhân viên");
		lbTitle.setForeground(Color.BLUE);
		Font ft = new Font("Arial", Font.BOLD, 25);
		lbTitle.setFont(ft);
		pnNorth.add(lbTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		
		

		
//		Center
		
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);
		pnCenter.add(Box.createVerticalStrut(10));
		
		
		JLabel lbManv, lbHo, lbTen,lbTuoi, lbGioiTinh, lbTienLuong;
		lbManv = new JLabel("Mã Nhân Viên: ");
		lbHo = new JLabel("Họ");
		lbTen = new JLabel("Tên");
		lbTuoi = new JLabel("Tuổi: ");
		lbGioiTinh = new JLabel("Giới tính:");
		lbTienLuong = new JLabel("Tiền lương: ");
		
		txtManv = new JTextField();
		b1.add(lbManv);
		b1.add(txtManv);
		
		txtHo = new JTextField();
		txtTen = new JTextField();
		b2.add(lbHo);
		b2.add(txtHo);
		b2.add(lbTen);
		b2.add(txtTen);
	

		txtTuoi = new JTextField();
		txtTl= new JTextField();
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		ButtonGroup group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		
		b3.add(lbTuoi);
		b3.add(txtTuoi);
		b3.add(lbGioiTinh);
		b3.add(radNam);
		b3.add(radNu);
		
		b4.add(lbTienLuong);
		b4.add(txtTl);
		
		lbHo.setPreferredSize(lbManv.getPreferredSize());
		lbTuoi.setPreferredSize(lbManv.getPreferredSize());
		lbGioiTinh.setPreferredSize(lbManv.getPreferredSize());
		lbTienLuong.setPreferredSize(lbManv.getPreferredSize());
		
		taoBang();
		
		pnBorder.add(pnCenter, BorderLayout.CENTER);
//		Chuc nang
		
		JSplitPane split;
		pnBorder.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT), BorderLayout.SOUTH);
		split.setResizeWeight(0.5);
		
		JPanel pnTk = new JPanel();
		JLabel lbTk = new JLabel("Nhập mã số");
		txtTk = new JTextField(10);
		btnTk = new JButton("Tìm");
		pnTk.add(lbTk);
		pnTk.add(txtTk);
		pnTk.add(btnTk);
		split.add(pnTk);
		
		
		JPanel pnCN= new JPanel();
		btnThem = new JButton("Thêm");
		btnXoa= new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnXoaTrang = new JButton("Xóa Trắng");
		btnLuu = new JButton("Lưu");
		pnCN.add(btnThem);
		pnCN.add(btnXoa);
		pnCN.add(btnSua);
		pnCN.add(btnXoaTrang);
		pnCN.add(btnLuu);
		split.add(pnCN);
		
		Border cnBorder= BorderFactory.createLineBorder(Color.blue);
		pnCN.setBorder(cnBorder);
		pnTk.setBorder(cnBorder);
		
	
		
		this.add(pnBorder);
		
		
		
		
		
		
	}
	
	private void taoBang() {
		
		// TODO Auto-generated method stub
		
		
		JPanel pnTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Tuổi");
		model.addColumn("Giới tính");
		model.addColumn("Tiền Lương");
		
		TableColumn gtcolumn = table.getColumnModel().getColumn(3);
		JComboBox comboBox= new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		gtcolumn.setCellEditor(new DefaultCellEditor(comboBox));
		
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(750,250));
		pnCenter.add(sp);
	}
	
	

	public static void main(String[] args) {
		new ThongtinNV().setVisible(true);
	}
}
