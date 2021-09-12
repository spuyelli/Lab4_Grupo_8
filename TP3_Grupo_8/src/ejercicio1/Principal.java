package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		/*		TEST DE EXCEPCION 
		Persona p = new Persona();
		
		p.setDNI("12a3");
		try {
			System.out.println(p.verificarDniInvalido());
		} catch (DNIInvalido e) {
			e.printStackTrace();
		}
		*/
		
		Archivo archivo = new Archivo();

		archivo.setRuta("Personas.txt"); ///Este archivo se encuentra en el proyecto
		archivo.lee_lineas();
	}

}
