package presentacion.vista;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import entidad.Persona;

public class PanelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private JList<Persona> jlistPersonas;
	private JScrollPane scrollPane;

	private DefaultListModel<Persona> dlModel = new DefaultListModel<Persona>();
	private ArrayList<Persona> arrayList;

	public PanelModificarPersona(ArrayList<Persona> arrayPersonas) {
		setMaximumSize(new Dimension(450, 230));
		setLayout(null);
		setBounds(0, 0, 450, 230);

		jlistPersonas = new JList<Persona>();
		jlistPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistPersonas.setLayoutOrientation(JList.VERTICAL);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jlistPersonas);
		scrollPane.setBounds(35, 20, 374, 170);
		add(scrollPane);

		txtNombre = new JTextField();
		txtNombre.setName("txtNombre");
		txtNombre.setBounds(35, 200, 96, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setName("txtApellido");
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

	public void llenarTabla() {
		dlModel.clear();
		if (arrayList != null) {
			for (Persona var : arrayList)
				dlModel.addElement(var);

			jlistPersonas.setModel(dlModel);
		}
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JList<Persona> getJlistPersonas() {
		return jlistPersonas;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String Nombre) {
		this.txtNombre.setText(Nombre);
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(String Apellido) {
		this.txtApellido.setText(Apellido);
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(String Dni) {
		this.txtDni.setText(Dni);
	}

	public ArrayList<Persona> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Persona> arrayList) {
		this.arrayList = arrayList;
	}

}
