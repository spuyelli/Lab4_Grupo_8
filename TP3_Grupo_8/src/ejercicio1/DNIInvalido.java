package ejercicio1;

public class DNIInvalido extends Exception{
	
	public DNIInvalido() {}

	@Override
	public String getMessage() {
		return "Excepción. DNI inválido.";
	}
	
	
}
