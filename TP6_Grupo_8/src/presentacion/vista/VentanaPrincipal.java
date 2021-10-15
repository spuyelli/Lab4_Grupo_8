package presentacion.vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
}