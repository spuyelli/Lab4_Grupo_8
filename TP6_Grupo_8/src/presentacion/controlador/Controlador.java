package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener 
{
	private VentanaPrincipal ventanaPrincipal;
	
	public Controlador(VentanaPrincipal vista) {
		this.ventanaPrincipal = vista;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) { }
}
