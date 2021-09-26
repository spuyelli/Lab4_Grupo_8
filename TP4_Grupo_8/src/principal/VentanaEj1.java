package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEj1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblFechaNac;
	private JLabel lblDatosIngresados;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;
	private JButton btnMostrar;

	public VentanaEj1() {
		setResizable(false);
		setDefaultCloseOperation(VentanaEj1.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Contactos");

		lblNombre = new JLabel();
		lblNombre.setBounds(50, 50, 140, 30);
		lblNombre.setText("Nombre:");

		lblApellido = new JLabel();
		lblApellido.setBounds(50, 100, 140, 30);
		lblApellido.setText("Apellido:");

		lblTelefono = new JLabel();
		lblTelefono.setBounds(50, 150, 140, 30);
		lblTelefono.setText("Telefono:");

		lblFechaNac = new JLabel();
		lblFechaNac.setBounds(50, 200, 140, 30);
		lblFechaNac.setText("Fecha de nacimiento:");

		lblDatosIngresados = new JLabel();
		lblDatosIngresados.setBounds(40, 300, 390, 30);
		lblDatosIngresados.setText("Los datos ingresados fueron: ");

		txtNombre = new JTextField();
		txtNombre.setBounds(230, 50, 200, 36);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(230, 100, 200, 36);
		txtApellido.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(230, 150, 200, 36);
		txtTelefono.setColumns(10);

		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(230, 200, 200, 36);
		txtFechaNac.setColumns(10);

		btnMostrar = new JButton();
		btnMostrar.setBounds(290, 250, 140, 30);
		btnMostrar.setText("Mostrar");
		btnMostrar.addActionListener(this);

		getContentPane().setLayout(null);

		getContentPane().add(lblNombre);
		getContentPane().add(lblApellido);
		getContentPane().add(lblTelefono);
		getContentPane().add(lblFechaNac);
		getContentPane().add(lblDatosIngresados);
		getContentPane().add(txtNombre);
		getContentPane().add(txtApellido);
		getContentPane().add(txtTelefono);
		getContentPane().add(txtFechaNac);
		getContentPane().add(btnMostrar);

	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	public boolean validator() {
		int cont = 0;

		if (txtNombre.getText().isEmpty()) {
			cont++;
			txtNombre.setBackground(Color.red);
		} else {
			txtNombre.setBackground(Color.white);
		}

		if (txtApellido.getText().isEmpty()) {
			cont++;
			txtApellido.setBackground(Color.red);
		} else {
			txtApellido.setBackground(Color.white);
		}
		if (txtTelefono.getText().isEmpty()) {
			cont++;
			txtTelefono.setBackground(Color.red);
		} else {
			txtTelefono.setBackground(Color.white);
		}
		if (txtFechaNac.getText().isEmpty()) {
			cont++;
			txtFechaNac.setBackground(Color.red);
		} else {
			txtFechaNac.setBackground(Color.white);
		}

		if (cont > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (validator()) {
			lblDatosIngresados.setText("Los datos ingresados fueron: " + " " + txtNombre.getText() + " "
					+ txtApellido.getText() + " " + txtTelefono.getText() + " " + txtFechaNac.getText());
			txtNombre.setText("");
			txtApellido.setText("");
			txtTelefono.setText("");
			txtFechaNac.setText("");
		}
	}

}
