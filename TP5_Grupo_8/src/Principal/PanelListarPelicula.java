package Principal;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblPeliculas;
	private JList<Peliculas> jlistPeliculas;

	private DefaultListModel<Peliculas> dlModel;

	public PanelListarPelicula(DefaultListModel<Peliculas> dlModel) {
		setLayout(null);
		setBounds(10, 10, 450, 300);

		lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeliculas.setBounds(40, 100, 90, 20);
		add(lblPeliculas);

		jlistPeliculas = new JList<Peliculas>();
		jlistPeliculas.setBounds(140, 21, 250, 200);
		add(jlistPeliculas);

		this.dlModel = dlModel;
		jlistPeliculas.setModel(this.dlModel);

	}

}
