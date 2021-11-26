package negocio;

import entidades.Alumno;
import daoImpl.AlumnoDaoImp;
public class alumnoNeg {

	boolean actualizarAlumno(Alumno al) {
		AlumnoDaoImp dao = new AlumnoDaoImp();
		return	dao.actualizarAlumno(al);
	}
	
}
