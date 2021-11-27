package negocioImpl;

import java.util.ArrayList;

import dao.AlumnoDao;
import daoImpl.AlumnoDaoImp;
import entidades.Alumno;
import negocio.AlumnoNeg;

public class AlumnoNegImp implements AlumnoNeg{
	
	AlumnoDao alumnoDao = new AlumnoDaoImp();

	@Override
	public boolean actualizarAlumno(Alumno al) {
		AlumnoDaoImp dao = new AlumnoDaoImp();
		return	dao.actualizarAlumno(al);
	}
	
	public ArrayList<Alumno> listarAlumnos(){
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		lista = (ArrayList<Alumno>)alumnoDao.readAll();
		return lista;
	}


}
