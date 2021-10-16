package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import entidad.Persona;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminarPersona extends JPanel {
	
		private JList <Persona> listEliminar;
		private JLabel lblEliminar;
		private JButton btnEliminar;
		private DefaultListModel<Persona> dlModel;
		private ArrayList<Persona> arrayList;
	
	public PanelEliminarPersona(ArrayList<Persona> arrayPersonas) {
		setLayout(null);
		
		listEliminar = new JList<Persona>();
		listEliminar.setBorder(new LineBorder(new Color(0, 0, 0)));
		listEliminar.setBounds(61, 61, 326, 160);
		add(listEliminar);
		
		lblEliminar = new JLabel("Eliminar Usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminar.setBounds(152, 36, 138, 14);
		add(lblEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(162, 250, 116, 23);
		add(btnEliminar);
		
		this.arrayList = arrayPersonas;
		dlModel = new DefaultListModel<Persona>();
		llenarLista();

		this.setVisible(true);

	}
	
	public void llenarLista() {
		dlModel.clear();
		if (arrayList != null) {
			for (Persona var : arrayList)
				dlModel.addElement(var);

			listEliminar.setModel(dlModel);
		}
	}

	public void setArrayList(ArrayList<Persona> arrayPersonas) {
		this.arrayList = arrayPersonas;
		
	}

	public JList<Persona> getListEliminar() {
		return listEliminar;
	}

	public void setListEliminar(JList<Persona> listEliminar) {
		this.listEliminar = listEliminar;
	}

	public JLabel getLblEliminar() {
		return lblEliminar;
	}

	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public DefaultListModel<Persona> getDlModel() {
		return dlModel;
	}

	public void setDlModel(DefaultListModel<Persona> dlModel) {
		this.dlModel = dlModel;
	}

	public ArrayList<Persona> getArrayList() {
		return arrayList;
	}
	
}
