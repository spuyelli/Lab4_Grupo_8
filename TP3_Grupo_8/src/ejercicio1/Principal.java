package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
			
		Archivo archivo = new Archivo();

		archivo.setRuta("resourses/Personas.txt"); ///Este archivo se encuentra en el proyecto
		TreeSet<Persona> set = archivo.lee_lineas();
		
		archivo.setRuta("resourses/Resultado.txt");
		archivo.escribe_lineas(set);

		Iterator<Persona> It = set.iterator();
		while (It.hasNext()) {
			Persona p = (Persona) It.next();
			System.out.println(p.toString());
		}

	}

}
