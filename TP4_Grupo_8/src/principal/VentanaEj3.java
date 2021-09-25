package principal;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class VentanaEj3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtComp;
	private JRadioButton rdbtnMac;

	public VentanaEj3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Selección Múltiple");

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);

		JPanel panelSo = new JPanel();
		panelSo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSo.setBounds(20, 47, 440, 80);
		layeredPane.add(panelSo);
		panelSo.setLayout(null);

		rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMac.setBounds(270, 31, 82, 23);
		panelSo.add(rdbtnMac);

		JRadioButton rdbtnLin = new JRadioButton("Linux");
		rdbtnLin.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLin.setBounds(354, 31, 70, 23);
		panelSo.add(rdbtnLin);

		JRadioButton rdbtnWin = new JRadioButton("Windows");
		rdbtnWin.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnWin.setBounds(186, 31, 82, 23);
		panelSo.add(rdbtnWin);

		JLabel lblSo = new JLabel("Elije un sistema operativo");
		lblSo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSo.setBounds(10, 35, 170, 14);
		panelSo.add(lblSo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 440, 64, -27);
		layeredPane.add(panel_1);

		JPanel panelComp = new JPanel();
		panelComp.setBounds(20, 325, 440, 125);
		layeredPane.add(panelComp);
		panelComp.setLayout(null);

		JLabel lblComp = new JLabel("Cantidad de Hs en el Computador:");
		lblComp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComp.setBounds(10, 23, 230, 14);
		panelComp.add(lblComp);

		txtComp = new JTextField();
		txtComp.setBounds(266, 21, 100, 20);
		panelComp.add(txtComp);
		txtComp.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(341, 91, 89, 23);
		panelComp.add(btnAceptar);

		JPanel panelEsp = new JPanel();
		panelEsp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEsp.setBounds(20, 157, 440, 140);
		layeredPane.add(panelEsp);
		panelEsp.setLayout(null);

		JLabel lblEsp = new JLabel("Elije una especialidad:");
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEsp.setBounds(10, 64, 174, 14);
		panelEsp.add(lblEsp);

		JCheckBox chckbxProg = new JCheckBox("Programaci\u00F3n");
		chckbxProg.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxProg.setBounds(220, 18, 117, 23);
		panelEsp.add(chckbxProg);

		JCheckBox chckbxAdm = new JCheckBox("Administraci\u00F3n");
		chckbxAdm.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxAdm.setBounds(220, 60, 117, 23);
		panelEsp.add(chckbxAdm);

		JCheckBox chckbxDg = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDg.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDg.setBounds(220, 102, 117, 23);
		panelEsp.add(chckbxDg);
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}
}
