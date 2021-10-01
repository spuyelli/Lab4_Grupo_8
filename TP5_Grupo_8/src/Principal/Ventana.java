package Principal;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DefaultListModel<Peliculas> dlModel = new DefaultListModel<Peliculas>();

	public Ventana() {

		setResizable(false);
		setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		setTitle("Programa");
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPeliculas = new JMenu("Pel\u00EDculas");
		menuBar.add(mnPeliculas);

		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				contentPane.removeAll();
				PanelAgregarPelicula panelAgregarPelicula = new PanelAgregarPelicula(dlModel);
				contentPane.add(panelAgregarPelicula);
				contentPane.repaint();
				contentPane.revalidate();

			}
		});
		mnPeliculas.add(mntmAgregar);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				contentPane.removeAll();
				PanelListarPelicula panelListarPelicula = new PanelListarPelicula(dlModel);
				contentPane.add(panelListarPelicula);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPeliculas.add(mntmListar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
}
