package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEj1 extends JFrame{

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
		setTitle("Ejercicio 1");
		
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
		btnMostrar.addActionListener(new ActionListener() {
			public boolean validator() {
				int cont = 0;
				
				if(txtNombre.getText().isEmpty()) {
					cont+=1;
					txtNombre.setBackground(Color.red);
				}
				
				if(txtApellido.getText().isEmpty()) {
					cont+=1;
					txtApellido.setBackground(Color.red);
				}
				if(txtTelefono.getText().isEmpty()) {
					cont+=1;
					txtTelefono.setBackground(Color.red);
				}
				if(txtFechaNac.getText().isEmpty()) {
					cont+=1;
					txtFechaNac.setBackground(Color.red);	
				}
				
				if (cont>0) {
					return false;
				}
				else {
					txtNombre.setBackground(Color.white);
					txtApellido.setBackground(Color.white);
					txtTelefono.setBackground(Color.white);
					txtFechaNac.setBackground(Color.white);
				}
				return true;
			}
			
			public void actionPerformed(ActionEvent e) {
				if(validator()) {
					lblDatosIngresados.setText("Los datos ingresados fueron: " + " " + txtNombre.getText() + " " +  txtApellido.getText() + " " + txtTelefono.getText() + " " + txtFechaNac.getText());
					txtNombre.setText("");
					txtApellido.setText("");
					txtTelefono.setText("");
					txtFechaNac.setText("");
				}
			}
		});
		
		
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
	
	
}


