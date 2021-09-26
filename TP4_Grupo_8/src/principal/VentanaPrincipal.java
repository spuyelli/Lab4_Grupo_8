package principal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblGrupo;
	private JButton btnEj1;
	private JButton btnEj2;
	private JButton btnEj3;

	public VentanaPrincipal() {
		setMaximumSize(new Dimension(500, 500));
		setResizable(false);
		setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Principal");
		getContentPane().setLayout(null);

		lblGrupo = new JLabel();
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrupo.setText("GRUPO NRO: 8");
		lblGrupo.setBounds(65, 70, 140, 30);

		btnEj1 = new JButton();
		btnEj1.setText("Ejercicio 1");
		btnEj1.setBounds(180, 150, 140, 30);
		btnEj1.addActionListener(this);

		btnEj2 = new JButton();
		btnEj2.setText("Ejercicio 2");
		btnEj2.setBounds(180, 230, 140, 30);
		btnEj2.addActionListener(this);

		btnEj3 = new JButton();
		btnEj3.setText("Ejercicio 3");
		btnEj3.setBounds(180, 310, 140, 30);
		btnEj3.addActionListener(this);

		getContentPane().add(lblGrupo);
		getContentPane().add(btnEj1);
		getContentPane().add(btnEj2);
		getContentPane().add(btnEj3);
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	public void actionPerformed(ActionEvent e) {

		switch (((JButton) e.getSource()).getText()) {
		case "Ejercicio 1":
			VentanaEj1 V1 = new VentanaEj1();
			V1.cambiarVisibilidad(true);
			break;
		case "Ejercicio 2":
			VentanaEj2 V2 = new VentanaEj2();
			V2.cambiarVisibilidad(true);
			break;
		case "Ejercicio 3":
			VentanaEj3 V3 = new VentanaEj3();
			V3.cambiarVisibilidad(true);
			break;
		default:
			break;
		}
	}

}

// ----------OLD LOGIC----------
/*
 * class eventoBoton implements ActionListener {
 * 
 * private String botonID;
 * 
 * public eventoBoton(String botonID) { this.botonID = botonID; }
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * switch (botonID) { case "btnEj1": VentanaEj1 V1 = new VentanaEj1();
 * V1.cambiarVisibilidad(true); break; case "btnEj2": VentanaEj2 V2 = new
 * VentanaEj2(); V2.cambiarVisibilidad(true); break; case "btnEj3": VentanaEj3
 * V3 = new VentanaEj3(); V3.cambiarVisibilidad(true); break; default: break; }
 * }
 * 
 * }
 */