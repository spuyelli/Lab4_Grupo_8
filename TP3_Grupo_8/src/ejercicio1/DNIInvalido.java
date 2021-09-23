package ejercicio1;

import java.io.IOException;

public class DNIInvalido extends IOException{
	
	private static final long serialVersionUID = 1L;

	public DNIInvalido() {}

	@Override
	public String getMessage() {
		return "Excepción. DNI inválido.";
	}
	
	
}
