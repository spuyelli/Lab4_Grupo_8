package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.TreeSet;

public class Archivo {
	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean existe() {
		File archivo = new File(ruta);
		if (archivo.exists()) {
			return true;
		}
		return false;
	}

	public boolean crearArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public TreeSet<Persona> lee_lineas() {
		FileReader entrada;
		Persona persona;
		TreeSet<Persona> set = new TreeSet<>();
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea = miBuffer.readLine();
			while (linea != null) {
				if (!linea.isEmpty()) {
					try {
						if (!Persona.verificarDniInvalido(linea.substring(linea.lastIndexOf('-') + 1))) {
							persona = new Persona(linea);
							set.add(persona);
						}
					} catch (DNIInvalido e) {
						e.printStackTrace();
					}
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		} catch (Exception e) {
			System.out.println("No se encontró el archivo - ");
			e.printStackTrace();
		}
		return set;
	}

	public void escribe_lineas(TreeSet<Persona> set) {
		FileWriter entrada;
		BufferedWriter miBuffer;

		try {
			entrada = new FileWriter(ruta, true);
			miBuffer = new BufferedWriter(entrada);

			Iterator<Persona> ITpersona = set.iterator();
			while (ITpersona.hasNext()) {
				Persona p = (Persona) ITpersona.next();
				miBuffer.write(p.toString() + "\n");
			}
			miBuffer.close();
			entrada.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
