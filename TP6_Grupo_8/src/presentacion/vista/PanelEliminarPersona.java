package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import entidad.Persona;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<Persona> listEliminar;
	private JLabel lblEliminar;
	private JButton btnEliminar;
	private DefaultListModel<Persona> dlModel;
	private ArrayList<Persona> arrayList;
	private JScrollPane scrollPane;

	public PanelEliminarPersona(ArrayList<Persona> arrayPersonas) {
		setMaximumSize(new Dimension(450, 230));
		setLayout(null);
		setBounds(0, 0, 450, 230);

		listEliminar = new JList<Persona>();
		listEliminar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEliminar.setLayoutOrientation(JList.VERTICAL);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(listEliminar);
		scrollPane.setBounds(35, 35, 374, 145);
		add(scrollPane);

		lblEliminar = new JLabel("Eliminar Usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminar.setBounds(162, 15, 138, 14);
		add(lblEliminar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(293, 196, 116, 23);
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

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

}
