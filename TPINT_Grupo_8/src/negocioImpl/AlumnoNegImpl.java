package negocioImpl;

import java.util.ArrayList;
import dao.AlumnoDao;
import daoImpl.AlumnoDaoImpl;
import daoImpl.Conexion;
import daoImpl.CursoDaoImpl;
import entidades.Alumno;
import entidades.Curso;
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
		aluDao.ModificarAlumno(al);
		return false;
	}

	@Override
	public boolean agregarAlumno(Alumno alumno) {
		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		return alumnoDao.agregarAlumno(alumno);
	}

	@Override
	public Alumno select(int dni) {
		return aluDao.select(dni);
	}

	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso) {

		AlumnoDao alumnoDao = new AlumnoDaoImpl();
		boolean estado = alumnoDao.agregarAlumnoACurso(alumno, curso)? true : false;
		return false;
	}



	
	public Alumno buscarAlumno(int dni) {
		System.out.print("esto es negocio buscar alumno:" + dni);
	return aluDao.BuscarAlumno(dni);
		
	}
	
	
}
