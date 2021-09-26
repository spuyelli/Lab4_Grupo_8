package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaEj2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JTextField textPromedio;
	private JTextField textCondicion;
	private JPanel panelEntrada;
	private JLabel lblNota1;
	private JLabel lblNota2;
	private JLabel lblNota3;
	private JLabel lblTP;
	private JComboBox<String> cbTP;
	private GroupLayout gl_panelEntrada;
	private JPanel panelSalida;
	private JLabel lblPromedio;
	private JLabel lblCondicion;
	private GroupLayout gl_panelSalida;
	private JButton btnCalcular;
	private JButton btnNuevo;
	private JButton btnSalir;

	public VentanaEj2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("Promedio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelEntrada = new JPanel();
		panelEntrada.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 255)), "Notas del estudiante",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEntrada.setBounds(35, 33, 275, 213);
		contentPane.add(panelEntrada);

		lblNota1 = new JLabel("Nota 1");

		lblNota2 = new JLabel("Nota 2");

		lblNota3 = new JLabel("Nota 3");

		lblTP = new JLabel("TP");

		textNota1 = new JTextField();
		textNota1.setColumns(10);

		textNota2 = new JTextField();
		textNota2.setColumns(10);

		textNota3 = new JTextField();
		textNota3.setColumns(10);

		cbTP = new JComboBox<String>();
		cbTP.setModel(new DefaultComboBoxModel<String>(new String[] { "Aprobado", "Desaprobado" }));

		gl_panelEntrada = new GroupLayout(panelEntrada);
		gl_panelEntrada.setHorizontalGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEntrada.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING).addComponent(lblNota1)
								.addComponent(lblNota2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNota3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(58)
						.addGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbTP, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textNota2).addComponent(textNota1).addComponent(textNota3))
						.addContainerGap(71, Short.MAX_VALUE)));
		gl_panelEntrada.setVerticalGroup(gl_panelEntrada.createParallelGroup(Alignment.LEADING).addGroup(gl_panelEntrada
				.createSequentialGroup().addGap(20)
				.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE).addComponent(lblNota1).addComponent(
						textNota1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE).addComponent(lblNota2).addComponent(
						textNota2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE).addComponent(lblNota3).addComponent(
						textNota3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_panelEntrada.createParallelGroup(Alignment.BASELINE).addComponent(lblTP).addComponent(cbTP,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		panelEntrada.setLayout(gl_panelEntrada);

		panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 255)), "Notas del estudiante",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSalida.setBounds(35, 270, 275, 141);
		contentPane.add(panelSalida);

		lblPromedio = new JLabel("Promedio");

		lblCondicion = new JLabel("Condici\u00F3n");

		textPromedio = new JTextField();
		textPromedio.setEditable(false);
		textPromedio.setColumns(10);

		textCondicion = new JTextField();
		textCondicion.setEditable(false);
		textCondicion.setColumns(10);
		gl_panelSalida = new GroupLayout(panelSalida);
		gl_panelSalida.setHorizontalGroup(gl_panelSalida.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSalida.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSalida.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPromedio, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCondicion, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_panelSalida.createParallelGroup(Alignment.LEADING)
								.addComponent(textCondicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textPromedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(71, Short.MAX_VALUE)));
		gl_panelSalida.setVerticalGroup(gl_panelSalida.createParallelGroup(Alignment.LEADING).addGroup(gl_panelSalida
				.createSequentialGroup().addGap(20)
				.addGroup(gl_panelSalida.createParallelGroup(Alignment.BASELINE).addComponent(lblPromedio).addComponent(
						textPromedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_panelSalida.createParallelGroup(Alignment.BASELINE).addComponent(lblCondicion)
						.addComponent(textCondicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE)));
		panelSalida.setLayout(gl_panelSalida);

		btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(341, 60, 116, 40);
		contentPane.add(btnCalcular);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(341, 121, 116, 40);
		contentPane.add(btnNuevo);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(341, 182, 116, 40);
		contentPane.add(btnSalir);

		btnCalcular.addActionListener(this);
		btnNuevo.addActionListener(this);
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "NUEVO":
			textNota1.setText("");
			textNota2.setText("");
			textNota3.setText("");
			textPromedio.setText("");
			textCondicion.setText("");
			cbTP.setSelectedItem("Aprobado");
			break;
		case "CALCULAR":
			String condicion;

			int nota1 = Integer.parseInt(textNota1.getText());
			int nota2 = Integer.parseInt(textNota2.getText());
			int nota3 = Integer.parseInt(textNota3.getText());
			float promedio = ((float) nota1 + (float) nota2 + (float) nota3) / 3;
			if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8) {
				condicion = "Promocionado";
			} else if ((nota1 >= 6) && (nota2 >= 6) && (nota3 >= 6)) {
				condicion = "Regular";
			} else {
				condicion = "Libre";
			}

			if (cbTP.getSelectedItem().toString() == "Desaprobado") {
				// SI O SI ES LIBRE DE CONDICION
				condicion = "Libre";
			}
			textPromedio.setText(String.valueOf(promedio));
			textCondicion.setText(condicion);
			break;
		case "SALIR":
			dispose();
			break;

		default:
			break;
		}

	}
}
