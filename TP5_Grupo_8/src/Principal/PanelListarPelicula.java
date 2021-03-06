package Principal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelListarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblPeliculas;
	private JList<Peliculas> jlistPeliculas;
	private ArrayList<Peliculas> arrayList;
	
	public PanelListarPelicula(DefaultListModel<Peliculas> dlModel) {
		setLayout(null);
		setBounds(10, 10, 450, 300);

		lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPeliculas.setBounds(40, 100, 90, 20);
		add(lblPeliculas);

		jlistPeliculas = new JList<Peliculas>();
		jlistPeliculas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jlistPeliculas);
		scrollPane.setBounds(140, 21, 250, 200);
		add(scrollPane);
		
		arrayList = Collections.list(dlModel.elements());
		dlModel.clear();
		Collections.sort(arrayList);
		
		for (Peliculas var : arrayList) 
			dlModel.addElement(var);
		
		jlistPeliculas.setModel(dlModel);    
	}
}

