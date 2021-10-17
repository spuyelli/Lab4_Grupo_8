package presentacion.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.PanelPersonaAgregar;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListado;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelModificarPersona pnlModificarPersonas;
	private PanelPersonaAgregar pnlPersonaAgregar;
	private PanelEliminarPersona pnlEliminarPersonas;
	private PanelListado pnlListado;

	private PersonaNegocio pNeg;
	private ArrayList<Persona> arrayPersonas;

	public Controlador(VentanaPrincipal vista, PersonaNegocio negocio) {
		// Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = negocio;

		this.ventanaPrincipal.getMntmAgregar().addActionListener(alAgregar -> ventanaAgregar(alAgregar));
		this.ventanaPrincipal.getMntmModificar().addActionListener(alModificar -> ventanaModificar(alModificar));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(alEliminar -> ventanaEliminar(alEliminar));
		this.ventanaPrincipal.getMntmListar().addActionListener(alListar -> ventanaListar(alListar));

		// ***** AGREGAR PERSONA *****
		this.pnlPersonaAgregar = new PanelPersonaAgregar();
		
		// ***** MODIFICAR PERSONA ****
		this.pnlModificarPersonas = new PanelModificarPersona(arrayPersonas);
		this.pnlModificarPersonas.getJlistPersonas()
				.addListSelectionListener(alJLPersonas -> seleccionPersona(alJLPersonas));
		this.pnlModificarPersonas.getBtnModificar()
				.addActionListener(alBtnModificar -> modificarPersona(alBtnModificar));

		// Instancio los paneles
		this.pnlListado = new PanelListado();

		this.pnlEliminarPersonas = new PanelEliminarPersona(arrayPersonas);
		this.pnlEliminarPersonas.getBtnEliminar().addActionListener(alBtnEliminar -> eliminarPersona(alBtnEliminar));

	}

	private void ventanaAgregar(ActionEvent alAgregar) {
		refrescarPanel(this.pnlPersonaAgregar);
	}

	private void ventanaModificar(ActionEvent alModificar) {

		this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
		this.pnlModificarPersonas.setArrayList(arrayPersonas);
		this.pnlModificarPersonas.llenarTabla();
		refrescarPanel(this.pnlModificarPersonas);
	}

	private void seleccionPersona(ListSelectionEvent alJLPersonas) {
		try {
			this.pnlModificarPersonas
					.setTxtDni(this.pnlModificarPersonas.getJlistPersonas().getSelectedValue().getDni().toString());
			this.pnlModificarPersonas.setTxtNombre(
					this.pnlModificarPersonas.getJlistPersonas().getSelectedValue().getNombre().toString());
			this.pnlModificarPersonas.setTxtApellido(
					this.pnlModificarPersonas.getJlistPersonas().getSelectedValue().getApellido().toString());
		} catch (Exception e) {
			return;
		}
	}

	private void modificarPersona(ActionEvent alBtnModificar) {
		if (this.pnlModificarPersonas.getJlistPersonas().getSelectedIndex() > -1) {
			if (pNeg.update(
					new Persona(this.pnlModificarPersonas.getJlistPersonas().getSelectedValue().getDni().toString(),
							this.pnlModificarPersonas.getTxtNombre(), this.pnlModificarPersonas.getTxtApellido()))) {
				this.pnlModificarPersonas.setTxtDni("");
				this.pnlModificarPersonas.setTxtNombre("");
				this.pnlModificarPersonas.setTxtApellido("");
				this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
				this.pnlModificarPersonas.setArrayList(arrayPersonas);
				this.pnlModificarPersonas.llenarTabla();
				this.pnlModificarPersonas.getJlistPersonas().setSelectedIndex(-1);
			}
		}
	}

	private void ventanaEliminar(ActionEvent alEliminar) {

		this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
		this.pnlEliminarPersonas.setArrayList(arrayPersonas);
		this.pnlEliminarPersonas.llenarLista();

		refrescarPanel(this.pnlEliminarPersonas);
	}

	private void eliminarPersona(ActionEvent alBtnEliminar) {
		if (this.pnlEliminarPersonas.getListEliminar().getSelectedIndex() > -1) {
			// Elimina La persona seleccionada
			Persona p = this.pnlEliminarPersonas.getListEliminar().getSelectedValue();
			pNeg.delete(p);
			// Carga la lista
			this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
			this.pnlEliminarPersonas.setArrayList(arrayPersonas);
			this.pnlEliminarPersonas.llenarLista();
			this.pnlEliminarPersonas.getListEliminar().setSelectedIndex(-1);

			JOptionPane.showMessageDialog(null, "Se eliminó a la siguiente persona: \n" + p.toString());
		}
	}

	private void ventanaListar(ActionEvent alListar) {
		refrescarPanel(this.pnlListado);
		this.refrescarTabla();
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	private void refrescarTabla() {
		this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
		this.pnlListado.llenarTabla(this.arrayPersonas);
	}

	private void refrescarPanel(Component panel) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}

}
