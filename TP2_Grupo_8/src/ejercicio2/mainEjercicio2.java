///Probando GitHub, push 1.1 TP2
package ejercicio2;

import java.text.SimpleDateFormat;

public class mainEjercicio2 {

	public static void main(String[] args) {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		ProductoCongelado pCong;
		ProductoFresco pFresc;
		ProductoRefrigerado pRef;
		try {
			pCong = new ProductoCongelado(0, 3102, formatoFecha.parse("15/10/2021"));
			pFresc = new ProductoFresco(formatoFecha.parse("03/09/2021"), "Argentina" , 4005, formatoFecha.parse("20/10/2021"));
			pRef = new ProductoRefrigerado(2, 50078, formatoFecha.parse("01/11/2021"));
			
			System.out.println(pCong.toString());
			System.out.println(pFresc.toString());
			System.out.println(pRef.toString());
		}
		catch (Exception e) {
			System.out.println("Error al convertir fecha.");
		}

	}

}
