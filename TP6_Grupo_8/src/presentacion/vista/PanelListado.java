package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

public class PanelListado extends JPanel {
	
	private static final long serialVersionUID = 1L;

	//private JFrame frmAgenda;
	private JTable tablaPersonas;
	
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"DNI", "Nombre", "Apellido"};

	
	 public PanelListado() {
	
		super();
		initialize();
	}

	
	private void initialize() 
	{
	
		this.setBounds(100, 100, 460, 229);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 460, 229);
		panel.setForeground(Color.LIGHT_GRAY);
		this.add(panel);
		panel.setLayout(null);
		setMaximumSize(new Dimension(450, 230));
		setLayout(null);
		setBounds(0,0,450,230);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(26, 47, 383, 126);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(true);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		
		spPersonas.setViewportView(tablaPersonas);
	}

	public void show()
	{
		this.setVisible(true);
	}
	

	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String ape = p.getApellido();
			String dni = p.getDni();
			Object[] fila = {dni, nombre, ape};
			this.getModelPersonas().addRow(fila);
		}
		
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
