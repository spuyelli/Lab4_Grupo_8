package presentacion.vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidad.Persona;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel ContentPane;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;
	
	//	MODIFICAR
	private JButton btnModificar;
	JList<Persona> jlistPersonas;
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtDni;
	

	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		setTitle("Programa");
		getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);

		mntmAgregar = new JMenuItem("Agregar");
		mnPersona.add(mntmAgregar);

		mntmModificar = new JMenuItem("Modificar");
		mnPersona.add(mntmModificar);

		mntmEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mntmEliminar);

		mntmListar = new JMenuItem("Listar");
		mnPersona.add(mntmListar);

		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPane);
		getContentPane().setLayout(null);

		this.setVisible(true);
	}

	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}

	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

	public JPanel getPanel() {
		return ContentPane;
	}

	public void setPanel(JPanel contentPane) {
		this.ContentPane = contentPane;
	}

	public void panelModificar(ArrayList<Persona> alPersonas) {
		
		ContentPane.removeAll();
		
		jlistPersonas = new JList<Persona>();
		jlistPersonas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollPane = new JScrollPane();
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
		
		DefaultListModel<Persona> dlModel = new DefaultListModel<Persona>();
		for (Persona var : alPersonas) 
			dlModel.addElement(var);
		
		jlistPersonas.setModel(dlModel);
		
		ContentPane.repaint();
		ContentPane.revalidate();
		setContentPane(ContentPane);
		this.setVisible(true);
		
		/*
		ContentPane.removeAll();
		PanelModificarPersona panelModificar = new PanelModificarPersona(alPersonas);
		// panel = new PanelModificarPersona();
		ContentPane.add(panelModificar);
		ContentPane.repaint();
		ContentPane.revalidate();
		setContentPane(ContentPane);
		*/
	}
	
	public void getSelectModificar() {
		
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

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String Nombre) {
		this.txtNombre.setText(Nombre);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String Apellido) {
		this.txtApellido.setText(Apellido);
	}

	public String getTxtDni() {
		return txtDni.getText();
	}

	public void setTxtDni(String Dni) {
		this.txtDni.setText(Dni);
	}

		
}