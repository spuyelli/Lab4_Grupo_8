package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class mainEjercicio1_a {

	public static void main(String[] args) {
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();

		profesores.add(new Profesor("Titular", 5, "Juan", 32));
		profesores.add(new Profesor("Suplente", 1, "Carla", 25));
		profesores.add(new Profesor("Titular", 15, "Omar", 50));
		profesores.add(new Profesor("Titular", 6, "Andres", 30));
		profesores.add(new Profesor("Suplente", 22, "Nora", 46));

		Iterator<Profesor> ITprofesor = profesores.iterator();
		while (ITprofesor.hasNext()) {
			Profesor p = (Profesor) ITprofesor.next();
			System.out.println(p.toString());
		}

	}

}
