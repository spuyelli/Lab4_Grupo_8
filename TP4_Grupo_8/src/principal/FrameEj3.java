package principal;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class FrameEj3 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public FrameEj3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Seleccion multiple");
		setBounds(100, 100, 507, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(31, 34, 428, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setActionCommand("Windows");
		buttonGroup.add(rdbtnWindows);
		rdbtnWindows.setBounds(183, 31, 87, 23);
		panel.add(rdbtnWindows);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setActionCommand("Mac");
		buttonGroup.add(rdbtnMac);
		rdbtnMac.setBounds(272, 31, 61, 23);
		panel.add(rdbtnMac);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setActionCommand("Linux");
		buttonGroup.add(rdbtnLinux);
		rdbtnLinux.setBounds(344, 31, 66, 23);
		panel.add(rdbtnLinux);
		
		JLabel lblNewLabel = new JLabel("Elija un sistema operativo");
		lblNewLabel.setBounds(22, 35, 155, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 154, 428, 119);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Elija un sistema operativo:");
		lblNewLabel_1.setBounds(24, 55, 174, 14);
		panel_1.add(lblNewLabel_1);
		
		JCheckBox chckbxProgramacion = new JCheckBox("Programacion");
		chckbxProgramacion.setBounds(270, 26, 135, 23);
		panel_1.add(chckbxProgramacion);
		
		JCheckBox chckbxAdministracion = new JCheckBox("Administracion");
		chckbxAdministracion.setBounds(270, 55, 135, 23);
		panel_1.add(chckbxAdministracion);
		
		JCheckBox chckbxDiseoGrafico = new JCheckBox("Dise\u00F1o Grafico");
		chckbxDiseoGrafico.setBounds(270, 81, 135, 23);
		panel_1.add(chckbxDiseoGrafico);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadDeHoras.setBounds(60, 302, 229, 14);
		contentPane.add(lblCantidadDeHoras);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textField.setEditable(true);
	            } else {
	            	textField.setEditable(false);
	            }
	         }
	      });
		textField.setBounds(309, 299, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String checkBoxes = " - ";
				String actionCommand = "";
				ButtonModel buttonModel = buttonGroup.getSelection();
				
				if (chckbxProgramacion.isSelected()) {
					checkBoxes += (chckbxProgramacion.getText() + " - ");
				}
				if (chckbxDiseoGrafico.isSelected()) {
					checkBoxes += chckbxDiseoGrafico.getText() + " - ";
				}
				if (chckbxAdministracion.isSelected()) {
					checkBoxes += chckbxAdministracion.getText() + " - ";
				}
				
				if (buttonModel != null) {
					   actionCommand = buttonModel.getActionCommand();
					   JOptionPane.showMessageDialog(null, actionCommand + checkBoxes + textField.getText() + "hs");
					} else {
						JOptionPane.showMessageDialog(null, "No se selecciono sistema operativo");
					}
			}
		});
		btnAceptar.setBounds(345, 340, 89, 23);
		contentPane.add(btnAceptar);
	}
}
