package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> arrayPersonas;

	public Controlador(VentanaPrincipal vista, PersonaNegocio negocio) {
		this.ventanaPrincipal = vista;
		this.pNeg = negocio;
		this.ventanaPrincipal.getMntmAgregar().addActionListener(alAgregar -> ventanaAgregar(alAgregar));
		this.ventanaPrincipal.getMntmModificar().addActionListener(alModificar -> ventanaModificar(alModificar));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(alEliminar -> ventanaEliminar(alEliminar));
		this.ventanaPrincipal.getMntmListar().addActionListener(alListar -> ventanaListar(alListar));

	}

	private void ventanaAgregar(ActionEvent alAgregar) {
		// TODO Auto-generated method stub
		return;
	}

	private void ventanaModificar(ActionEvent alModificar) {
		this.arrayPersonas = (ArrayList<Persona>) pNeg.readAll();
		ventanaPrincipal.panelModificar(this.arrayPersonas);

		this.ventanaPrincipal.getJlistPersonas()
				.addListSelectionListener(alJLPersonas -> seleccionPersona(alJLPersonas));
		this.ventanaPrincipal.getBtnModificar().addActionListener(alBtnModificar -> modificarPersona(alBtnModificar));

		// PanelModificarPersona pmp = new PanelModificarPersona(arrayPersonas);
		// pmp.getBtnModificar().addActionListener(alBtnModificar->modificarPersona(alBtnModificar,pmp.getTxtDni().getText(),pmp.getTxtNombre().getText(),pmp.getTxtApellido().getText(),
		// pmp.getJlistPersonas().getSelectedValue()));
	}

	private Object seleccionPersona(ListSelectionEvent alJLPersonas) {
		this.ventanaPrincipal
				.setTxtDni(this.ventanaPrincipal.getJlistPersonas().getSelectedValue().getDni().toString());
		this.ventanaPrincipal
				.setTxtNombre(this.ventanaPrincipal.getJlistPersonas().getSelectedValue().getNombre().toString());
		this.ventanaPrincipal
				.setTxtApellido(this.ventanaPrincipal.getJlistPersonas().getSelectedValue().getApellido().toString());
		return null;
	}

	private Object modificarPersona(ActionEvent alBtnModificar) {
		if (this.ventanaPrincipal.getJlistPersonas().getSelectedIndex() > 0) {
			if(pNeg.update(new Persona(this.ventanaPrincipal.getJlistPersonas().getSelectedValue().getDni().toString(),
					this.ventanaPrincipal.getTxtNombre(), this.ventanaPrincipal.getTxtApellido()))) {
				this.ventanaPrincipal.setTxtDni("");
				this.ventanaPrincipal.setTxtNombre("");
				this.ventanaPrincipal.setTxtApellido("");
				this.ventanaPrincipal.getJlistPersonas().setSelectedIndex(-1);
			}
		}
		return null;
	}

	private void ventanaEliminar(ActionEvent alEliminar) {
		// TODO Auto-generated method stub
		return;
	}

	private void ventanaListar(ActionEvent alListar) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void inicializar() {
		// TODO Auto-generated method stub
	}

}
