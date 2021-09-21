package principal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanEj1 extends JFrame{

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
	
	public VentanEj1() {
		setDefaultCloseOperation(VentanEj1.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Ejercicio 1");
		getContentPane().setLayout(null);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre:");
		lblNombre.setBounds(50, 50, 140, 30);
		
		lblApellido = new JLabel();
		lblApellido.setText("Apellido:");
		lblApellido.setBounds(50, 100, 140, 30);
		
		lblTelefono = new JLabel();
		lblTelefono.setText("Telefono:");
		lblTelefono.setBounds(50, 150, 140, 30);
		
		lblFechaNac = new JLabel();
		lblFechaNac.setText("Fecha de nacimiento:");
		lblFechaNac.setBounds(50, 200, 140, 30);
		
		lblDatosIngresados = new JLabel();
		lblDatosIngresados.setText("Los datos ingresados fueron: ");
		lblDatosIngresados.setBounds(40, 300, 390, 30);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(230, 50, 200, 36);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(230, 100, 200, 36);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(230, 150, 200, 36);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(230, 200, 200, 36);
		
		btnMostrar = new JButton();
		btnMostrar.setText("Ejercicio 1");
		btnMostrar.setBounds(290, 250, 140, 30);
		//btnMostrar.addActionListener(new eventoBoton(0));
		
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
	
}
