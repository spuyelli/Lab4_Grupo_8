package presentacion.vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPersonaAgregar extends JPanel{
	
	private static final long serialVersionUID = -7793048630423947047L;
	
	private JButton btnAceptar;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	
	public PanelPersonaAgregar() 
	{
		dibujarControles();
	}
	
	public void dibujarControles() {
		setMaximumSize(new Dimension(450, 230));
		setLayout(null);
		setBounds(0, 0, 450, 230);
		
		Font fuenteComun = new Font("Segoe UI", Font.PLAIN, 18);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 20, 66, 25);
		lblNombre.setFont(fuenteComun);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setName("txtNombre");
		txtNombre.setBounds(283, 20, 131, 31);
		txtNombre.setFont(fuenteComun);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(30, 60, 66, 25);
		//lblApellido.setVerticalAlignment(SwingConstants.BOTTOM);
		lblApellido.setFont(fuenteComun);
		add(lblApellido);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 150, 140, 27);
		
		txtApellido = new JTextField();
		txtApellido.setName("txtApellido");
		txtApellido.setBounds(283, 60, 131, 31);
		txtApellido.setFont(fuenteComun);
		txtApellido.setColumns(10);
		add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(30, 100, 31, 25);
		lblDni.setFont(fuenteComun);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setName("txtDNI");
		txtDni.setBounds(283, 100, 131, 31);
		txtDni.setFont(fuenteComun);
		txtDni.setColumns(10);
		add(txtDni);
		
		btnAceptar.setFont(fuenteComun);
		add(btnAceptar);
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
}
