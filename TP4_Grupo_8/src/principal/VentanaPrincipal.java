package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;

public class VentanaPrincipal extends JFrame {

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
		btnEj1.addActionListener(new eventoBoton(1));
		
		btnEj2 = new JButton();
		btnEj2.setText("Ejercicio 2");
		btnEj2.setBounds(180, 230, 140, 30);
		btnEj2.addActionListener(new eventoBoton(2));
		
		btnEj3 = new JButton();
		btnEj3.setText("Ejercicio 3");
		btnEj3.setBounds(180, 310, 140, 30);
		btnEj3.addActionListener(new eventoBoton(3));

		getContentPane().add(lblGrupo);
		getContentPane().add(btnEj1);
		getContentPane().add(btnEj2);
		getContentPane().add(btnEj3);
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}
}

class eventoBoton implements ActionListener {

	private int ejercicio;
	
	public eventoBoton(int ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ejercicio) {
		case 1:
			VentanaEj1 V1 = new VentanaEj1();
			V1.cambiarVisibilidad(true);
			break;
		case 2:
			VentanaEj2 V2 = new VentanaEj2();
			V2.cambiarVisibilidad(true);
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}

}
