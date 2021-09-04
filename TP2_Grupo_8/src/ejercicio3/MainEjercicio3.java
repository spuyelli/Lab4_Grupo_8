package ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio3 {


	public static void main(String[] args) {	
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		
		edificios.add(new Polideportivo(3000.0, "CAMPO ABIERTO", "POLI PACHECO"));
		edificios.add(new Polideportivo(5000.0, "EDIFICIO CERRADO", "POLI TIGRE"));
		edificios.add(new Polideportivo(4000.0, "MICROESTADIO", "POLI TORCUATO"));
		edificios.add(new EdificioOficinas(6000.0, 150 ));
		edificios.add(new EdificioOficinas(7000.0, 200 ));
		
		
		Iterator<Edificio> ItEdificio = edificios.iterator(); 
		while ( ItEdificio.hasNext()) {
			Edificio e= (Edificio) ItEdificio.next();
			System.out.println( e.toString());
		}	
	}

}
