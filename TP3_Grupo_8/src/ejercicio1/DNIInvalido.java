package ejercicio1;

import java.io.IOException;

public class DNIInvalido extends IOException{
	
	public DNIInvalido() {}

	@Override
	public String getMessage() {
		return "Excepci�n. DNI inv�lido.";
	}
	
	
}
