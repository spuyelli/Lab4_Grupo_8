package negocioImpl;

import java.util.ArrayList;
import dao.AlumnoDao;
import daoImpl.AlumnoDaoImpl;
import entidades.Alumno;
import negocio.AlumnoNeg;

public class AlumnoNegImpl implements AlumnoNeg{
	private AlumnoDao aluDao = new AlumnoDaoImpl();
	public AlumnoNegImpl(){
		
	}
	
	public ArrayList<Alumno> listarAlumnos() {
		return (ArrayList<Alumno>) aluDao.readAll();
	}

	@Override
	public boolean actualizarAlumno(Alumno al) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarAlumno(Alumno alumno) {
		//if(validarDNILegajoAlum(alumno)) return -1;
		//DaoAlumno daoalumno = new DaoAlumno();
		//boolean estado = AlumnoDaoImpl //.agregarAlumno(alumno)? true : false;
		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		boolean estado = alumnoDao.agregarAlumno(alumno)? true : false;
		return estado;
	}

	@Override
	public Alumno select(int dni) {
		return aluDao.select(dni);
	}
	
	
}
