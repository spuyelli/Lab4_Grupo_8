package principal;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class VentanaEj3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtComp;
	// Agrego un grupo de botones
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLayeredPane layeredPane;
	private JPanel panelSo;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnMac;
	private JRadioButton rdbtnLinux;
	private JLabel lblSo;
	private JPanel panelComp;
	private JLabel lblComp;
	private JButton btnAceptar;
	private JPanel panelEsp;
	private JLabel lblEsp;
	private JCheckBox chckbxProg;
	private JCheckBox chckbxAdm;
	private JCheckBox chckbxDg;

	public VentanaEj3() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Selección Múltiple");

		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(null);

		panelSo = new JPanel();
		panelSo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSo.setBounds(20, 47, 440, 80);
		layeredPane.add(panelSo);
		panelSo.setLayout(null);

		rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setActionCommand("Windows");
		buttonGroup.add(rdbtnWindows);
		rdbtnWindows.setBounds(183, 31, 87, 23);
		panelSo.add(rdbtnWindows);

		rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setActionCommand("Mac");
		buttonGroup.add(rdbtnMac);
		rdbtnMac.setBounds(272, 31, 61, 23);
		panelSo.add(rdbtnMac);

		rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setActionCommand("Linux");
		buttonGroup.add(rdbtnLinux);
		rdbtnLinux.setBounds(344, 31, 66, 23);
		panelSo.add(rdbtnLinux);

		lblSo = new JLabel("Elije un sistema operativo");
		lblSo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSo.setBounds(10, 35, 170, 14);
		panelSo.add(lblSo);

		panelComp = new JPanel();
		panelComp.setBounds(20, 325, 440, 125);
		layeredPane.add(panelComp);
		panelComp.setLayout(null);

		lblComp = new JLabel("Cantidad de Hs en el Computador:");
		lblComp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComp.setBounds(10, 23, 230, 14);
		panelComp.add(lblComp);

		txtComp = new JTextField();
		txtComp.setBounds(266, 21, 100, 20);
		panelComp.add(txtComp);
		txtComp.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(341, 91, 89, 23);
		panelComp.add(btnAceptar);

		panelEsp = new JPanel();
		panelEsp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEsp.setBounds(20, 157, 440, 140);
		layeredPane.add(panelEsp);
		panelEsp.setLayout(null);

		lblEsp = new JLabel("Elije una especialidad:");
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEsp.setBounds(10, 64, 174, 14);
		panelEsp.add(lblEsp);

		chckbxProg = new JCheckBox("Programaci\u00F3n");
		chckbxProg.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxProg.setBounds(220, 18, 117, 23);
		panelEsp.add(chckbxProg);

		chckbxAdm = new JCheckBox("Administraci\u00F3n");
		chckbxAdm.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxAdm.setBounds(220, 60, 117, 23);
		panelEsp.add(chckbxAdm);

		chckbxDg = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDg.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxDg.setBounds(220, 102, 117, 23);
		panelEsp.add(chckbxDg);

		// Comportamiento del boton aceptar

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String checkBoxes = " - ";
				String actionCommand = "";
				ButtonModel buttonModel = buttonGroup.getSelection();

				if (chckbxProg.isSelected()) {
					checkBoxes += (chckbxProg.getText() + " - ");
				}
				if (chckbxDg.isSelected()) {
					checkBoxes += chckbxDg.getText() + " - ";
				}
				if (chckbxAdm.isSelected()) {
					checkBoxes += chckbxAdm.getText() + " - ";
				}

				if (buttonModel != null) {
					actionCommand = buttonModel.getActionCommand();
					if (txtComp.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, actionCommand + checkBoxes + "0hs");
					} else {
						JOptionPane.showMessageDialog(null, actionCommand + checkBoxes + txtComp.getText() + "hs");
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se seleccionó sistema operativo");
				}
			}
		});

	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}
}
