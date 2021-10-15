package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import entidad.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

public class PanelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	JButton btnModificar;
	private JList<Persona> jlistPersonas;
	private JScrollPane scrollPane;
	
	DefaultListModel<Persona> dlModel;
	private ArrayList<Persona> arrayList;

	public PanelModificarPersona(ArrayList<Persona> arrayPersonas) {
		setMaximumSize(new Dimension(450, 230));
		setLayout(null);
		setBounds(0,0,450,230);
				
		jlistPersonas = new JList<Persona>();
		jlistPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistPersonas.setLayoutOrientation(JList.VERTICAL);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jlistPersonas);
		scrollPane.setBounds(35, 20, 374, 170);
		add(scrollPane);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(35, 200, 96, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(135, 200, 95, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(234, 200, 80, 20);
		txtDni.setEditable(false);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(320, 200, 89, 23);
		add(btnModificar);
		
		this.arrayList = arrayPersonas;
		dlModel = new DefaultListModel<Persona>();
		llenarTabla();
		
		this.setVisible(true);
	}
	
	void llenarTabla() {
		dlModel.clear();
		
		for (Persona var : arrayList) 
			dlModel.addElement(var);
		
		jlistPersonas.setModel(dlModel);    
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JList<Persona> getJlistPersonas() {
		return jlistPersonas;
	}

	public void setJlistPersonas(JList<Persona> jlistPersonas) {
		this.jlistPersonas = jlistPersonas;
	}
	
}
