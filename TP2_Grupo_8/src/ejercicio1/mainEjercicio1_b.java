package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		TreeSet<Profesor> profesores = new TreeSet<Profesor>();

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
		
		//		PUNTO 7
		Profesor Prof1 = new Profesor("Titular", 5, "Juan", 32);
		Profesor Prof2 = new Profesor("Titular", 5, "Juan", 32);
		
		if(Prof1.equals(Prof2)) {
			System.out.println("Es el mismo profesor");
		}
	
	}

}
