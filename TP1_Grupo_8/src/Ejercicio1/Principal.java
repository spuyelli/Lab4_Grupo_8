package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Empleado[] vempleado = new Empleado[5];
		vempleado[0] = new Empleado("Pablo", 25);
		vempleado[1] = new Empleado("Juan", 22);
		vempleado[2] = new Empleado();
		vempleado[3] = new Empleado();
		vempleado[4] = new Empleado("María", 36);

		for (Empleado empleado : vempleado) {
			System.out.println(empleado.toString());
		}

		System.out.println(Empleado.devuelveProximoID());
	}

}
