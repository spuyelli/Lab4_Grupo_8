package Principal;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregarPelicula extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;	
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblGenero;
	private JComboBox<String> cbGenero;
	private JLabel lblIdNumber;
	private JButton btnAceptar;

	
	public PanelAgregarPelicula() {
		setLayout(null);
		setBounds(10, 10, 450, 300);
		
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(50, 34, 100, 20);
		add(lblId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(50, 65, 100, 20);
		add(lblNombre);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenero.setBounds(50, 96, 100, 20);
		add(lblGenero);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(160, 65, 200, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		cbGenero = new JComboBox<String>();
		cbGenero.setBounds(160, 98, 150, 20);
		add(cbGenero);
		
		cbGenero.addItem("Terror");
		cbGenero.addItem("Acción");
		cbGenero.addItem("Suspenso");
		cbGenero.addItem("Romantico");
		
		lblIdNumber = new JLabel("");
		lblIdNumber.setBounds(160, 34, 100, 20);
		add(lblIdNumber);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setBounds(50, 150, 100, 30);
		add(btnAceptar);

	}
	
}
