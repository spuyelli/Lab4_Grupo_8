package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Persona p = new Persona();
		
		p.setDNI("12a3");
		try {
			System.out.println(p.verificarDniInvalido());
		} catch (DNIInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
