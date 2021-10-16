package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.PanelPersonaAgregar;
import presentacion.vista.PanelListado;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelModificarPersona pnlModificarPersonas;
	private PanelPersonaAgregar pnlPeronaAgregar;

	private PersonaNegocio pNeg;
	private ArrayList<Persona> arrayPersonas;

	private PanelListado pnlListado;

	public Controlador(VentanaPrincipal vista, PersonaNegocio negocio) {
		// Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = negocio;

		this.ventanaPrincipal.getMntmAgregar().addActionListener(alAgregar -> ventanaAgregar(alAgregar));
		this.ventanaPrincipal.getMntmModificar().addActionListener(alModificar -> ventanaModificar(alModificar));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(alEliminar -> ventanaEliminar(alEliminar));
		this.ventanaPrincipal.getMntmListar().addActionListener(alListar -> ventanaListar(alListar));

		// ***** MODIFICAR PERSONA ****
		this.pnlModificarPersonas = new PanelModificarPersona(arrayPersonas);
		this.pnlModificarPersonas.getJlistPersonas()
				.addListSelectionListener(alJLPersonas -> seleccionPersona(alJLPersonas));
		this.pnlModificarPersonas.getBtnModificar()
				.addActionListener(alBtnModificar -> modificarPersona(alBtnModificar));

		// Instancio los paneles
		this.pnlListado = new PanelListado();

	}

	private void ventanaAgregar(ActionEvent alAgregar) {
		// TODO Auto-generated method stub
		return;
	}

	private void ventanaModificar(ActionEvent alModificar) {

		this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
		this.pnlModificarPersonas.setArrayList(arrayPersonas);
		this.pnlModificarPersonas.llenarTabla();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
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
		if (this.pnlModificarPersonas.getJlistPersonas().getSelectedIndex() > 0) {
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
		// TODO Auto-generated method stub
		return;
	}

	private void ventanaListar(ActionEvent alListar) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(this.pnlListado);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
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

	public void inicializar() {
		// TODO Auto-generated method stub
	}

}
